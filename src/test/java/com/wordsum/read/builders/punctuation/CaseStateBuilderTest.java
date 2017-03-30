package com.wordsum.read.builders.punctuation;

import com.wordsum.read.models.punctuation.CaseState;
import com.wordsum.read.models.punctuation.CaseStates;
import com.wordsum.publish.utils.FileReader;
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


    @Test
    public void testAntiCase() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/case/CaseStatesAnti.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CaseState caseState = new CaseState();

        for(int i = 0; i < patternArray.length; i++ ){

            caseState = CaseStateBuilder.checkTextCaseState(caseState, patternArray[i]);

        }

        Assert.assertEquals(caseState.getPatterns().get(CaseStates.ANTI.name()).size(),16);
        Assert.assertNull(caseState.getPatterns().get(CaseStates.SENTENCE_BEGIN.name()));

    }


    @Test
    public void testEllipsisCase() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/case/CaseStatesSentenceBegin.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CaseState caseState = new CaseState();

        for(int i = 0; i < patternArray.length; i++ ){

            caseState = CaseStateBuilder.checkTextCaseState(caseState, patternArray[i]);

        }

        Assert.assertNull(caseState.getPatterns().get(CaseStates.ANTI.name()));
        Assert.assertEquals(caseState.getPatterns().get(CaseStates.SENTENCE_BEGIN.name()).size(), 17);

    }

}
