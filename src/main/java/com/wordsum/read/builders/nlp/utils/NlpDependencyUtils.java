package com.wordsum.read.builders.nlp.utils;

import com.wordsum.read.models.nlp.NlpState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



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
 * This class's purpose is to provide utilities that checks the existence
 * of commonly used keys and values of dependency parse map.
 *
 * This will help me also find subject, verb and objects of sentences by being a utility
 * to check the existence of keys and values.
 *
 * Write that these classes should take the NLP object and return some boolean
 *
 * write that logging will be needed and exceptions caught and a log made.
 *
 * PARAMETERS
 *
 * Every method should only accept an NLP Object and will check the state of the dependency of that object.
 *
 *
 */
public class NlpDependencyUtils {


    private static Logger logger = LoggerFactory.getLogger(NlpDependencyUtils.class);


    protected NlpDependencyUtils() {
    }


    /**
     * A method to check to see if the NlpState has an object has a Dependency state.
     * It only returns a boolean. This is to check of existence to help us be able to verify and
     * have better fault tolerant.
     *
     * @param nlpState This is the NlpState object that contains the dependency state object.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasDependency(NlpState nlpState){

        boolean is = true;

        if(nlpState.getTypedDependency() == null){
            logger.debug("Typed Dependency is null.");
            is = false;
        } else if (nlpState.getTypedDependency().isEmpty()){
            logger.debug("Typed Dependency is empty.");
            is = false;
        }

        return is;
    }


    /**
     * A method to check to see if the NlpState's Dependency state key has tag value..
     * It only returns a boolean. This is to check of existence to help us be able to verify and
     * have better fault tolerant methods
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     * @param dependencyKey The key's tag.
     * @param tagValue The string value that we are searching to find.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasDependencyKeyTagValue(NlpState nlpState, String dependencyKey, String tagValue){

        boolean is = false;

        if (hasDependency(nlpState)){
            for(HashMap<String, HashMap<String, String>> typedDependency: nlpState.getTypedDependency()) {

                if (typedDependency.get(dependencyKey).isEmpty()) {
                    logger.debug("hasDependencyKeyTagValue typedDependency.get(\"" + dependencyKey + "\").isEmpty()");
                } else {
                    HashMap<String, String> key = typedDependency.get(dependencyKey);
                    if (key.isEmpty()) {
                        logger.debug("hasDependencyKeyTagValue " + dependencyKey + ".isEmpty()");
                    } else {
                        if (key.get("tag") == null){
                            logger.debug("hasDependencyKeyTagValue " + dependencyKey + ".get(\"tag\") is null");
                        } else if (key.get("tag").isEmpty()) {
                            logger.debug("hasDependencyKeyTagValue " + dependencyKey + ".get(\"tag\").isEmpty()");
                        } else {
                            if (key.get("tag").contains(tagValue)) {
                                is = true;
                            }
                        }
                    }
                }
            }
        }

        return is;
    }

    /**
     * This method gets the root entity if it exists. If finds root by checking the nlp typeDependency
     * and get the index 0 object to later use.
     *
     * @param nlpState = The NlpState object containing the typedDependency.
     * @return
     */
    public static HashMap<String, HashMap<String, String>> getTypeDependencyRootEntity(NlpState nlpState){

        HashMap<String, HashMap<String, String>> typedDependency = null;

        for(HashMap<String, HashMap<String, String>> typedDependencyEntity: nlpState.getTypedDependency()) {

            HashMap<String, String> gov = typedDependencyEntity.get("gov");

            if (gov.containsKey("index")) {

                if(gov.get("index").equals("0")){
                    typedDependency = typedDependencyEntity;
                    break;
                }

            }

        }

        return typedDependency;
    }

