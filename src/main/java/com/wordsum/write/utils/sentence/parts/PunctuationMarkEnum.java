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

public enum PunctuationMarkEnum {

    PERIOD("."),
    COMMA(","),
    QUESTION("?"),
    EXCLAMATION("!"),
    COLON(":"),
    SEMICOLON(";"),
    ELLIPSIS("..."),
    DASH("-");

    String punctuationMark;
    ArrayList<String> punctuationMarks = new ArrayList<>();


    PunctuationMarkEnum(String punctuationMark) {
        this.punctuationMark = punctuationMark;
        this.punctuationMarks.add(0, this.punctuationMark);
    }

    public String getObject() {
        return punctuationMark;
    }

    public ArrayList<String> getObjects() {
        return this.punctuationMarks;
    }
    
}
