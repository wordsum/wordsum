package com.wordsum.process.read.builders.sentence.punctuation;


import com.wordsum.process.read.models.sentence.punctuation.CommaState;
import com.wordsum.process.read.models.sentence.punctuation.CommaStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2017 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */

public class CommaStateBuilder {

    private static Logger LOGGER = LoggerFactory.getLogger(CommaStateBuilder.class);

    private CommaStateBuilder() {

    }

    /**
     * Return a comma state with the given sentence.
     * This is the main method to call for this builder class.
     *
     * If not commas exist in the sentence then a null is returned.
     * If a comma is found then all known patters oare checked and antipatterns are
     * put in a list to be remembered as anit to what is known.
     *
     * @param sentence A string that may or many not contain a comma.
     * @return commaState The state of the comma in relation to the string sentence.
     **/
    public static CommaState createCommaState(String sentence){

        CommaState commaState = new CommaState();

        commaState.setPatterns(new HashMap<String, List<String>>());

        //Check to see if the sentence has a comma. If it does
        // then parse with space and do something else just
        // return null for the state of comma is null.
        if(CommaStateBuilder.isTextWithComma(sentence)){
            commaState = sortPatterns(commaState, sentence);
            commaState.setCommaStates(CommaStates.getHashMap());
        } else {
            commaState = null;
        }

        return commaState;
    }

    /**
     * Return a boolean if the most simple instance of the mark exists in a sentence.
     * This is only a check.
     * @param  text A string that may or may not contain a comma.
     * @return          The boolean after the check.
     **/
    public static boolean isTextWithComma(String text){

        boolean find = false;

        if(text.contains(CommaStates.MARK.getCommaState())){
            find = true;
        }

        return find;
    }


    /**
     * A pattern that compares known states and determines if it knows the pattern, and if doesn't
     * know that pattern.
     *
     * @param commaState The current CommaState object.
     * @param sentence This should only be a word and not a sentence or words.
     * @return
     */
    public static CommaState sortPatterns(CommaState commaState, String sentence){

        Pattern patternSerial = Pattern.compile(CommaStates.SERIAL_COMMA.getCommaState());
        Matcher matcherSerial = patternSerial.matcher(sentence);

        if(matcherSerial.find()){

            LOGGER.debug("Matched known SERIAL_COMMA Mark");
            commaState = CommaStateBuilder.addPattern(commaState, CommaStates.SERIAL_COMMA.name(), matcherSerial.group());

        } else {
            //Remember antipattern found...
            LOGGER.debug("No match ANTI Mark.");
            commaState = CommaStateBuilder.addPattern(commaState, CommaStates.ANTI.name(), sentence);
        }

        return commaState;
    }

    /**
     * A method to check and log and add a pattern to anitpattern.
     *
     * @param commaState The current CommaState object.
     * @param pattern This should only be a word and not a sentence or words.
     */
    public static CommaState addPattern(CommaState commaState, String type, String pattern)
    {

        if(pattern.isEmpty()) {
            throw new IllegalArgumentException("Method addPattern String parameter pattern isEmpty().");
        } else if (commaState == null){
            throw new IllegalArgumentException("Method addPattern CommaState is null.");
        } else {


            if (commaState.getPatterns() == null) {
                commaState.setPatterns(new HashMap<String, List<String>>());
                LOGGER.debug("Creating Patterns ArrayList.");
            }

            //Check if there has been the type defined and if not then initialize and defined the first pattern.
            if(commaState.getPatterns().get(type) == null){

                List<String> value = new ArrayList<String>();
                value.add(pattern);

                commaState.addPatterns(type, value);


            } else {

                HashMap<String, List<String>> patterns = commaState.getPatterns();
                List<String> values = patterns.get(type);
                values.add(pattern);

                commaState.addPatterns(type, values);

            }

        }

        return commaState;
    }
}
