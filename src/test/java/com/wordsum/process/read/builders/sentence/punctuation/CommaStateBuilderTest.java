package com.wordsum.process.read.builders.sentence.punctuation;

import com.wordsum.process.publish.utils.FileReaderUtil;
import com.wordsum.process.read.models.sentence.punctuation.CommaState;
import com.wordsum.process.read.models.sentence.punctuation.CommaStates;
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

public class CommaStateBuilderTest {


    @Test
    public void testAntiComma() throws Exception {

        File testFile = FileReaderUtil.readResourceFile("/punctuationmodel/comma/CommaStateAnti.txt");
        String pattern = FileReaderUtil.readFileToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CommaState commaState = new CommaState();

        for(int i = 0; i < patternArray.length; i++ ){

            commaState = CommaStateBuilder.sortPatterns(commaState, patternArray[i]);

        }

        Assert.assertEquals(commaState.getPatterns().get(CommaStates.ANTI.name()).size(), 6);
        Assert.assertNull(commaState.getPatterns().get(CommaStates.SERIAL_COMMA.name()));
      
    }


    @Test
    public void testSerialComma() throws Exception {

        File testFile = FileReaderUtil.readResourceFile("/punctuationmodel/comma/CommaStateSerial.txt");
        String pattern = FileReaderUtil.readFileToString(testFile);

        String[] patternArray = pattern.split("\\n");

        CommaState commaState = new CommaState();

        for(int i = 0; i < patternArray.length; i++ ){

            commaState = CommaStateBuilder.sortPatterns(commaState, patternArray[i]);

        }

        Assert.assertNull(commaState.getPatterns().get(CommaStates.ANTI.name()));
        Assert.assertEquals(commaState.getPatterns().get(CommaStates.SERIAL_COMMA.name()).size(), 4);

      }


}
