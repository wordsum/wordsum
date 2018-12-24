package com.wordsum.process.read.builders.sentence.punctuation;
import com.wordsum.process.read.models.sentence.punctuation.CaseState;
import com.wordsum.process.read.models.sentence.punctuation.CaseStates;
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


/**
 *
 */
public class CaseStateBuilder {

    private static Logger LOGGER = LoggerFactory.getLogger(CaseStateBuilder.class);

    private CaseStateBuilder() {

    }

    /**
     * Return a case state with the given sentence.
     * This is the main method to call for this builder class.
     *
     * If not cases exist in the sentence then a null is returned.
     * If a case is found then all known patters oare checked and antipatterns are
     * put in a list to be remembered as anit to what is known.
     *
     * @param sentence A string that may or many not contain a case.
     * @return caseState The state of the case in relation to the string sentence.
     **/
    public static CaseState createCaseState(String sentence){

        CaseState caseState = new CaseState();

        caseState.setPatterns(new HashMap<String, List<String>>());

        //Check to see if the sentence has a case. If it does
        // then parse with space and do something else just
        // return null for the state of case is null.
        if(CaseStateBuilder.isTextWithCase(sentence)){
            caseState = checkTextCaseState(caseState, sentence);
            caseState.setCaseStates(CaseStates.getHashMap());
        } else {
            caseState = null;
        }

        return caseState;
    }

    /**
     * Return a boolean if the most simple instance of the mark exists in a sentence.
     * This is only a check.
     * @param  text A string that may or may not contain a case.
     * @return          The boolean after the check.
     **/
    public static boolean isTextWithCase(String text){

        boolean find = false;

        if(text.contains(CaseStates.MARK.getCaseState())){
            find = true;
        }

        return find;
    }


    /**
     * Split a sentence with space and check each word and evaluate if
     * it has a case. If it does then check it against the patterns to
     * see if it is a known pattern. If not then save it as an anti-pattern.
     *
     * @param caseState
     * @param sentence
     * @return
     */
    public static CaseState checkTextCaseState(CaseState caseState, String sentence){

        String[] words =  sentence.split("\\s+");
        boolean isLastWord = false;

        for(int i = 0; i < words.length; i++){

            if(i == words.length - 1){
                isLastWord = true;
            }

            if(isTextWithCase(words[i])) {
                caseState = sortPatterns(caseState, words[i], isLastWord);
            } else {
                //Add No Case Pattern to AntiPattern


            }

        }

        return caseState;
    }


    /**
     * A pattern that compares known states and determines if it knows the pattern, and if doesn't
     * know that pattern.
     *
     * @param caseState The current CaseState object.
     * @param word This should only be a word and not a sentence or words.
     * @param isLastWord This boolean will help check for a sentence ending case and note others.
     * @return
     */
    public static CaseState sortPatterns(CaseState caseState, String word, boolean isLastWord){

        if(word.matches(CaseStates.SENTENCE_BEGIN.getCaseState())) {

            LOGGER.debug("Matched known SENTENCE_BEGIN Mark");
            caseState = CaseStateBuilder.addPattern(caseState, CaseStates.SENTENCE_BEGIN.name(), word);

        } else {

            //Remember antipattern found...
            LOGGER.debug("No match ANTI Mark.");
            caseState = CaseStateBuilder.addPattern(caseState, CaseStates.ANTI.name(), word);
        }

        return caseState;
    }

    /**
     * A method to check and log and add a pattern to anitpattern.
     *
     * @param caseState The current CaseState object.
     * @param pattern This should only be a word and not a sentence or words.
     */
    public static CaseState addPattern(CaseState caseState, String type, String pattern)
    {

        if(pattern.isEmpty()) {
            throw new IllegalArgumentException("Method addPattern String parameter pattern isEmpty().");
        } else if (caseState == null){
            throw new IllegalArgumentException("Method addPattern CaseState is null.");
        } else {


            if (caseState.getPatterns() == null) {
                caseState.setPatterns(new HashMap<String, List<String>>());
                LOGGER.debug("Creating Patterns ArrayList.");
            }

            //Check if there has been the type defined and if not then initialize and defined the first pattern.
            if(caseState.getPatterns().get(type) == null){

                List<String> value = new ArrayList<String>();
                value.add(pattern);

                caseState.addPatterns(type, value);


            } else {

                HashMap<String, List<String>> patterns = caseState.getPatterns();
                List<String> values = patterns.get(type);
                values.add(pattern);

                caseState.addPatterns(type, values);

            }

        }

        return caseState;
    }
}
