package com.wordsum.read.builders.nlp;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wordsum.read.models.nlp.PennTreebankState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 *  This class recursively reads a constituency parsed sentence.
 *  It creates keys of phrases.
 *
 *  The PennTree
 *  	CC 	Coordinating conjunction
 *      CD 	Cardinal number
 *      DT 	Determiner
 *      EX 	Existential there
 *      FW 	Foreign word
 *      IN 	Preposition or subordinating conjunction
 *      JJ 	Adjective
 *      JJR 	Adjective, comparative
 *      JJS 	Adjective, superlative
 *      LS 	List item marker
 *      MD 	Modal
 *      NN 	Noun, singular or mass
 *      NNS 	Noun, plural
 *      NNP 	Proper noun, singular
 *      NNPS 	Proper noun, plural
 *      PDT 	Predeterminer
 *      POS 	Possessive ending
 *      PRP 	Personal pronoun
 *      PRP$ 	Possessive pronoun
 *      RB 	Adverb
 *      RBR 	Adverb, comparative
 *      RBS 	Adverb, superlative
 *      RP 	Particle
 *      SYM 	Symbol
 *      TO 	to
 *      UH 	Interjection
 *      VB 	Verb, base form
 *      VBD 	Verb, past tense
 *      VBG 	Verb, gerund or present participle
 *      VBN 	Verb, past participle
 * 	    VBP 	Verb, non-3rd person singular present
 *  	VBZ 	Verb, 3rd person singular present
 *      WDT 	Wh-determiner
 *
 */
public class PennTreebankStateBuilder {


    private final Integer VERSION_BASE = 1;
    private final String  VERSION_SEPARATOR = ".";

    private static Logger logger = LoggerFactory.getLogger(PennTreebankStateBuilder.class);

    private PennTreebankStateBuilder(){

    }

    public static PennTreebankState createPennTreebankState(String jsonPennTreebank) {

        PennTreebankState pennTreebankState = new PennTreebankState();
        Map<String, Map<String, String>> pennTreebank = new HashMap<>();

        JsonElement jsonElement = convertStringToJsonElement(jsonPennTreebank);
        pennTreebank =  convertJsonTreeToMap(jsonElement, pennTreebank);

        pennTreebankState.setTreeBranchesMap(pennTreebank);

        return pennTreebankState;

    }

    public static JsonElement convertStringToJsonElement(String jsonString){

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);

