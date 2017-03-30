package com.wordsum.read.models.sentence.structure.simple;

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
 * *****************
 * S I M P L E:
 *******************
 *
 * "reln" {"tag"} = "root"
 * "dep" {"tag"} = "VBP" "VBD"
 *
 * "reln" {"tag"} = "nsubj"
 * "dep" {"tag"} = "PRP"
 *
 *  "reln": {"tag"} = "dobj"
 *  "dep": {tag"} = "NNS" "NN"
 *
 *  or
 *
 * "reln" {"tag"} = "nmod:*
 * "dep" {"tag"} = "NN"
 *
 * if
 * (If root is not a verb)
 * "reln": {"tag"} = "root"
 * "dep": {"tag"} = "NNS",
 * and
 *  "reln" {"tag"} = "compound"
 *  "dep": {"tag"} = "NNP",
 * then Subject is
 *  "dep" {"word"}
 *
 */
public enum SubjectVerbEnum {




}
