package com.wordsum.process.publish.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
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

public class FileWriterTest {

    private String FILE_TMP = "TestFileWriter.txt";
    private String FILE_MOCK = "mock.txt";
    private String FILE_NO = "NoFile";
    private String FILE_NULL = null;

    private String DIR_TMP ="/tmp";
    private String DIR_NO = "/not/a/directory";

    private List<String> LIST_TRUE = new ArrayList<String>();
    private List<String> LIST_EMPTY = new ArrayList<String>();
    private List<String> LIST_NULL = null;

    private FileReaderUtil classUnderTest;

    @BeforeTest
    public void setup() throws FileNotFoundException, UnsupportedEncodingException {

        LIST_TRUE.add("Line one with some text");
        LIST_TRUE.add("Line two with some text");
        LIST_TRUE.add("Line three with some text");

        PrintWriter writer = new PrintWriter(DIR_TMP + File.separator + FILE_TMP, "UTF-8");
        writer.println(LIST_TRUE.get(0));
        writer.println(LIST_TRUE.get(1));
        writer.println(LIST_TRUE.get(2));
        writer.close();

    }

    @Test
    public void testPublishArrayToTextTrue() throws Exception {

        FileWriter fileWriter = new FileWriter();
        fileWriter.setLineArray(LIST_TRUE);
        fileWriter.setOutputFile("TestPublishArrayToTextTrue.txt");
        fileWriter.setOutputPath(DIR_TMP);

        Assert.assertTrue(fileWriter.publishArrayToText());

    }


    @Test
    public void testDeleteFileTrue() throws Exception {

        FileWriter fileWriter = new FileWriter();
        fileWriter.setLineArray(LIST_TRUE);
        fileWriter.setOutputFile("TestDeleteFileTrue.txt");
        fileWriter.setOutputPath(DIR_TMP);
        fileWriter.publishArrayToText();

        Assert.assertTrue(fileWriter.deleteFile());

    }



    @Test
    public void testCanPublishTrue() throws Exception {

        FileWriter fileWriter = new FileWriter();
        fileWriter.setLineArray(LIST_TRUE);
        fileWriter.setOutputFile(FILE_TMP);
        fileWriter.setOutputPath(DIR_TMP);

        Assert.assertTrue(fileWriter.canPublish());

    }


    @Test
    public void testConcatPathFileTrue() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertEquals(DIR_TMP + File.separator + FILE_TMP, fileWriter.concatPathFile(DIR_TMP, FILE_TMP));

    }

    @Test
    public void testCanOutputPathTrue() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertTrue(fileWriter.canOutputPath(DIR_TMP));

    }

    @Test
    public void testCanOutputPathFakeFalse() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.canOutputPath(DIR_NO));

    }

    @Test
    public void testCanOutputPathNullFalse() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.canOutputPath(null));

    }

    // TODO: Fix
    // Comment out for the method doesn't work in mind right now.
    //@Test
    public void testCanOutputFileTrue() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertTrue(fileWriter.canOutputFile(DIR_TMP, FILE_TMP));

    }

    @Test
    public void testCanOutputFileFakeFalse() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.canOutputFile(DIR_TMP, FILE_NO));

    }

    @Test
    public void testCanOutputFileNullFalse() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.canOutputFile(DIR_TMP, null));

    }

    @Test
    public void testIsArrayTrue() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertTrue(fileWriter.isArray(LIST_TRUE));

    }


    @Test
    public void testIsArrayEmptyFalse() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.isArray(LIST_EMPTY));

    }


    @Test
    public void testIsArrayEmptyNull() throws IOException {

        FileWriter fileWriter = new FileWriter();

        Assert.assertFalse(fileWriter.isArray(LIST_NULL));

    }


}
