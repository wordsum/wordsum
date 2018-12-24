package com.wordsum.process.read.models.nlp;

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

/**
 * Enum to classify all these things:
 */
public enum PennTreebankValueEnum {


    CC("1", "Coordinating conjunction"),
    CD("2", "Cardinal number"),
    DT("3", "Determiner"),
    EX("4", "Existential there"),
    FW("5", "Foreign word"),
    IN("6", "Preposition or subordinating conjunction"),
    JJ("7", "Adjective"),
    JJR("8", "Adjective, comparative"),
    JJS("9", "Adjective, superlative"),
    LS("10", "List item marker"),
    MD("11", "Modal"),
    NN("12", "Noun, singular or mass"),
    NNS("13", "Noun, plural"),
    NNP("14", "Proper noun, singular"),
    NNPS("15", "Proper noun, plural"),
    PDT("16", "Predeterminer"),
    POS("17", "Possessive ending"),
    PRP("18", "Personal pronoun"),
    PRP$("19", "Possessive pronoun"),
    RB("20", "Adverb"),
    RBR("21", "Adverb, comparative"),
    RBS("22", "Adverb, superlative"),
    RP("23", "Particle"),
    SYM("24", "Symbol"),
    TO("25", "to"),
    UH("26", "Interjection"),
    VB("27", "Verb, base form"),
    VBD("28", "Verb, past tense"),
    VBG("29", "Verb, gerund or present participle"),
    VBN("30", "Verb, past participle"),
    VBP("31", "Verb, non-3rd person singular present"),
    VBZ("32", "Verb, 3rd person singular present"),
    WDT("33", "Wh-determiner"),
    WP("34", "Wh-pronoun"),
    WP$("35", "Possessive wh-pronoun"),
    WRB("36", "Wh-adverb");

    String id;
    String definition;

    ArrayList<String> array = new ArrayList<>();

    PennTreebankValueEnum(String id, String definition) {
        this.id = id;
        this.definition = definition;
        this.array.add(0, this.id);
        this.array.add(1, this.definition);
    }

    public String getOrder() {
        return this.id;
    }

    public String getDefinition() {
        return this.definition;
    }

    public ArrayList<String> getArray() {
        return this.array;
    }

}
