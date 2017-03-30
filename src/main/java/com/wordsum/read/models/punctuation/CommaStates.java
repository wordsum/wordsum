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

public enum CommaStates {

    MARK(","),
    SERIAL_COMMA("([a-z]+)((?:,\\s*[a-z]+)*)\\s+(and|or)\\s+([a-z]+)"),


    NO_MARK("^[^\\,]*$"),
    ANTI(null);


    private final String commaState;

    private CommaStates(String commaState) {
            this.commaState = commaState;
        }

    public String getCommaState(){
            return this.commaState;
        }


    private static HashMap<String, String> commaStatesMap = new HashMap<String, String>(5);

    public static HashMap<String, String> getHashMap(){

        commaStatesMap.put(MARK.name(), MARK.commaState);
        commaStatesMap.put(SERIAL_COMMA.name(), SERIAL_COMMA.commaState);
        commaStatesMap.put(ANTI.name(), ANTI.commaState);

        return commaStatesMap;
    }



}
