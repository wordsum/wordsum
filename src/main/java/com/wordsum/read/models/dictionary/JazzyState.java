package com.wordsum.read.models.dictionary;

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

public class JazzyState {


    private String text;
    private HashMap<String, List<String>> misspelledWords;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<String, List<String>> getMisspelledWords() {
        return misspelledWords;
    }

    public void setMisspelledWords(HashMap<String, List<String>> misspelledWords) {
        this.misspelledWords = misspelledWords;
    }

}
