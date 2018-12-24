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

public enum VerbAuxiliaryEnum {

    //  A U X I L I A R Y
    // PRIMARY
    VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_SINGULAR_COLLECTIVE("is"),
    VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_PLURAL_COLLECTIVE("are"),
    VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_I("am"),
    VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PAST_SINGULAR_COLLECTIVE("was"),
    VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PAST_PLURAL_COLLECTIVE("were"),

    //
    VERB_AUXILIARY_PRIMARY_BE_PRESENT("be"),
    VERB_AUXILIARY_PRIMARY_BE_PAST("been"),
    VERB_AUXILIARY_PRIMARY_BE_PARTICIPLE("being"),

    VERB_AUXILIARY_PRIMARY_DO_PRESENT_SINGULAR("does"),
    VERB_AUXILIARY_PRIMARY_DO_PRESENT_PLURAL_COLLECTIVE("do"),
    VERB_AUXILIARY_PRIMARY_DO_PRESENT_I("do"),
    VERB_AUXILIARY_PRIMARY_DO_PAST_SINGULAR("did"),
    VERB_AUXILIARY_PRIMARY_DO_PAST_PLURAL_COLLECTIVE("did"),
    VERB_AUXILIARY_PRIMARY_DO_PAST_I("did"),
    VERB_AUXILIARY_PRIMARY_DO_PARTICIPLE("doing"),

    //  A U X I L I A R Y
    // MODAL
    VERB_AUXILIARY_MODAL_CAN("can"),
    VERB_AUXILIARY_MODAL_COULD("could"),
    VERB_AUXILIARY_MODAL_MUST("must"),
    VERB_AUXILIARY_MODAL_SHALL("shall"),
    VERB_AUXILIARY_MODAL_WILL("will"),
    VERB_AUXILIARY_MODAL_SHOULD("should"),
    VERB_AUXILIARY_MODAL_WOULD("would"),
    VERB_AUXILIARY_MODAL_MAY("may"),
    VERB_AUXILIARY_MODAL_MIGHT("might");

    String verb;
    ArrayList<String> verbs = new ArrayList<>();


    VerbAuxiliaryEnum(String verb) {
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
