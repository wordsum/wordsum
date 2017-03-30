package com.wordsum.edit.utils;

import com.wordsum.read.models.text.FileState;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

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

public class SpellCheckTest {

    private static String[] FILE = {"/home/kalab/github/wordsum-java/src/test/resources/FileStateBuilderTest.txt"};
    private static String[] NOFILE = {};
    private FileState fileState;


    @BeforeTest
    public void setup() {
        fileState = new FileState();
    }


    @Test
    public void testMain() throws Exception {


        fileState = SpellCheck.main(FILE);

        //Assert.assertEquals(fileState.getParagraphStates().get(0).getSentenceStates().get(0).getPatternStates().get(0).getWord(),"In");
        //Assert.assertEquals(fileState.getParagraphStates().get(fileState.getParagraphStates().size() - 1).getSentenceStates().get(0).getPatternStates().get(0).getWord(),"I");

    }


    @Test
    public void testMainNoFile() throws Exception {

        try {
            SpellCheck.main(NOFILE);
            Assert.fail();
        } catch (FileNotFoundException e) {

        }

    }
}
