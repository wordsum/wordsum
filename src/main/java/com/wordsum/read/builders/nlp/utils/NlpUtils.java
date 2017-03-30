package com.wordsum.read.builders.nlp.utils;

import com.wordsum.read.models.nlp.NlpState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * The purpose of these utilities will to use the existing parser utilities in
 * combination to verify anomalies and correct them if possible.
 *
 * I hope using the parse data will improve the probability of choosing the right
 * subject verb and object in a sentence or the lack there of.
 *
 *
 */
public class NlpUtils {


    private static Logger logger = LoggerFactory.getLogger(NlpUtils.class);

    protected NlpUtils() {
    }

    /**
     * The method take a NlpState and an array like defined in SubjectVerbObjectEnum.java
     * and check to see it compares with what is thought to be the nlp equivalent.
     *
     * @param nlpState
     * @param arrayDep
     * @return
     */
    public static boolean compareDepToConstWordTag(NlpState nlpState, ArrayList<String> arrayDep){
        boolean compares = false;



        return compares;
    }


}
