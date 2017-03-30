package com.wordsum.read.models.sentence.structure.simple;

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

public class SubjectVerbObjectConEnumMap {

    public enum SubjectVerbObject_1 {
        Subject("s_node_0_leaf","NP"),
        Verb("s_node_1_leaf","VP"),
        Object("s_node_1_node_1_leaf","NP");

        String leaf;
        String leafTag;
        ArrayList<String> array = new ArrayList<>();

        SubjectVerbObject_1(String leaf, String leafTag) {
            this.leaf = leaf;
            this.leafTag = leafTag;
            this.array.add(0, this.leaf);
            this.array.add(1, this.leafTag);
        }

        public String getLeaf() {
            return leaf;
        }

        public String getLeafTag() {
            return leafTag;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }
}
