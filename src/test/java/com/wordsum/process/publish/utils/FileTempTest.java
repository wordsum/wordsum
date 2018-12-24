package com.wordsum.process.publish.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
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

public class FileTempTest {

    private List<String> LIST_TRUE = new ArrayList<String>();

    @BeforeTest
    public void setup() throws FileNotFoundException, UnsupportedEncodingException {

        LIST_TRUE.add("Line one with some text");
        LIST_TRUE.add("Line two with some text");
        LIST_TRUE.add("Line three with some text");


    }
    @
            Test
    public void testCreateTempFile() throws Exception {

        FileTemp fileTemp = new FileTemp();

        File file = fileTemp.create(LIST_TRUE);

        Assert.assertNotNull(file);

    }




}
