package com.wordsum.process.read.builders.sentence.punctuation;

import com.wordsum.process.publish.utils.FileReaderUtil;
import com.wordsum.process.read.models.sentence.punctuation.CaseState;
import com.wordsum.process.read.models.sentence.punctuation.CaseStates;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

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

public class CaseStateBuilderTest {


    //@Test TODO: Kalab, amke work with Java 8 and better checking.
    public void testAntiCase() throws Exception {

        File testFile = FileReaderUtil.readResourceFile("/punctuationmodel/case/CaseStatesAnti.txt");
        String pattern = FileReaderUtil.readFileToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CaseState caseState = new CaseState();

        for(int i = 0; i < patternArray.length; i++ ){

            caseState = CaseStateBuilder.checkTextCaseState(caseState, patternArray[i]);

        }

        Assert.assertEquals(caseState.getPatterns().get(CaseStates.ANTI.name()).size(),16);
        Assert.assertNull(caseState.getPatterns().get(CaseStates.SENTENCE_BEGIN.name()));

    }


    //@Test TODO: Kalab, amke work with Java 8 and better checking.
    public void testEllipsisCase() throws Exception {

        File testFile = FileReaderUtil.readResourceFile("/punctuationmodel/case/CaseStatesSentenceBegin.txt");
        String pattern = FileReaderUtil.readFileToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CaseState caseState = new CaseState();

        for(int i = 0; i < patternArray.length; i++ ){

            caseState = CaseStateBuilder.checkTextCaseState(caseState, patternArray[i]);

        }

        Assert.assertNull(caseState.getPatterns().get(CaseStates.ANTI.name()));
        Assert.assertEquals(caseState.getPatterns().get(CaseStates.SENTENCE_BEGIN.name()).size(), 17);

    }

}
