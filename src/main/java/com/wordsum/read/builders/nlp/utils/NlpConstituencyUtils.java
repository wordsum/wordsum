package com.wordsum.read.builders.nlp.utils;

import com.wordsum.read.models.nlp.NlpState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
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
 * Created by kalab on 8/13/16.
 *
 * This class's purpose is to provide utilities that checks the existence
 * of commonly used keys and values of Constituency parse map.
 *
 * This will help me also find clauses in the phrases.
 *
 * Write that these classes should take the NLP object and return some boolean
 *
 * write that loggoing will be needed and exceptions caught and a log made.
 *
 *
 */
public class NlpConstituencyUtils {


    private static Logger logger = LoggerFactory.getLogger(NlpConstituencyUtils.class);

    protected NlpConstituencyUtils() {
    }

    /**
     * A method to check to see if the NlpState has an object has a Constituency state.
     * It only returns a boolean. This is to check of existence to help us be able to verify and
     * have better fault tolerant.
     *
     * @param nlpState This is the NlpState object that contains the dependency state object.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasConstituency(NlpState nlpState){

        boolean is = true;

        if(nlpState.getPennTreebankState() == null){
            logger.debug("Penn Treebank State is null.");
            is = false;
        } else if (nlpState.getPennTreebankState().getTreeBranchesMap().isEmpty()){
            logger.debug("Penn Treebank State is empty.");
            is = false;
        }

        return is;
    }

    /**
     * Tis method will check to see if the string passed is a leaf.
     * This method will only return a boolean and is a simple check
     * that can be used to make the code more fault tolerant.
     *
     * @param nlpState The state with the leaf we want to check to see if exists.
     * @param keyLeaf The key of hte the leaf we are assuming exists.
     * @return boolean if the leaf exists.
     */
    public static boolean isLeaf(NlpState nlpState, String keyLeaf){

        boolean is = false;

        if(hasConstituency(nlpState)) {

            if (keyLeaf.endsWith("leaf")) {

                if (nlpState.getPennTreebankState().getTreeBranchesMap().containsKey(keyLeaf)) {
                    is = true;
                } else {
                    logger.debug("isLeafPhrase [" + keyLeaf + "] is not found.");
                }

            }

        }

        return is;
    }


    /**
     * Tis method will check to see if the string passed is a node.
     * This method will only return a boolean and is a simple check
     * that can be used to make the code more fault tolerant.
     *
     * @param nlpState The state with the leaf we want to check to see if exists.
     * @param keyNode The key of the the node we are assuming exists.
     * @return boolean if the leaf exists.
     */
    public static boolean isNode(NlpState nlpState, String keyNode){

        boolean is = false;

        if(hasConstituency(nlpState)){

            if(keyNode.endsWith("node")) {

                if (nlpState.getPennTreebankState().getTreeBranchesMap().containsKey(keyNode)) {
                    is = true;
                } else {
                    logger.debug("isNodePhase [" + keyNode + "] is not found.");
                }

            }

        }

        return is;
    }


    /**
     * The phrase of a leaf to return.
     *
     * @param nlpState The NlpState to search.
     * @param leaf e The known leaf..
     * @return
     */
    public static String getPhrase(NlpState nlpState, String leaf){

        String phrase = null;

        if(isLeaf(nlpState, leaf)){
            phrase = nlpState.getPennTreebankState().getTreeBranchesMap().get(leaf).get("phrase");
        }

        return phrase;
    }


    /**
     * A method to get all the phases in the tree in one array.
     *
     * @param nlpState The nlp state with the penntree leafs.
     * @return A string array of the leaf keys.
     */
    public static ArrayList<String> getLeafsKeys(NlpState nlpState){

        ArrayList<String> leafs = new ArrayList<String>();

        if(hasConstituency(nlpState)){

            for(String key: nlpState.getPennTreebankState().getTreeBranchesMap().keySet()){

                if(key.endsWith("_leaf")){

                    leafs.add(key);

                }

            }

        }

        return leafs;
    }


    /**
     * The method will find some phrase and return the key value pairs of the root.
     *
     * @param nlpState The NlpState to search.
     * @param node The node that was defined by the leaf.
     * @return
     */
    public static Map<String, String> getNodeKeyValue(NlpState nlpState, String node){

        Map<String, String> keyValue = null;

        if(isNode(nlpState, node)){

            keyValue = nlpState.getPennTreebankState().getTreeBranchesMap().get(node);

        }

        return keyValue;
    }


    /**
     * A method to get the nodes and subnodes of a leaf and return a hashmap of all its nodes.
     * I can see using this node as some way to be able to file define phrases of phrases as they are nested.
     *
     * @param nlpState The nlpState that contains and constituency parsed maps.
     * @param leaf The root key that nodes will be pulled from.
     * @return HashMap<String, HashMap<String, String>> of nodes and sub nodes.
     */
    public static Map<String, Map<String, String>> getLeafNodes(NlpState nlpState, String leaf){

        Map<String, Map<String, String>> leafNodes = new HashMap<String, Map<String, String>>();

        if(isLeaf(nlpState, leaf)){

            for(Map.Entry<String, Map<String, String>> nodes: nlpState.getPennTreebankState().getTreeBranchesMap().entrySet()) {

                if(nodes.getKey().startsWith(leaf.replace("_leaf", ""))){

                    logger.debug("getLeafNodes() found " + nodes.getKey());
                    Map<String, String> node = nlpState.getPennTreebankState().getTreeBranchesMap().get(nodes.getKey());
                    leafNodes.put(nodes.getKey(),node);

                }



            }
        }

        return leafNodes;
    }

}
