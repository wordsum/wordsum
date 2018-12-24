package com.wordsum.process.read.builders.text;

import com.wordsum.process.read.models.text.FileState;
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

public class FileStateBuilderTest {

    @Test
    public void testBuildParagraphState() throws Exception {

        File file = new File("src/test/resources/BabaYagaSneakAttack.txt");


        FileState fileState = new FileState();
        fileState.setFile(file.getAbsolutePath());
        FileStateBuilder.buildParagraphStatesFile(fileState);

        Assert.assertEquals(fileState.getParagraphStates().size(), 72);
    }

}
