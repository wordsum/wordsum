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

public enum PrepositionsEnum {

    TIME_1("after"),
    TIME_2("around"),
    TIME_3("at"),
    TIME_4("before"),
    TIME_5("between"),
    TIME_6("during"),
    TIME_7("from"),
    TIME_8("on"),
    TIME_9("until"),
    TIME_10("at"),
    TIME_11("in"),
    TIME_12("for"),
    TIME_13("from"),
    TIME_14("since"),
    TIME_15("during"),
    TIME_16("within"),
    PLACE_1("above"),
    PLACE_2("across"),
    PLACE_3("against"),
    PLACE_4("along"),
    PLACE_5("among"),
    PLACE_6("around"),
    PLACE_7("at"),
    PLACE_8("behind"),
    PLACE_9("below"),
    PLACE_10("beneath"),
    PLACE_11("beside"),
    PLACE_12("between"),
    PLACE_13("beyond"),
    PLACE_14("by"),
    PLACE_15("down"),
    PLACE_16("in"),
    PLACE_17("inside"),
    PLACE_18("into"),
    PLACE_19("near"),
    PLACE_20("off"),
    PLACE_21("on"),
    PLACE_22("opposite"),
    PLACE_23("out"),
    PLACE_24("over"),
    PLACE_25("past"),
    PLACE_26("through"),
    PLACE_27("to"),
    PLACE_28("toward"),
    PLACE_29("under"),
    PLACE_30("underneath"),
    MOVEMENT_1("at"),
    MOVEMENT_2("for"),
    MOVEMENT_3("on"),
    MOVEMENT_4("to"),
    MOVEMENT_5("in"),
    MOVEMENT_6("into"),
    MOVEMENT_7("onto"),
    MOVEMENT_8("between"),
    MANNER_1("by"),
    MANNER_2("on"),
    MANNER_3("in"),
    MANNER_4("like"),
    MANNER_5("with"),
    OTHER_1("by"),
    OTHER_2("with "),
    OTHER_3("of"),
    OTHER_4("for"),
    OTHER_5("by"),
    OTHER_6("like"),
    OTHER_7("as");



    String prepositional;
    ArrayList<String> prepositionals = new ArrayList<>();


    PrepositionsEnum(String prepositional) {
        this.prepositional = prepositional;
        this.prepositionals.add(0, this.prepositional);
    }

    public String getObject() {
        return prepositional;
    }

    public ArrayList<String> getObjects() {
        return this.prepositionals;
    }



}
