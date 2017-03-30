package com.wordsum.write.utils.sentence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.wordsum.write.utils.sentence.parts.SubjectEnum;
import com.wordsum.write.utils.sentence.parts.VerbAuxiliaryEnum;

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

public class SubjectAuxiliaryVerbUtils {


    private static Logger LOGGER = LoggerFactory.getLogger(SubjectAuxiliaryVerbUtils.class);


    protected SubjectAuxiliaryVerbUtils(){


    }

    /*
     * This method outputs a modal verb sentences.
     * Because there is no tense then we will just dump.
     *
     * @return List of string sentences.
     */
    public static List<List<String>> createSubjectAuxiliaryModalVerb(){

         List<List<String>> sentences = new ArrayList<List<String>>();

        for(SubjectEnum subjectEnum: SubjectEnum.values()){

            for(VerbAuxiliaryEnum verbAuxiliaryEnum: VerbAuxiliaryEnum.values()) {

                //Assume all noun types are compatible with all modal verbs
                if (verbAuxiliaryEnum.name().contains("MODAL")) {

                    List<String> sentence = new ArrayList<String>();

                    LOGGER.debug(subjectEnum.getNoun());
                    LOGGER.debug(verbAuxiliaryEnum.getVerb());

                    sentence.add(subjectEnum.getNoun());
                    sentence.add(verbAuxiliaryEnum.getVerb());

                    sentences.add(sentence);

                }
            }

        }

        return sentences;
    }


    /*
   * This method outputs a primary verb sentences.
   * Because there is no tense then we will just dump.
   *
   * @return List of string sentences.
   */
    public static List<List<String>> createSubjectAuxiliaryPrimaryVerb(){

        List<List<String>> sentences = new ArrayList<List<String>>();

        for(VerbAuxiliaryEnum verbAuxiliaryEnum: VerbAuxiliaryEnum.values()) {

            if (verbAuxiliaryEnum.name().contains("PRIMARY")) {

                for(SubjectEnum subjectEnum: SubjectEnum.values()) {

                    if((subjectEnum.name().contains("COLLECTIVE") || subjectEnum.name().contains("PLURAL")) && (verbAuxiliaryEnum.name().contains("COLLECTIVE") || verbAuxiliaryEnum.name().contains("PLURAL"))) {

                        List<String> sentence = new ArrayList<String>();

                        //LOGGER.debug(subjectEnum.name());
                        LOGGER.debug(subjectEnum.getNoun());
                        LOGGER.debug(verbAuxiliaryEnum.getVerb());

                        sentence.add(subjectEnum.getNoun());
                        sentence.add(verbAuxiliaryEnum.getVerb());

                        sentences.add(sentence);

                    }

                    if((subjectEnum.name().contains("COLLECTIVE") || subjectEnum.name().contains("SINGULAR")) && (subjectEnum.name().contains("COLLECTIVE") || verbAuxiliaryEnum.name().contains("SINGULAR"))) {

                        List<String> sentence = new ArrayList<String>();

                        //LOGGER.debug(subjectEnum.name());
                        LOGGER.debug(subjectEnum.getNoun());
                        LOGGER.debug(verbAuxiliaryEnum.getVerb());

                        sentence.add(subjectEnum.getNoun());
                        sentence.add(verbAuxiliaryEnum.getVerb());

                        sentences.add(sentence);
                    }

                    if(subjectEnum.name().endsWith("_I") && verbAuxiliaryEnum.name().endsWith("_I")) {

                        List<String> sentence = new ArrayList<String>();

                        //LOGGER.debug(subjectEnum.name());
                        LOGGER.debug(subjectEnum.getNoun());
                        LOGGER.debug(verbAuxiliaryEnum.getVerb());

                        sentence.add(subjectEnum.getNoun());
                        sentence.add(verbAuxiliaryEnum.getVerb());

                        sentences.add(sentence);

                    }

                }

            }
        }

        return sentences;
    }

}