    /**
     * This method gets the dependency HashMap with the index number passed or returns null.
     *
     * @param nlpState = The NlpState object containing the typedDependency.
     * @param depIndex = The number in the index to return.
     * @return HashMap<String, HashMap<String, String>> = The hashmap with null or the object at the index.
     */
    public static HashMap<String, HashMap<String, String>> getTypeDependencyEntityByDepIndex(NlpState nlpState, String depIndex){

        HashMap<String, HashMap<String, String>> typedDependency = null;

        for(HashMap<String, HashMap<String, String>> typedDependencyEntity: nlpState.getTypedDependency()) {

            HashMap<String, String> dep = typedDependencyEntity.get("dep");

            if (dep.containsKey("index")) {
                if(dep.get("index").equals(depIndex)){
                    typedDependency = typedDependencyEntity;
                    break;
                }

            }

        }

        return typedDependency;
    }













    /**
     * THESE ARE OLD WAYS OF TYRING TO GET DATA FROM TYPED DEPENDENCE.
     *
     * I TRIED TO REWRITE TO ARRAYS AND NOW REALIZE THEY COULD BE WORTHLESS.
     *
     * I WRITE THIS TO MARK AND LABEL AND MAYBE LATER REMOVE.
     */

    /**
     * A sstatic method to return the reln tag's dep word.
     *
     * @param nlpState The nlp state model to be checked.
     * @param relnTagValue The tag and the value to be check and got.
     * @return String
     */
    public static List<String> getDepWord(NlpState nlpState, String relnTagValue) {

        List<String> words = new ArrayList<String>();

        if (NlpDependencyUtils.hasDependency(nlpState)){

            if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln",  relnTagValue)) {

                for(HashMap<String, HashMap<String, String>> typedDependency: nlpState.getTypedDependency()) {

                    HashMap<String, String> reln = typedDependency.get("reln");

                    if (reln.get("tag").contains( relnTagValue)) {
                        HashMap<String, String> dep = typedDependency.get("dep");
                        words.add(dep.get("word"));
                    }

                }
            }

        }

        return words;
    }

    /**
     * A static method to return a relnTags dep lemma.
     *
     * @param nlpState The nlp state model to be checked.
     * @param relnTagValue The tag and the value to be check and got.
     * @return String
     */
    public static List<String> getDepLemma(NlpState nlpState, String relnTagValue) {

        List<String> lemma = new ArrayList<String>();

        if (NlpDependencyUtils.hasDependency(nlpState)){

            if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln",  relnTagValue)) {

                for(HashMap<String, HashMap<String, String>> typedDependency: nlpState.getTypedDependency()) {

                    HashMap<String, String> reln = typedDependency.get("reln");

                    if (reln.get("tag").contains(relnTagValue)) {
                        HashMap<String, String> dep = typedDependency.get("dep");

                        if(dep.get("lemma") != null) {
                            lemma.add(dep.get("lemma"));
                        }
                    }


                }
            }

        }


        return lemma;
    }


    /**
     * A static method that uses the reln tag to find and get the gov workd.
     *
     * @param nlpState The nlp state model to be checked.
     * @param relnTagValue The tag and the value to be check and got.
     * @return String
     */
    public static List<String> getGovWord(NlpState nlpState, String relnTagValue) {

        List<String> word = new ArrayList<String>();

        if (NlpDependencyUtils.hasDependency(nlpState)){

            if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln",  relnTagValue)) {

                for(HashMap<String, HashMap<String, String>> typedDependency: nlpState.getTypedDependency()) {

                    HashMap<String, String> reln = typedDependency.get("reln");

                    if (reln.get("tag").contains( relnTagValue)) {
                        HashMap<String, String> dep = typedDependency.get("gov");
                        word.add(dep.get("word"));
                    }

                }

            }

        }

        return word;
    }

    /**
     * A static method to return a dep tag's gov index.
     * @param nlpState The nlp state model to be checked.
     * @param relnTagValue The tag and the value to be check and got.
     * @return String
     */
    public static String getGovIndex(NlpState nlpState, String relnTagValue) {

        String index = null;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln",  relnTagValue)) {

                for(HashMap<String, HashMap<String, String>> typedDependency: nlpState.getTypedDependency()) {

                    HashMap<String, String> reln = typedDependency.get("reln");

                    if (reln.get("tag").contains( relnTagValue)) {
                        HashMap<String, String> dep = typedDependency.get("gov");
                        index = dep.get("index");
                        break;
                    }

                }

            }

        }


        return index;
    }




}
