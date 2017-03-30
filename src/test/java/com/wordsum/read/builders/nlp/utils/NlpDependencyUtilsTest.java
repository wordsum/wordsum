package com.wordsum.read.builders.nlp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.text.FileState;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;


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

public class NlpDependencyUtilsTest {


    @Test
    public void testHasDependencyTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/HasDependencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpDependencyUtils.hasDependency(nlpState);

        Assert.assertEquals(state,true);


    }

    @Test
    public void testHasDependencyNull() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/HasDependencyNull.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();
        nlpState.setTypedDependency(null);

        boolean state = NlpDependencyUtils.hasDependency(nlpState);

        Assert.assertEquals(state,false);

    }

    @Test
    public void testGetTypeDependencyRootEntityTrue() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetGovIndexTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        HashMap<String, HashMap<String, String>> typedDependency = NlpDependencyUtils.getTypeDependencyRootEntity(nlpState);

        Assert.assertEquals(typedDependency.get("reln").get("tag"),"root");
        Assert.assertEquals(typedDependency.get("gov").get("index"),"0");


    }

    @Test
    public void testGetTypeDependencyEntityByDepGovIndexTrue() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetGovIndexTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        HashMap<String, HashMap<String, String>> typedDependency1 = NlpDependencyUtils.getTypeDependencyEntityByDepIndex(nlpState, "1");
        HashMap<String, HashMap<String, String>> typedDependency2 = NlpDependencyUtils.getTypeDependencyEntityByDepIndex(nlpState, "2");

        Assert.assertEquals(typedDependency1.get("dep").get("index"),"1");
        Assert.assertEquals(typedDependency1.get("dep").get("tag"),"PRP");

        Assert.assertEquals(typedDependency2.get("dep").get("index"),"2");
        Assert.assertEquals(typedDependency2.get("dep").get("tag"),"VBD");

    }

    /**
     * THESE ARE OLD WAYS OF TYRING TO GET DATA FROM TYPED DEPENDENCE.
     *
     * I TRIED TO REWRITE TO ARRAYS AND NOW REALIZE THEY COULD BE WORTHLESS.
     *
     * I WRITE THIS TO MARK AND LABEL AND MAYBE LATER REMOVE.
     */

    @Test
    public void testHasDependencyKeyTagValueTrue() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/HasDependencyKeyTagValueTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean reln = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln", "root");
        boolean dep = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "dep", "NN");
        boolean gov = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "gov", "VBD");
        Assert.assertEquals(reln,true);
        Assert.assertEquals(dep,true);
        Assert.assertEquals(gov,true);
    }



    @Test
    public void testHasDependencyKeyTagValueFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/HasDependencyKeyTagValueFalse.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean reln = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "reln", "root");
        boolean dep = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "dep", "nothing");
        boolean gov = NlpDependencyUtils.hasDependencyKeyTagValue(nlpState, "gov", "none");
        Assert.assertEquals(reln,false);
        Assert.assertEquals(dep,false);
        Assert.assertEquals(gov,false);

    }


    @Test
    public void testGetDepWordTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetDepWordTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();


        Assert.assertEquals(NlpDependencyUtils.getDepWord(nlpState, "root").toString(),"[ran]");
        Assert.assertEquals( NlpDependencyUtils.getDepWord(nlpState, "nsubj").toString(),"[I]");
        Assert.assertEquals(NlpDependencyUtils.getDepWord(nlpState, "dobj").toString(),"[road]");

    }


    @Test
    public void testGetDepLemmaTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetDepWordTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Assert.assertEquals(NlpDependencyUtils.getDepLemma(nlpState, "root").toString(),"[run]");
        Assert.assertEquals(NlpDependencyUtils.getDepLemma(nlpState, "nsubj").toString(),"[I]");
        Assert.assertEquals(NlpDependencyUtils.getDepLemma(nlpState, "dobj").toString(),"[road]");

    }

    @Test
    public void testGetGovWordTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetGovWordTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Assert.assertEquals(NlpDependencyUtils.getGovWord(nlpState, "root").toString(),"[null]");
        Assert.assertEquals(NlpDependencyUtils.getGovWord(nlpState, "nsubj").toString(),"[ran]");
        Assert.assertEquals(NlpDependencyUtils.getGovWord(nlpState, "dobj").toString(),"[ran]");

    }


    @Test
    public void testGetGovIndexTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpdependency/GetGovIndexTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();


        String root = NlpDependencyUtils.getGovIndex(nlpState, "root");
        String nsubj = NlpDependencyUtils.getGovIndex(nlpState, "nsubj");
        String dobj = NlpDependencyUtils.getGovIndex(nlpState, "dobj");

        Assert.assertEquals(root,"0");
        Assert.assertEquals(nsubj,"2");
        Assert.assertEquals(dobj,"2");

    }


}