        return jsonElement;

    }

    public static Map<String,Map<String, String>> convertJsonTreeToMap(JsonElement jsonElement, Map<String,Map<String, String>> pennTreebank){

        //Create the base version and get root sentence.
        JsonElement jsonElementBase = getRootSentenceArray(jsonElement);
        pennTreebank = recursiveNodes(jsonElementBase, pennTreebank, "s");

        return pennTreebank;
    }


    public static Map<String,Map<String, String>> recursiveNodes(JsonElement jsonElementBase, Map<String,Map<String, String>> pennTreebank, String key){

        //Loop through the return until chaing state util it equals nulll and all the leafs have been picked and hte branches pruned
        //for the map.
        while(jsonElementBase != null){

            if(jsonElementBase.isJsonArray()){

                key = key.concat("_" + "node"  + "_" + "-1");

                for(int inc = 0; inc < jsonElementBase.getAsJsonArray().size(); inc++){

                    key = incrementStringVersion(key);

                    pennTreebank = recursiveNodes(jsonElementBase.getAsJsonArray().get(inc), pennTreebank, key);

                }

            } if (jsonElementBase.isJsonObject()){

                if(isLeaf(jsonElementBase)) {
                    //Log debug so we can check log if...
                   logger.debug("Is leaf: " + jsonElementBase.toString());
                    //Save in map
                    pennTreebank = mapLeaf(jsonElementBase, pennTreebank, key);
                    //Then getLeaf and make it base.
                    jsonElementBase = getLeaf(jsonElementBase);
                } if (isNode(jsonElementBase)) {
                    //Log debug so we can check log if...
                    logger.debug("Is node: " + jsonElementBase.toString());
                    //Save in map
                    pennTreebank = mapNode(jsonElementBase, pennTreebank, key);
                    //Then getNode and make it base.
                    jsonElementBase = getNode(jsonElementBase);
                } else {
                    jsonElementBase = null;
                }

            } else {
                jsonElementBase = null;
            }

        }

        return pennTreebank;
    }


    public static Map<String,Map<String, String>> mapNode(JsonElement jsonElementBase, Map<String,Map<String, String>> pennTreebank, String key){

        Map<String, String> branch = new HashMap<>();

        key = key.concat("_" + "leaf");

        branch.put("phrase", jsonElementBase.getAsJsonObject().get("value").getAsString());
        //version = appendVersion(version, 1);
        pennTreebank.put(key,branch);

        return pennTreebank;
    }

    public static Map<String,Map<String, String>> mapLeaf(JsonElement jsonElementBase, Map<String,Map<String, String>> pennTreebank, String key){

        Map<String, String> branch = new HashMap<>();
        String branchKey;

        key = key.concat("_" + "node");

        branchKey = createBranchKey(jsonElementBase.getAsJsonObject().get("value").getAsString());

        branch.put(branchKey,jsonElementBase.getAsJsonObject().get("leaf").getAsJsonObject().get("value").getAsString());
        pennTreebank.put(key,branch);

        return pennTreebank;
    }

    /*
    This method is to check to see if it is a syntax mark like a period or comma and replace
    So the period or comma as a key don't break the mapping.
     */
    public static String createBranchKey(String branchKey){
        String key;

        if(branchKey.contains(".")){
            key = "PERIOD";
        } else if (branchKey.contains(",")){
            key = "COMMA";
        } else if (branchKey.contains(":")){
            key = "COLON";
        } else if (branchKey.contains(";")) {
            key = "SEMICOLON";
        } else {
            key = branchKey;
        }


        return key;
    }


    public static JsonElement getRootSentenceArray(JsonElement jsonElement){

        if(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node") == null){
            new Exception("getRootSentence needs a node in the JsonElement;");
        }

        logger.debug("Getting node: " + jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node").toString());

        JsonElement jsonElementNew = jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node");

        if(!(jsonElementNew.isJsonArray())){
            new Exception("This is not the root sentence array.");
        }

        return jsonElementNew;

    }

    public static boolean isJsonArray(JsonElement jsonElement){

        boolean is;

        if(!jsonElement.isJsonArray()){
            logger.debug("Is not jsonArray.");
            is = false;
        } else if(jsonElement.getAsJsonArray().size() == 0){
            logger.debug("Is zero.");
            is = false;
        } else {
            logger.debug("Is array.");
            is = true;
        }

        return is;

    }

    public static boolean isJsonObject(JsonElement jsonElement, String value){

        boolean is;

        if(!jsonElement.isJsonObject()){
            logger.debug("Is not jsonObject.");
            is = false;
        } else if(jsonElement.getAsJsonObject().get(value) == null){
            logger.debug("Is null.");
            is = false;
        } else {
            logger.debug("Is " + value + ".");
            is = true;
        }

        return is;

    }

    public static boolean isNode(JsonElement jsonElement){

        boolean node;

        node = isJsonObject(jsonElement, "node");

        return node;
    }


    public static JsonElement getNode(JsonElement jsonElement){

        if(jsonElement.getAsJsonObject().get("node") == null){
            new Exception("getNode needs a node in the JsonElement;");
        }

        logger.debug("Getting node: " + jsonElement.getAsJsonObject().get("node"));

        JsonElement jsonElementNew = jsonElement.getAsJsonObject().get("node");


        return jsonElementNew;
    }

    public static boolean isValue(JsonElement jsonElement){

        boolean value;

        value = isJsonObject(jsonElement, "value");

        return value;
    }

    public static JsonElement getValue(JsonElement jsonElement){

        JsonElement jsonElementNew;

        if(jsonElement.getAsJsonObject().get("value") == null){
            jsonElementNew = null;
        } else {

            logger.debug("Getting value: " + jsonElement.getAsJsonObject().get("value"));

            jsonElementNew = jsonElement.getAsJsonObject().get("value");
        }

        return jsonElementNew;
    }


    public static boolean isLeaf(JsonElement jsonElement){

        boolean leaf;

        leaf = isJsonObject(jsonElement, "leaf");

        return leaf;
    }


    public static JsonElement getLeaf(JsonElement jsonElement){

        JsonElement jsonElementNew;

        if(jsonElement.getAsJsonObject().get("leaf") == null){
            logger.debug("leaf is null");
            jsonElementNew = null;
        } else {
            logger.debug("Getting leaf: " + jsonElement.getAsJsonObject().get("leaf"));
            jsonElementNew = jsonElement.getAsJsonObject().get("leaf");
        }

        return jsonElementNew;
    }


    public static String incrementStringVersion(String version){

        //Get array
        String[] versionParts = version.split("_");
        String endPart = versionParts[versionParts.length - 1];
        //Increment.
        Integer endInteger = new Integer(endPart);
        //re append.
        Integer newInteger = incrementVersion(new Integer(endInteger));

        String stringVersion = versionParts[0];
        for(int i = 1; i < versionParts.length - 1;i++){
            stringVersion = stringVersion.concat("_" + versionParts[i]);
        }

        stringVersion = stringVersion.concat("_" + newInteger);

        return stringVersion;
    }




    public static Integer incrementVersion(Integer integer){

        if(integer == null){
            logger.debug("increamentVersion integer parameter is null.", new NullPointerException());
        }

        int i = integer.intValue();
        i++;

        return new Integer(i);
    }

    public static String appendVersion(String version, Integer integer){

        if(version == null || integer == null){
            logger.debug("appendVersion as a null parameter, so setting to 1.");
            version = "1";
        } else {
            version = version.concat("_" + integer);
        }
        return version;
    }

}
