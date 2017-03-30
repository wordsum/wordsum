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

public enum SubordinateConjunctionEnum {

    AFTER("after"),
    ALTHOUGH("although"),
    AS("as"),
    BECAUSE("because"),
    BEFORE("before"),
    EVEN_THOUGH("even though"),
    IF("if"),
    SINCE("since"),
    THOUGH("though"),
    UNLESS("unless"),
    UNTIL("until"),
    WHEN("when"),
    WHENEVER("whenever"),
    WHEREAS("whereas"),
    WHEREVER("wherever"),
    WHILE("while"),
    HOW("how"),
    TILL("till"),
    IN_AS_MUCH("in as much"),
    AS_IF("as if"),
    IN_ORDER("in order"),
    THAT("that"),
    AS_LONG_AS("as long as"),
    LEST("lest"),
    AS_MUCH_AS("as much as"),
    NOW_THAT("now that"),
    WHERE("where"),
    AS_SOON_AS("as soon as"),
    AS_THOUGH("as though"),
    SO_THAT("so that"),
    THAN("than"),
    EVEN_IF("even if");



    String complex;
    ArrayList<String> complexes = new ArrayList<>();


    SubordinateConjunctionEnum(String complex) {
        this.complex = complex;
        this.complexes.add(0, this.complex);
    }

    public String getObject() {
        return complex;
    }

    public ArrayList<String> getObjects() {
        return this.complexes;
    }


}
