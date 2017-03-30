package com.wordsum.read.builders.sentence.structure;


import com.wordsum.read.models.sentence.structure.SimpleStructureState;
import com.wordsum.read.models.sentence.structure.StructureState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class StructureStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(StructureStateBuilder.class);


    private StructureStateBuilder(){}

    public static StructureState createStructureState(StructureState structureState){



        return structureState;
    }


    public static StructureState isSentence(StructureState structureState){



        return structureState;
    }


    public static StructureState isFragment(StructureState structureState){



        return structureState;
    }


    /*
    This is to check the enum of the sentence type and its state in the tree.


    public static StructureState isValidTreeBranchType(StructureState structureState, SimpleConstituencyEnum simpleConstituencyEnum){





        return structureState;
    }


     * Check a sentence to see if is simple byy checking for known pattern.
     *
     * Three patterns:
     * 1. "s.node.0.leaf": { "phrase": "NP" }
     * 2. "s.node.1.leaf": { "phrase": "VP" }
     *
     * @param structureState
     * @return

    public static StructureState isSimpleConstituency(StructureState structureState) throws Exception {


        if(structureState == null){
            throw new Exception("structureState == null. This needs to be not null. Please fix.");
        }

        if(structureState.getNlpState() == null){
            logger.debug("structureState.getPennTreebankState() == null");
        } else {

            Map<String, Map<String, String>> treeBranchesMap = structureState.getNlpState().getPennTreebankState().getTreeBranchesMap();

            if (!treeBranchesMap.containsKey("s.node.0.leaf") || treeBranchesMap.get("s.node.0.leaf").isEmpty()) {
                logger.debug("treeBranchMap");
                throw new Exception("Missing");
            }

            if (treeBranchesMap.get(SimpleConstituencyEnum.NP.getNode()).get(SimpleConstituencyEnum.NP.getValue()).contains(SimpleConstituencyEnum.NP.name()) &&
                    treeBranchesMap.get(SimpleConstituencyEnum.VP.getNode()).get(SimpleConstituencyEnum.VP.getValue() ).contains(SimpleConstituencyEnum.VP.name())) {
                structureState.setMaybeSimpleSentence(true);
            }
        }

        return structureState;
    }
    **/


    /**
     * Check a sentence to see if is complex my checking for known pattern.
     *
     * The first pattern specific nodes where the verb and noun phrases are be to found along
     * with the SBAR and S
     *
     * Three patterns:
     * 1. "s.node.0.leaf": { "phrase": "NP" }
     * 2. "s.node.1.leaf": { "phrase": "VP" }
     * 3. "s.node.1.node.2.leaf": { "phrase": "SBAR" }
     * 4. "s.node.1.node.2.node.1.leaf": { "phrase": "S" }
     *
     * @param structureState
     * @return
     */
    public static StructureState isComplexConstituency(StructureState structureState) throws Exception {


        if(structureState == null){
            throw new Exception("structureState == null. This needs to be not null. Please fix.");
        }

        if(structureState.getNlpState().getPennTreebankState() == null){
            logger.debug("structureState.getPennTreebankState() == null");
        } else {

            Map<String, Map<String, String>> treeBranchesMap =structureState.getNlpState().getPennTreebankState().getTreeBranchesMap();

            if (!treeBranchesMap.containsKey("s.node.0.leaf") ||treeBranchesMap.get("s.node.0.leaf").isEmpty() ||
                    !treeBranchesMap.containsKey("s.node.1.node.2.leaf") ||treeBranchesMap.get("s.node.1.node.2.node.1.leaf").isEmpty()) {

                logger.debug("!treeBranchesMap.containsKey(\"s.node.0.leaf\") || treeBranchesMap.get(\"s.node.0.leaf\").isEmpty() ||\n" +
                        "!treeBranchesMap.containsKey(\"s.node.1.node.2.leaf\") ||treeBranchesMap.get(\"s.node.1.node.2.node.1.leaf\").isEmpty()");

                throw new Exception("Missing");

            }

            if (treeBranchesMap.get("s.node.0.leaf").get("phrase").contains("NP") && treeBranchesMap.get("s.node.1.leaf").get("phrase").contains("VP") &&
                    treeBranchesMap.get("s.node.1.node.2.leaf").get("phrase").contains("SBAR") && treeBranchesMap.get("s.node.1.node.2.node.1.leaf").get("phrase").contains("S") ) {
                structureState.setMaybeComplexSentence(true);
            }
        }

        return structureState;
    }



    /**
     * Check a sentence to see if is complex my checking for known pattern.
     *
     * The first pattern specific nodes where the verb and noun phrases are be to found along
     * with the SBAR and S
     *
     * Three patterns:
     * 1. "s.node.0.leaf": { "phrase": "S" }, or "s.node.0.leaf": { "phrase": "NP" }
     * 2. "s.node.1.leaf": { "phrase": "VP" }
     *
     * 3.  "s.node.1.node": { "CC": "and" }
     * or
     * 3.  "s.node.1.node.2.leaf": {"phrase": "SBAR"} and  "s.node.1.node.2.node.0.node": {"IN": X }
     }
     *
     *
     * @param structureState
     * @return
     */
    public static StructureState isCompoundConstituency(StructureState structureState) throws Exception {



        if(structureState == null){
            throw new Exception("structureState == null. This needs to be not null. Please fix.");
        }

        if(structureState.getNlpState() == null){
            logger.debug("structureState.getPennTreebankState() == null");
        } else {

            Map<String, Map<String, String>> treeBranchesMap = structureState.getNlpState().getPennTreebankState().getTreeBranchesMap();

  /*          if (!treeBranchesMap.containsKey("s.node.0.leaf") || treeBranchesMap.get("s.node.0.leaf").isEmpty() ||
                    !treeBranchesMap.containsKey("s.node.1.node") || treeBranchesMap.get("s.node.1.node").isEmpty()) {

                logger.debug("!treeBranchesMap.containsKey(\"s.node.0.leaf\") || treeBranchesMap.get(\"s.node.0.leaf\").isEmpty() ||\n" +
                        "!treeBranchesMap.containsKey(\"s.node.1.node\")");

                throw new Exception("Missing");

            }*/

            if (treeBranchesMap.get("s.node.0.leaf").get("phrase").contains("NP") &&
                    treeBranchesMap.get("s.node.1.leaf").get("phrase").contains("VP") &&
                    treeBranchesMap.get("s.node.1.node.2.leaf").get("phrase").contains("SBAR") &&
                    treeBranchesMap.get("s.node.1.node.2.node.0.node").containsKey("IN")) {

                structureState.setMaybeCompoundSentence(true);

            } else if(treeBranchesMap.get("s.node.0.leaf").get("phrase").contains("NP") &&
                        !treeBranchesMap.get("s.node.1.node").get("phrase").contains("S") &&
                        treeBranchesMap.get("s.node.1.node").containsKey("CC") &&
                        treeBranchesMap.get("s.node.1.leaf").get("phrase").contains("VP")){

                structureState.setMaybeCompoundSentence(true);

            }
        }

        return structureState;
    }

    public static SimpleStructureState createDependencyActorState(SimpleStructureState simpleStructureState) throws Exception {

        if(simpleStructureState == null || simpleStructureState.getNlpState().getTypedDependency().isEmpty()){
            throw new Exception("Null.");
        }



        return simpleStructureState;
    }

    public static SimpleStructureState getRoot(SimpleStructureState simpleStructureState) throws Exception {

        if(simpleStructureState.getNlpState().getTypedDependency().isEmpty()){
            throw new Exception("simpleState.getRootTypedDependency().isEmpty()");
        }

        List<String> acts = new ArrayList<String>();

        for(HashMap<String, HashMap<String, String>> typedDependency: simpleStructureState.getNlpState().getTypedDependency()){

            if(typedDependency.get("reln").isEmpty()){
                logger.debug("typedDependency.get(\"reln\").isEmpty()");
            } else {
                HashMap<String, String> reln = typedDependency.get("reln");

                if(reln.isEmpty()){
                    logger.debug("reln.isEmpty()");
                } else {

                    if(reln.get("name").isEmpty()){
                        logger.debug("reln.get(\"name\").isEmpty()");
                    }else {

                        if(reln.get("name").contains("root")){

                            if(typedDependency.get("dep") == null){
                                logger.debug("typedDependency.get(\"dep\") == null");
                            } else {

                                HashMap<String, String> dep = typedDependency.get("dep");

                                if(dep.get("word").isEmpty()){

                                } else {
                                    acts.add(dep.get("word"));
                                }
                            }
                        }
                        ;

                    }

                }


            }

        }

        simpleStructureState.setVerbs(acts);

        return simpleStructureState;
    }


    public static SimpleStructureState isRoot(SimpleStructureState simpleStructureState){

        boolean is;



        return simpleStructureState;
    }

    public static SimpleStructureState getNsubjIntoPerformer(SimpleStructureState simpleStructureState) throws Exception {

        if(simpleStructureState.getNlpState().getTypedDependency().isEmpty()){
            throw new Exception("simpleState.getRootTypedDependency().isEmpty()");
        }

        List<String> performers = new ArrayList<String>();

        for(HashMap<String, HashMap<String, String>> typedDependency: simpleStructureState.getNlpState().getTypedDependency()){

            if(typedDependency.get("reln").isEmpty()){
                logger.debug("typedDependency.get(\"reln\").isEmpty()");
            } else {
                HashMap<String, String> reln = typedDependency.get("reln");

                if(reln.isEmpty()){
                    logger.debug("reln.isEmpty()");
                } else {

                    if(reln.get("name").isEmpty()){
                        logger.debug("reln.get(\"name\").isEmpty()");
                    }else {

                        if(reln.get("name").contains("nominal subject")){

                            if(typedDependency.get("dep") == null){
                                logger.debug("typedDependency.get(\"dep\") == null");
                            } else {

                                HashMap<String, String> dep = typedDependency.get("dep");

                                if(dep.get("word").isEmpty()){

                                } else {
                                    performers.add(dep.get("word"));
                                }
                            }
                        }
                        ;

                    }

                }


            }

        }

        simpleStructureState.setSubjects(performers);

        return simpleStructureState;
    }


    public static SimpleStructureState getNmodIntoReceiver(SimpleStructureState simpleStructureState) throws Exception {


        if(simpleStructureState.getNlpState().getTypedDependency().isEmpty()){
            throw new Exception("simpleState.getRootTypedDependency().isEmpty()");
        }

        List<String> receivers = new ArrayList<String>();

        for(HashMap<String, HashMap<String, String>> typedDependency: simpleStructureState.getNlpState().getTypedDependency()){

            if(typedDependency.get("reln").isEmpty()){
                logger.debug("typedDependency.get(\"reln\").isEmpty()");
            } else {
                HashMap<String, String> reln = typedDependency.get("reln");

                if(reln.isEmpty()){
                    logger.debug("reln.isEmpty()");
                } else {

                    if(reln.get("name").isEmpty()){
                        logger.debug("reln.get(\"name\").isEmpty()");
                    }else {

                        if(reln.get("name").contains("nmod_preposition")){

                            if(typedDependency.get("dep") == null){
                                logger.debug("typedDependency.get(\"dep\") == null");
                            } else {

                                HashMap<String, String> dep = typedDependency.get("dep");

                                if(dep.get("word").isEmpty()){

                                } else {
                                    receivers.add(dep.get("word"));
                                }
                            }
                        }
                        ;

                    }

                }


            }

        }

        simpleStructureState.setObjects(receivers);




        return simpleStructureState;
    }

}
