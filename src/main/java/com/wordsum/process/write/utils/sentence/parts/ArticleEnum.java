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

public enum ArticleEnum {


    DEFINITE("the"),
    INDEFINITE_CONSONANT("a"),
    INDEFINITE_VOWEL("an");


    String article;
    ArrayList<String> articles = new ArrayList<>();


    ArticleEnum(String article) {
        this.article = article;
        this.articles.add(0, this.article);
    }

    public String getObject() {
        return article;
    }

    public ArrayList<String> getObjects() {
        return this.articles;
    }
    
}
