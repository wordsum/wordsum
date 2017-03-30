package com.wordsum.read.models.sentence.structure.compound;

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
 * Created by kalab on 7/30/16.
 *
 * 1.
 *      a."s.node.0.leaf": { "phrase": "S" }
 * 2.
 *      a. "s.node.0.leaf": { "phrase": "NP" }
 * 2. "s.node.1.leaf": { "phrase": "VP" }
 *
 * 3.  "s.node.1.node": { "CC": "and" }
 * or
 * 3.  "s.node.1.node.2.leaf": {"phrase": "SBAR"} and  "s.node.1.node.2.node.0.node": {"IN": X }
 *
 */
public enum CompoundConstituencyEnum {


    NP("s.node.0.leaf","phrase"),
    S("s.node.0.leaf","phrase"),

    VP("s.node.1.leaf","phrase"),

    CC("s.node.1.node","phrase"),

    SBAR("s.node.1.node.2.leaf","phrase"),
    IN("s.node.1.node.2.node.0.node","X");

    private final String node;
    private final String value;

    private CompoundConstituencyEnum(String node, String value) {
        this.node = node;
        this.value = value;
    }

    public String getNode(){
        return this.node;
    }

    public String getValue(){
        return this.value;
    }

}
