package com.wordsum.read.builders.sentence.structure.simple;

import com.wordsum.read.builders.nlp.utils.NlpConstituencyUtils;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.sentence.structure.simple.SubjectVerbObjectsConEnumMap;
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

public class SubjectVerbObjectsConBuilder {

    private static Logger logger = LoggerFactory.getLogger(SubjectVerbObjectsConBuilder.class);

    /**
     * Limit access and enforce static. Do not instantiate.
     */
    protected SubjectVerbObjectsConBuilder(){}

   

    /**
     * A method to get phases and phases of phases to find subject verb object.
     *
     * @param nlpState This is the NlpState object that contains the penn tree.
     *
     *                and could be a known subject verb object sentence pattern.
     *
     * @return boolean return of true or false to define its existence.
     **/
    public static boolean hasSubjectVerbObjects_1(NlpState nlpState){

        boolean is = false;


        ArrayList<String> nlpLeafsKeys = NlpConstituencyUtils.getLeafsKeys(nlpState);
        ArrayList<String> enumLeafsKeys = new ArrayList<String>();

        if (NlpConstituencyUtils.hasConstituency(nlpState)) {

            logger.debug("Checking hasSubjectVerbObjects_1.");


            if (nlpLeafsKeys.contains(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Subject.getLeaf())) {

                if (NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Subject.getLeaf()).equals(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Subject.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Subject.getLeaf()));

                }
            }

            if (nlpLeafsKeys.contains(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Verb.getLeaf())) {

                if (NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Verb.getLeaf()).equals(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Verb.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Verb.getLeaf()));

                }
            }

            if (nlpLeafsKeys.contains(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Object_1.getLeaf())) {

                if (NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Object_1.getLeaf()).equals(SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Object_1.getLeafTag())) {

                    enumLeafsKeys.add(NlpConstituencyUtils.getPhrase(nlpState, SubjectVerbObjectsConEnumMap.SubjectVerbObjects_1.Object_1.getLeaf()));

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
