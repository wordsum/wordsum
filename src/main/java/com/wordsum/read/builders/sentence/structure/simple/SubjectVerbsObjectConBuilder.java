package com.wordsum.read.builders.sentence.structure.simple;

import com.wordsum.read.builders.nlp.utils.NlpConstituencyUtils;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.sentence.structure.simple.SubjectVerbsObjectConEnumMap;
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

public class SubjectVerbsObjectConBuilder {

    private static Logger logger = LoggerFactory.getLogger(SubjectVerbsObjectConBuilder.class);

    /**
     * Limit access and enforce static. Do not instantiate.
     */
    protected SubjectVerbsObjectConBuilder(){}

    /**
     * A method to get phases and phases of phases to find subject verb object.
     *
     * @param nlpState This is the NlpState object that contains the penn tree.
     *
     *                and could be a known subject verb object sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbsObject_1(NlpState nlpState){

        boolean is = false;

        ArrayList<String> nlpLeafsKeys = NlpConstituencyUtils.getLeafsKeys(nlpState);
        ArrayList<String> enumLeafsKeys = new ArrayList<String>();

        if (NlpConstituencyUtils.hasConstituency(nlpState)){

            for(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_1 subjectVerbObject: SubjectVerbsObjectConEnumMap.SubjectVerbsObject_1.values()){

                if(NlpConstituencyUtils.isLeaf(nlpState, subjectVerbObject.getLeaf()) && NlpConstituencyUtils.getPhrase(nlpState, subjectVerbObject.getLeaf()).equals(subjectVerbObject.getLeafTag())){
                    is = true;
                    enumLeafsKeys.add(subjectVerbObject.getLeaf());
                } else {
                    is = false;
                    break;
                }
            }
        }

/*        //Sort both arrays so we can compare.
        if(nlpLeafsKeys != null){
            Collections.sort(nlpLeafsKeys);
        }
        if(enumLeafsKeys != null){
            Collections.sort(enumLeafsKeys);
        }

        //The compare is to ensure there are also no additional leafs.
        if(!nlpLeafsKeys.equals(enumLeafsKeys)){
            is = false;
        }*/

        return is;
    }

    /**
     * A method to get phases and phases of phases to find subject verb object.
     *
     * @param nlpState This is the NlpState object that contains the penn tree.
     *
     *                and could be a known subject verb object sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbsObject_2(NlpState nlpState){

        boolean is = false;


        ArrayList<String> nlpLeafsKeys = NlpConstituencyUtils.getLeafsKeys(nlpState);
        ArrayList<String> enumLeafsKeys = new ArrayList<String>();

        if (NlpConstituencyUtils.hasConstituency(nlpState)){

            logger.debug("Checking hasSubjectVerbsObject_2.");


            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Subject.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Subject.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Subject.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Subject.getLeaf()));

                }
            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Verb.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Verb.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Verb.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Verb.getLeaf()));

                }
            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_1.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_1.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_1.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_1.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_2.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_2.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_2.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_2.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_3.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_3.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_3.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_3.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_4.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_4.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_4.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_4.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_5.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_5.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_5.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_5.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_6.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_6.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_6.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_6.getLeaf()));

                }

            }

            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_7.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_7.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_7.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_7.getLeaf()));

                }

            }


            if(nlpLeafsKeys.contains(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_8.getLeaf())){

                if(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_8.getLeaf()).equals(SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_8.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbsObjectConEnumMap.SubjectVerbsObject_2.Object_8.getLeaf()));

                }

            }

        }

        if(enumLeafsKeys.size() == 3){
            is = true;
        }
/*        //Sort both arrays so we can compare.
        if(nlpLeafsKeys != null){
            Collections.sort(nlpLeafsKeys);
        }
        if(enumLeafsKeys != null){
            Collections.sort(enumLeafsKeys);
        }

        //The compare is to ensure there are also no additional leafs.
        if(!nlpLeafsKeys.equals(enumLeafsKeys)){
            is = false;
        }*/

        return is;
    }

}
