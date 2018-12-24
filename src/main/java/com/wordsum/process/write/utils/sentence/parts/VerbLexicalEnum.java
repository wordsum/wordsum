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

/**
 *
 * This is an enum that will contain the lexical verb forms'
 * to be used with the utility WriteSentenceStructureTestData.java, TestDataVerbAuxiliary.java and
 * the enum TestDataNounEnum.java.. .
 *
 * This has been separated from the auxiliary verb forms for their patterns are different
 * and they will both be used differently.
 *
 * The current purpose and use case of this enum and the
 * other enums and the class is to generate test data for the models and builders
 * of the sentence model.
 *
 * enum pattern = <VERB>_<QUANTITY>(<VALUE>)
 * enum pattern example: VERB_LEXICAL_REGULAR_SIMPLE_PAST_SINGULAR_2("played and jumped")
 *          <VERB> = VERB_LEXICAL_REGULAR_SIMPLE_PAST_SINGULAR
 *          <QUANTITY> = 2
 *          <VALUE> = "played and jumped"
 *
 */
public enum VerbLexicalEnum {

    //  L E X I C A L   V E R B S

    //     R E G U L A R
    VERB_LEXICAL_REGULAR("play"),
    VERB_LEXICAL_REGULAR_INFINITIVE("to play"),
    // SINGULAR
    VERB_LEXICAL_REGULAR_SIMPLE_PAST_SINGULAR_1("played"),
    VERB_LEXICAL_REGULAR_SIMPLE_PRESENT_SINGULAR_FIRST_1("play"),
    VERB_LEXICAL_REGULAR_SIMPLE_PRESENT_SINGULAR_THIRD_1("plays"),
    VERB_LEXICAL_REGULAR_PARTICIPLE_PAST_SINGULAR_1("played"),
    VERB_LEXICAL_REGULAR_PARTICIPLE_PRESENT_SINGULAR_1("playing"),
    // PLURAL
    VERB_LEXICAL_REGULAR_SIMPLE_PAST_PLURAL_1("played"),
    VERB_LEXICAL_REGULAR_SIMPLE_PRESENT_PLURAL_FIRST_1("play"),
    VERB_LEXICAL_REGULAR_SIMPLE_PRESENT_PLURAL_THIRD_1("plays"),
    VERB_LEXICAL_REGULAR_SIMPLE_PRESENT_PLURAL_THIRD_THEY_1("play"),
    VERB_LEXICAL_REGULAR_PARTICIPLE_PAST_PLURAL_1("played"),
    VERB_LEXICAL_REGULAR_PARTICIPLE_PRESENT_PLURAL_1("playing"),
    //    I R R E G U L A R
    VERB_LEXICAL_IRREGULAR("write"),
    VERB_LEXICAL_IRREGULAR_INFINITIVE("to write"),
    // SINGULAR
    VERB_LEXICAL_IRREGULAR_SIMPLE_PAST_SINGULAR_1("wrote"),
    VERB_LEXICAL_IRREGULAR_SIMPLE_PRESENT_SINGULAR_FIRST_1("write"),
    VERB_LEXICAL_IRREGULAR_SIMPLE_PRESENT_SINGULAR_THIRD_1("writes"),
    VERB_LEXICAL_IRREGULAR_PARTICIPLE_PAST_SINGULAR_1("written"),
    VERB_LEXICAL_IRREGULAR_PARTICIPLE_PRESENT_SINGULAR_1("writing"),
    // PLURAL
    VERB_LEXICAL_IRREGULAR_SIMPLE_PAST_PLURAL_1("wrote"),
    VERB_LEXICAL_IRREGULAR_SIMPLE_PRESENT_PLURAL_FIRST_1("write"),
    VERB_LEXICAL_IRREGULAR_SIMPLE_PRESENT_PLURAL_THIRD_1("writes"),
    VERB_LEXICAL_IRREGULAR_SIMPLE_PRESENT_PLURAL_THEY_1("write"),
    VERB_LEXICAL_IRREGULAR_PARTICIPLE_PAST_PLURAL_1("written"),
    VERB_LEXICAL_IRREGULAR_PARTICIPLE_PRESENT_PLURAL_1("writing"),
    //   R E G U L A R  AND   I R R E G U L A R

    // SINGULAR
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PAST_SINGULAR_2("wrote and played"),
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PRESENT_SINGULAR_FIRST_2("write and play"),
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PRESENT_SINGULAR_THIRD_2("writes and plays"),
    VERB_LEXICAL_REGULAR_IRREGULAR_PARTICIPLE_PAST_SINGULAR_2("written and played"),
    VERB_LEXICAL_REGULAR_IRREGULAR_PARTICIPLE_PRESENT_SINGULAR_2("writing and playing"),
    // PLURAL
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PAST_PLURAL_2("wrote and played"),
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PRESENT_PLURAL_FIRST_2("write and play"),
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PRESENT_PLURAL_THIRD_2("writes and plays"),
    VERB_LEXICAL_REGULAR_IRREGULAR_SIMPLE_PRESENT_PLURAL_THEY_2("write and play"),
    VERB_LEXICAL_REGULAR_IRREGULAR_PARTICIPLE_PAST_PLURAL_2("written and played"),
    VERB_LEXICAL_REGULAR_IRREGULAR_PARTICIPLE_PRESENT_PLURAL_2("writing and playing");


    String verb;
    ArrayList<String> verbs = new ArrayList<>();


    VerbLexicalEnum(String verb) {
        this.verb = verb;
        this.verbs.add(0, this.verb);
    }

    public String getVerb() {
        return verb;
    }

    public ArrayList<String> getVerbs() {
        return this.verbs;
    }


}
