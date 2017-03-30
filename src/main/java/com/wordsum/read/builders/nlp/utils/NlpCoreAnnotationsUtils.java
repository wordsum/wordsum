package com.wordsum.read.builders.nlp.utils;

import com.wordsum.read.models.nlp.NlpState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;



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
 * This utils class will help check the existence and vlues of
 * CoreAnnotations in the nlp object.
 *
 * This utilities are intended to be used with the NlpTypeDependencyUtils
 * to check the TypeDependency returns.
 *
 */
public class NlpCoreAnnotationsUtils {

    private static Logger logger = LoggerFactory.getLogger(NlpCoreAnnotationsUtils.class);

    protected NlpCoreAnnotationsUtils(){

    }

    /**
     * A method to check to see if the NlpState has an object has CoreAnnotations..
     * It only returns a boolean. This is to check of existence to help us be able to verify and
     * have better fault tolerant.
     *
     * @param nlpState This is the NlpState object that contains the core annotations state object.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasCoreAnnotation(NlpState nlpState){

        boolean is = true;

        if(nlpState.getCoreAnnotations() == null){
            logger.debug("Core Annotations is null.");
            is = false;
        } else if (nlpState.getCoreAnnotations().isEmpty()){
            logger.debug("Core Annotations is empty.");
            is = false;
        }

        return is;
    }


    /**
     * This static method will check if a given text exists and return its pos. This will return on the first find.
     *
     * FEATURES: This method will need improvement if a word is used multiple time in a sentence.
     *
     * @param nlpState The nlpstate with the core annotations to check.
     * @param text The text of the pos to check..
     * @return
     */
    public static String getTextPos(NlpState nlpState, String text){

        String pos = null;

        if(hasCoreAnnotation(nlpState)){
            for(HashMap<String, String> element: nlpState.getCoreAnnotations()){
                if(element.get("text").equals(text)){
                    pos = element.get("pos");
                    break;
                }
            }
        }

        return pos;
    }

}
