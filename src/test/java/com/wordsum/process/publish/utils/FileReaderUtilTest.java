package com.wordsum.process.publish.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2018 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */

public class FileReaderUtilTest {

    @Test
    public void testReadResourceToString() throws Exception {

        File file = FileReaderUtil.readResourceFile("/BabaYagaSneakAttack.txt");
        String testString = FileReaderUtil.readFileToString(file);

        Assert.assertTrue(testString.startsWith("\"Me brooder"));
    }

}
