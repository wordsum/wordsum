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

public enum SubjectEnum {

    //PERSONS

    NOUN_PRO_I("I"),
    NOUN_PRO_SINGULAR_1("she"),
    NOUN_PRO_SINGULAR_2("he"),
    NOUN_PRO_SINGULAR_3("it"),
    NOUN_PRO_SINGULAR_4("you"),
    NOUN_PRO_PLURAL_1("we"),
    NOUN_PRO_PLURAL_2("they"),
    NOUN_PRO_PLURAL_3("you"),

    NOUN_PROPER_PERSON_SINGULAR_1("Jill"),
    NOUN_PROPER_PERSON_SINGULAR_2("Jack"),
    NOUN_PROPER_PERSON_SINGULAR_4("Sue"),
    NOUN_PROPER_PLACE_SINGULAR_1("Portland"),
    NOUN_PROPER_PLACE_SINGULAR_2("Oregon"),
    NOUN_PROPER_PLACE_SINGULAR_3("Yosemite"),
    NOUN_PROPER_THING_SINGULAR_1("Rumba"),

    NOUN_PROPER_PERSON_COMPOUND_SPACE_SINGULAR_1("Jill Wright"),
    NOUN_PROPER_PERSON_COMPOUND_SPACE_SINGULAR_2("Jack Wrong"),
    NOUN_PROPER_PERSON_COMPOUND_SPACE_SINGULAR_4("Sue You"),
    NOUN_PROPER_PLACE_COMPOUND_SPACE_SINGULAR_1("South Weber"),
    NOUN_PROPER_PLACE_COMPOUND_SPACE_SINGULAR_2("New York"),
    NOUN_PROPER_PLACE_COMPOUND_SPACE_SINGULAR_3("Brice Canyon"),
    NOUN_PROPER_THING_COMPOUND_SPACE_SINGULAR_1("Yoyodine Yo"),

    NOUN_PROPER_PERSON_COMPOUND_HYPHEN_SINGULAR_1("Sue-ann"),
    NOUN_PROPER_PLACE_COMPOUND_HYPHEN_SINGULAR_1("Mami-Dade"),
    NOUN_PROPER_THING_COMPOUND_HYPHEN_SINGULAR_1("Yo-yodine"),

    NOUN_PROPER_PERSON_COLLECTIVE_1("Illuminati"),
    NOUN_PROPER_PLACE_COLLECTIVE_1("Happyville"),
    NOUN_PROPER_THING_COLLECTIVE_1("Rumbas"),

    NOUN_PROPER_PERSON_COMPOUND_SPACE_COLLECTIVE_1("Democrat Gang"),
    NOUN_PROPER_PLACE_COMPOUND_SPACE_COLLECTIVE_1("Black Islands"),
    NOUN_PROPER_THING_COMPOUND_SPACE_COLLECTIVE_1("Rumba Swarm"),

    NOUN_PROPER_PERSON_COMPOUND_HYPHEN_COLLECTIVE_1("Illuminati-Alien"),
    NOUN_PROPER_PLACE_COMPOUND_HYPHEN_COLLECTIVE_1("Ricker-Turf"),
    NOUN_PROPER_THING_COMPOUND_HYPHEN_COLLECTIVE_1("Frankin-Bat"),

    NOUN_COMMON_PERSON_SINGULAR_1("woman"),
    NOUN_COMMON_PLACE_SINGULAR_1("home"),
    NOUN_COMMON_THING_SINGULAR_1("vacuum"),

    NOUN_COMMON_PERSON_COMPOUND_SPACE_SINGULAR_1("woman"),
    NOUN_COMMON_PLACE_COMPOUND_SPACE_SINGULAR_1("home"),
    NOUN_COMMON_THING_COMPOUND_SPACE_SINGULAR_1("vacuum"),

    NOUN_COMMON_PERSON_COMPOUND_HYPHEN_SINGULAR_1("woman"),
    NOUN_COMMON_PLACE_COMPOUND_HYPHEN_SINGULAR_1("home"),
    NOUN_COMMON_THING_COMPOUND_HYPHEN_SINGULAR_1("vacuum"),

    NOUN_COMMON_PERSON_COLLECTIVE_1("team"),
    NOUN_COMMON_PLACE_COLLECTIVE_1("range"),
    NOUN_COMMON_THING_COLLECTIVE_1("herd"),

    NOUN_COMMON_PERSON_COMPOUND_SPACE_COLLECTIVE_1("team"),
    NOUN_COMMON_PLACE_COMPOUND_SPACE_COLLECTIVE_1("range"),
    NOUN_COMMON_THING_COMPOUND_SPACE_COLLECTIVE_1("herd"),

    NOUN_COMMON_PERSON_COMPOUND_HYPHEN_COLLECTIVE_1("team"),
    NOUN_COMMON_PLACE_COMPOUND_HYPHEN_COLLECTIVE_1("range"),
    NOUN_COMMON_THING_COMPOUND_HYPHEN_COLLECTIVE_1("herd"),

    NOUN_ABSTRACT_SINGULAR_1("love"),
    NOUN_ABSTRACT_COLLECTIVE_1("love");


    String noun;
    ArrayList<String> nouns = new ArrayList<>();


    SubjectEnum(String noun) {
        this.noun = noun;
        this.nouns.add(0, this.noun);
    }

    public String getNoun() {
        return noun;
    }

    public ArrayList<String> getNouns() {
        return this.nouns;
    }


}
