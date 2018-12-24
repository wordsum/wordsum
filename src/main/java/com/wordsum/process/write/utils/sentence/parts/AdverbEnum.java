package com.wordsum.process.write.utils.sentence.parts;

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

public enum AdverbEnum {

    HOW_1("sadly"),
    HOW_OFTEN_1("continuously"),
    HOW_MUCH_1("frequently"),
    WHERE_1("here"),
    WHEN_1("early");

    String adverb;
    ArrayList<String> adverbs = new ArrayList<>();


    AdverbEnum(String adverb) {
        this.adverb = adverb;
        this.adverbs.add(0, this.adverb);
    }

    public String getObject() {
        return adverb;
    }

    public ArrayList<String> getObjects() {
        return this.adverbs;
    }
    
}
