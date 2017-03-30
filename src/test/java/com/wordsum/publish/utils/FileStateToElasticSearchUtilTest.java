package com.wordsum.publish.utils;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

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

public class FileStateToElasticSearchUtilTest {


    @BeforeTest
    public void setup() {

    }

    @Test
    public void testAddJsonToIndex() throws IOException {

        String jsonFile = "/home/kalab/github/wordsum-java/src/test/resources/NarrativeStateBuilder.json";
        String index = "wordcheck";
        String type = "filestate";
        String id = "1";

        FileStateToElasticSearchUtil.addJsonToIndex(jsonFile, index, type, id);

    }


    @Test
    public void testCreateElasticSearchIndex() throws IOException {

        String index = "wordcheck";

        FileStateToElasticSearchUtil.createElasticSearchIndex(index);

    }


    @Test
    public void testDeleteElasticSearchIndex() throws IOException {

        String index = "wordcheck";
        String type = "filestate";
        String id = "1";

        FileStateToElasticSearchUtil.deleteElasticSearchIndex(index, type, id);

    }
}
