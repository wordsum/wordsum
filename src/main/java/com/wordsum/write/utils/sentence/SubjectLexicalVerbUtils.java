package com.wordsum.write.utils.sentence;

import com.wordsum.write.utils.sentence.parts.SubjectEnum;
import com.wordsum.write.utils.sentence.parts.VerbLexicalEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class SubjectLexicalVerbUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(SubjectLexicalVerbUtils.class);


    protected SubjectLexicalVerbUtils(){

    }

    public static List<String> createSubjectLexicalVerbSentence(){

        List<String> sentence = null;

        for(SubjectEnum subjectEnum: SubjectEnum.values()){

            if(subjectEnum.name().contains("SINGULAR") && subjectEnum.name().contains("1")) {

                for(VerbLexicalEnum verbLexicalEnum: VerbLexicalEnum.values()) {

                    if (verbLexicalEnum.name().contains("SINGULAR") || verbLexicalEnum.name().contains("THIRD_1")) {

                        //LOGGER.debug(subjectEnum.name());
                        LOGGER.debug(subjectEnum.getNoun());
                        LOGGER.debug(verbLexicalEnum.getVerb());

                    }
                }

            }

        }

        return sentence;
    }
}
