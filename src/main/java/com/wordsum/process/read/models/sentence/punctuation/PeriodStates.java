package com.wordsum.process.read.models.sentence.punctuation;

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

/**
 * Fixes for next revision:
 * Period state exists in error with some ending periods. May be abbreviation.
 */
public enum PeriodStates {

    MARK("."),
    PERIOD("[a-zA-Z0-9]+\\.$"),
    INITIAL("([A-Z]\\.)+[\\.]{0,1}"),
    ELLIPSIS("([A-Za-z]*\\.\\.\\.[A-Za-z]*)+[\\\\.|\\\\!|\\\\?]{0,1}"),

    NO_MARK("^[^\\.]*$"),
    ANTI(null);

    private final String periodState;

    private PeriodStates(String periodState) {
        this.periodState = periodState;
    }

    public String getPeriodState(){
        return this.periodState;
    }

    private static HashMap<String, String> periodStatesMap = new HashMap<String, String>(5);

    public static HashMap<String, String> getHashMap(){
        periodStatesMap.put(MARK.name(), MARK.periodState);
        periodStatesMap.put(PERIOD.name(), PERIOD.periodState);
        periodStatesMap.put(INITIAL.name(), INITIAL.periodState);
        periodStatesMap.put(ELLIPSIS.name(), ELLIPSIS.periodState);
        periodStatesMap.put(ANTI.name(), ANTI.periodState);

        return periodStatesMap;
    }


}
