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

public enum PredicateEnum {

    ADJECTIVE_SINGULAR_1(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_SINGULAR_COLLECTIVE + " big"),
    ADJECTIVE_SINGULAR_2(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PAST_SINGULAR_COLLECTIVE + " big"),
    ADJECTIVE_SINGULAR_3(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_BE_PRESENT + " big"),
    ADJECTIVE_SINGULAR_4("looks big"),
    ADJECTIVE_SINGULAR_5("tastes big"),
    ADJECTIVE_SINGULAR_6("smells big"),
    ADJECTIVE_SINGULAR_7("feels big"),
    ADJECTIVE_SINGULAR_8("sounds big"),
    ADJECTIVE_SINGULAR_9("becomes big"),
    ADJECTIVE_SINGULAR_10("seems big"),
    ADJECTIVE_SINGULAR_11("appears big"),
    ADJECTIVE_SINGULAR_12("grows big"),
    ADJECTIVE_SINGULAR_13("continues big"),
    ADJECTIVE_SINGULAR_14("stays big"),
    ADJECTIVE_SINGULAR_15("turns big"),

    ADJECTIVE_I_1(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_I + " big"),
    ADJECTIVE_I_3(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_BE_PRESENT + " big"),
    ADJECTIVE_I_4("look big"),
    ADJECTIVE_I_5("taste big"),
    ADJECTIVE_I_6("smell big"),
    ADJECTIVE_I_7("feel big"),
    ADJECTIVE_I_8("sound big"),
    ADJECTIVE_I_9("become big"),
    ADJECTIVE_I_10("seem big"),
    ADJECTIVE_I_11("appear big"),
    ADJECTIVE_I_12("grow big"),
    ADJECTIVE_I_13("continue big"),
    ADJECTIVE_I_14("stay big"),
    ADJECTIVE_I_15("turn big"),

    ADJECTIVE_PLURAL_1(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PRESENT_PLURAL_COLLECTIVE + " big"),
    ADJECTIVE_PLURAL_2(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_PROGRESSIVE_PAST_PLURAL_COLLECTIVE + " big"),
    ADJECTIVE_PLURAL_3(VerbAuxiliaryEnum.VERB_AUXILIARY_PRIMARY_BE_PRESENT + " big"),
    ADJECTIVE_PLURAL_4("look big"),
    ADJECTIVE_PLURAL_5("taste big"),
    ADJECTIVE_PLURAL_6("smell big"),
    ADJECTIVE_PLURAL_7("feel big"),
    ADJECTIVE_PLURAL_8("sound big"),
    ADJECTIVE_PLURAL_9("become big"),
    ADJECTIVE_PLURAL_10("seem big"),
    ADJECTIVE_PLURAL_11("appear big"),
    ADJECTIVE_PLURAL_12("grow big"),
    ADJECTIVE_PLURAL_13("continue big"),
    ADJECTIVE_PLURAL_14("stay big"),
    ADJECTIVE_PLURAL_15("turn big"),

    NOMINATIVE_SINGULAR_1("is eleven years old"),
    NOMINATIVE_SINGULAR_2("was eleven years old"),
    NOMINATIVE_SINGULAR_3("used to be eleven years old"),

    NOMINATIVE_PLURAL_1("are eleven years old"),
    NOMINATIVE_PLURAL_2("was eleven years old"),
    NOMINATIVE_PLURAL_3("used to be eleven years old");

    String predicate;
    ArrayList<String> predicates = new ArrayList<>();


    PredicateEnum(String predicate) {
        this.predicate = predicate;
        this.predicates.add(0, this.predicate);
    }

    public String getPredicate() {
        return predicate;
    }

    public ArrayList<String> getPredicates() {
        return this.predicates;
    }

}
