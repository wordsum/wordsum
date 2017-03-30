package com.wordsum.write.utils.sentence;

import org.testng.Assert;
import org.testng.annotations.Test;

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

public class SubjectAuxiliaryVerbUtilsTest {

    /*
        Just check things haven't change as far configuration by checking known position.
     */
    @Test
    public void testCreateSubjectAuxiliaryModalVerbSentence() throws Exception {

        List<List<String>> sentences;

        sentences = SubjectAuxiliaryVerbUtils.createSubjectAuxiliaryModalVerb();

        Assert.assertEquals(sentences.get(0).get(0),"I");
        Assert.assertEquals(sentences.get(0).get(1),"can");

        Assert.assertEquals(sentences.get(100).get(0),"Portland");
        Assert.assertEquals(sentences.get(100).get(1),"could");

    }

    /*
        Just check things haven't change as far configuration by checking known position.
     */
    @Test
    public void testCreateSubjectAuxiliaryPrimaryVerbSentence() throws Exception {

        List<List<String>> sentences;

        sentences = SubjectAuxiliaryVerbUtils.createSubjectAuxiliaryPrimaryVerb();

        Assert.assertEquals(sentences.get(0).get(0),"she");
        Assert.assertEquals(sentences.get(0).get(1),"is");

        Assert.assertEquals(sentences.get(100).get(0),"team");
        Assert.assertEquals(sentences.get(100).get(1),"are");

    }


    /*

    */
    @Test
    public void testCheckAuxiliaryPrimaryIOnlyAM() throws Exception {


        List<String> groupAm = new ArrayList<String>();
        groupAm.add("Frankin-Bat");
        groupAm.add("am");

        List<String> sheAm = new ArrayList<String>();
        groupAm.add("she");
        groupAm.add("am");


        List<String> iAm = new ArrayList<String>();
        iAm.add("I");
        iAm.add("am");


        List<List<String>> sentences;

        sentences = SubjectAuxiliaryVerbUtils.createSubjectAuxiliaryPrimaryVerb();

        Assert.assertFalse(sentences.contains(sheAm));
        Assert.assertFalse(sentences.contains(groupAm));
        Assert.assertTrue(sentences.contains(iAm));

    }


}
