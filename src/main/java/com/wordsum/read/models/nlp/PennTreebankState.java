package com.wordsum.read.models.nlp;

import java.util.Map;

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
 * A model to define a constituency parsed PennTree
 * from a stream and built into this form.
 */
public class PennTreebankState {

    Map<String,Map<String, String>> treeBranchesMap;

    public Map<String, Map<String, String>> getTreeBranchesMap() {
        return treeBranchesMap;
    }

    public void setTreeBranchesMap(Map<String, Map<String, String>> treeBranchesMap) {
        this.treeBranchesMap = treeBranchesMap;
    }

    public void addTreeBranchesMap(String key, Map<String, String> value) {
        this.treeBranchesMap.put(key, value);
    }


}
