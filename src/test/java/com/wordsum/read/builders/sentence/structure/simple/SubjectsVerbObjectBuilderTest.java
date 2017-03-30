package com.wordsum.read.builders.sentence.structure.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.text.FileState;
import org.testng.annotations.BeforeTest;
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

public class SubjectsVerbObjectBuilderTest {

    private File subjectVerbObjectFile;
    private FileState subjectVerbObjectState;


    @BeforeTest
    public void setup() throws Exception {

        //Make all the file objects.
        subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectsVerbObject.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);


    }




    @Test
    public void testCreateDependencyState() throws Exception {



    }
}
