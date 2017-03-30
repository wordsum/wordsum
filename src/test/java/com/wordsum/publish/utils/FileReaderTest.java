package com.wordsum.publish.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


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

public class FileReaderTest {


    private static String FILE = "/home/kalab/github/wordsum-java/src/test/resources/FileStateBuilderTest.txt";
    private static String STRINGFIRST = "In the first paragraph, I walked the wrong pth to the top of the mountain.";


    private FileReader classUnderTest;

    @BeforeTest
    public void setup() {

    }

    @Test
    public void testReadTxtFileToString() throws IOException {

        Assert.assertTrue(classUnderTest.readTxtFileToString(FILE).contains(STRINGFIRST));

    }

    @Test
    public void testCheckPathAndTxtFile() {

        Assert.assertTrue(classUnderTest.checkPathAndTxtFile(FILE));

    }

    @Test
    public void testReadPropertiesFileToStream() {

        Properties properties = null;
        try {
            properties = FileReader.readPropertiesFileToStream("/wordprostitute.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(properties.getProperty("wordprostitute.syntax.paragraph.end"), "\\n\\n");


    }


    @Test
    public void testReadResourceToString() throws Exception {

        String file = null;
        try {
            file = FileReader.readResourceToString(FileReader.readResourceFile("/dict/english.0"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(file.isEmpty());


    }

    @Test
    public void testReadResourceFile() throws Exception {


        File file = FileReader.readResourceFile("/dict/english.0");

        Assert.assertTrue(file.exists());


    }
}
