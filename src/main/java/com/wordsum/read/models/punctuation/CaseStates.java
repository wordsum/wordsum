package com.wordsum.read.models.punctuation;

import java.util.HashMap;

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

public enum CaseStates {


    MARK(","),
    SENTENCE_BEGIN("[A-Z]{1}[a-z]*"),


    NO_MARK("^[^\\,]*$"),
    ANTI("");


    private final String caseState;

    private CaseStates(String commaState) {
        this.caseState = commaState;
    }

    public String getCaseState(){
        return this.caseState;
    }


    private static HashMap<String, String> caseStatesMap = new HashMap<String, String>(5);

    public static HashMap<String, String> getHashMap(){

        caseStatesMap.put(MARK.name(), MARK.caseState);
        caseStatesMap.put(SENTENCE_BEGIN.name(), SENTENCE_BEGIN.caseState);
        caseStatesMap.put(ANTI.name(), ANTI.caseState);

        return caseStatesMap;
    }



}
