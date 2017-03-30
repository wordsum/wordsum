package com.wordsum.write.utils.sentence.parts;

import java.util.ArrayList;

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

public enum AdjectiveEnum {


    DENOMINAL_1("biological"),
    COMPAIRING_1("better"),
    COMPOUND_1("sexy-little-thing");


    String adjective;
    ArrayList<String> adjectives = new ArrayList<>();


    AdjectiveEnum(String adjective) {
        this.adjective = adjective;
        this.adjectives.add(0, this.adjective);
    }

    public String getObject() {
        return adjective;
    }

    public ArrayList<String> getObjects() {
        return this.adjectives;
    }


}
