package com.wordsum.read.builders.sentence.structure.simple;

import com.wordsum.read.builders.nlp.utils.NlpDependencyUtils;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.sentence.structure.simple.SubjectVerbObjectDepEnumMap;


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

public class SubjectVerbObjectDepBuilder {

    private SubjectVerbObjectDepBuilder(){}


    /**
     * A method to check to see if a Type Dependency Keys Tags Pairs exist. .
     * This will specifically check the existence of the reln and dep tags.
     * There dep tags may exists in pairs as the dep tags seem to vary.
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     *
     *                and could be a known sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObject_1(NlpState nlpState){

        boolean is = false;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            for(SubjectVerbObjectDepEnumMap.SubjectVerbObject_1 subjectVerbObject: SubjectVerbObjectDepEnumMap.SubjectVerbObject_1.values()){

                if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, subjectVerbObject.getDep(), subjectVerbObject.getDepTag())
                        && NlpDependencyUtils.hasDependencyKeyTagValue(nlpState,subjectVerbObject.getReln(),subjectVerbObject.getRelnTag())){
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
        }

        return is;
    }


    /**
     * A method to check to see if a Type Dependency Keys Tags Pairs exist. .
     * This will specifically check the existence of the reln and dep tags.
     * There dep tags may exists in pairs as the dep tags seem to vary.
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     *
     *                and could be a known sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObject_2(NlpState nlpState){

        boolean is = false;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            for(SubjectVerbObjectDepEnumMap.SubjectVerbObject_2 subjectVerbObject: SubjectVerbObjectDepEnumMap.SubjectVerbObject_2.values()){

                if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, subjectVerbObject.getDep(), subjectVerbObject.getDepTag())
                        && NlpDependencyUtils.hasDependencyKeyTagValue(nlpState,subjectVerbObject.getReln(),subjectVerbObject.getRelnTag())){
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
        }

        return is;
    }


    /**
     * A method to check to see if a Type Dependency Keys Tags Pairs exist. .
     * This will specifically check the existence of the reln and dep tags.
     * There dep tags may exists in pairs as the dep tags seem to vary.
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     *
     *                and could be a known sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObject_3(NlpState nlpState){

        boolean is = false;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            for(SubjectVerbObjectDepEnumMap.SubjectVerbObject_3 subjectVerbObject: SubjectVerbObjectDepEnumMap.SubjectVerbObject_3.values()){

                if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, subjectVerbObject.getDep(), subjectVerbObject.getDepTag())
                        && NlpDependencyUtils.hasDependencyKeyTagValue(nlpState,subjectVerbObject.getReln(),subjectVerbObject.getRelnTag())){
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
        }

        return is;
    }


    /**
     * A method to check to see if a Type Dependency Keys Tags Pairs exist. .
     * This will specifically check the existence of the reln and dep tags.
     * There dep tags may exists in pairs as the dep tags seem to vary.
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     *
     *                and could be a known sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObject_4(NlpState nlpState){

        boolean is = false;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            for(SubjectVerbObjectDepEnumMap.SubjectVerbObject_4 subjectVerbObject: SubjectVerbObjectDepEnumMap.SubjectVerbObject_4.values()){

                if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, subjectVerbObject.getDep(), subjectVerbObject.getDepTag())
                        && NlpDependencyUtils.hasDependencyKeyTagValue(nlpState,subjectVerbObject.getReln(),subjectVerbObject.getRelnTag())){
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
        }

        return is;
    }



    /**
     * A method to check to see if a Type Dependency Keys Tags Pairs exist. .
     * This will specifically check the existence of the reln and dep tags.
     * There dep tags may exists in pairs as the dep tags seem to vary.
     *
     * @param nlpState This is the NlpState object that contains the reln tag.
     *
     *                and could be a known sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObject_5(NlpState nlpState){

        boolean is = false;

        if (NlpDependencyUtils.hasDependency(nlpState)){

            for(SubjectVerbObjectDepEnumMap.SubjectVerbObject_4 subjectVerbObject: SubjectVerbObjectDepEnumMap.SubjectVerbObject_4.values()){

                if(NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, subjectVerbObject.getDep(), subjectVerbObject.getDepTag())
                        && NlpDependencyUtils.hasDependencyKeyTagValue(nlpState,subjectVerbObject.getReln(),subjectVerbObject.getRelnTag())){
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
        }

        return is;
    }


}
