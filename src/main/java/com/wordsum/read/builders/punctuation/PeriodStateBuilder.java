package com.wordsum.read.builders.punctuation;

import com.wordsum.read.models.punctuation.PeriodState;
import com.wordsum.read.models.punctuation.PeriodStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



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

public class PeriodStateBuilder {

    private static Logger LOGGER = LoggerFactory.getLogger(PeriodStateBuilder.class);

    private PeriodStateBuilder() {

    }

    /**
     * Return a period state with the given sentence.
     * This is the main method to call for this builder class.
     *
     * If not periods exist in the sentence then a null is returned.
     * If a period is found then all known patters oare checked and antipatterns are
     * put in a list to be remembered as anit to what is known.
     *
     * @param sentence A string that may or many not contain a period.
     * @return periodState The state of the period in relation to the string sentence.
     **/
    public static PeriodState createPeriodState(String sentence){

        PeriodState periodState = new PeriodState();

        periodState.setPatterns(new HashMap<String, List<String>>());

        //Check to see if the sentence has a period. If it does
        // then parse with space and do something else just
        // return null for the state of period is null.
        if(PeriodStateBuilder.isTextWithPeriod(sentence)){
            periodState = checkTextPeriodState(periodState, sentence);
            periodState.setPeriodStates(PeriodStates.getHashMap());
        } else {
            periodState = null;
        }

        return periodState;
    }

    /**
     * Return a boolean if the most simple instance of the mark exists in a sentence.
     * This is only a check.
     * @param  text A string that may or may not contain a period.
     * @return          The boolean after the check.
     **/
    public static boolean isTextWithPeriod(String text){

        boolean find = false;

        if(text.contains(PeriodStates.MARK.getPeriodState())){
            find = true;
        }

        return find;
    }


    /**
     * Split a sentence with space and check each word and evaluate if
     * it has a period. If it does then check it against the patterns to
     * see if it is a known pattern. If not then save it as an anti-pattern.
     *
     * @param periodState
     * @param sentence
     * @return
     */
    public static PeriodState checkTextPeriodState(PeriodState periodState, String sentence){

        String[] words =  sentence.split("\\s+");
        boolean isLastWord = false;

        for(int i = 0; i < words.length; i++){

            if(i == words.length - 1){
                isLastWord = true;
            }

            if(isTextWithPeriod(words[i])) {
                periodState = sortPatterns(periodState, words[i], isLastWord);
            } else {
                //Add No Period Pattern to AntiPattern


            }

        }

        return periodState;
    }


    /**
     * A pattern that compares known states and determines if it knows the pattern, and if doesn't
     * know that pattern.
     *
     * @param periodState The current PeriodState object.
     * @param word This should only be a word and not a sentence or words.
     * @param isLastWord This boolean will help check for a sentence ending period and note others.
     * @return
     */
    public static PeriodState sortPatterns(PeriodState periodState, String word, boolean isLastWord){

        if(word.matches(PeriodStates.ELLIPSIS.getPeriodState())){

            LOGGER.debug("Matched known ELLIPSIS Mark");
            periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ELLIPSIS.name(), word);

        } else if (word.matches(PeriodStates.INITIAL.getPeriodState())){

            LOGGER.debug("Matched known INITIAL Mark");
            periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.INITIAL.name(), word);

        } else if (word.matches(PeriodStates.PERIOD.getPeriodState()) && isLastWord) {

            LOGGER.debug("Matched known PERIOD Mark.");
            periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.PERIOD.name(), word);

        } else {
            //Remember antipattern found...
            LOGGER.debug("No match ANTI Mark.");
            periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ANTI.name(), word);
        }

        return periodState;
    }

    /**
     * A method to check and log and add a pattern to anitpattern.
     *
     * @param periodState The current PeriodState object.
     * @param pattern This should only be a word and not a sentence or words.
     */
    public static PeriodState addPattern(PeriodState periodState, String type, String pattern)
    {

        if(pattern.isEmpty()) {
            throw new IllegalArgumentException("Method addPattern String parameter pattern isEmpty().");
        } else if (periodState == null){
            throw new IllegalArgumentException("Method addPattern PeriodState is null.");
        } else {


            if (periodState.getPatterns() == null) {
                periodState.setPatterns(new HashMap<String, List<String>>());
                LOGGER.debug("Creating Patterns ArrayList.");
            }

            //Check if there has been the type defined and if not then initialize and defined the first pattern.
            if(periodState.getPatterns().get(type) == null){

                List<String> value = new ArrayList<String>();
                value.add(pattern);

                periodState.addPatterns(type, value);


            } else {

                HashMap<String, List<String>> patterns = periodState.getPatterns();
                List<String> values = patterns.get(type);
                values.add(pattern);

                periodState.addPatterns(type, values);

            }

        }

        return periodState;
    }
}
