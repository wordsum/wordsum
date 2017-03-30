package com.wordsum.read.builders.nlp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.text.FileState;
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

public class NlpCoreAnnotationsUtilsTest {


    @Test
    public void testHasCoreAnnotationTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpcoreannotations/HasCoreAnnotationsTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpCoreAnnotationsUtils.hasCoreAnnotation(nlpState);

        Assert.assertEquals(state, true);


    }

    @Test
    public void testHasCoreAnnotationNull()  throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpcoreannotations/HasCoreAnnotationsNull.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();
        nlpState.setCoreAnnotations(null);

        boolean state = NlpCoreAnnotationsUtils.hasCoreAnnotation(nlpState);

        Assert.assertEquals(state,false);

    }

    @Test
    public void tesGetTextPosTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpcoreannotations/GetTextPosTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        String ran = NlpCoreAnnotationsUtils.getTextPos(nlpState, "ran");
        String I = NlpCoreAnnotationsUtils.getTextPos(nlpState, "I");

        Assert.assertEquals(ran,"VBD");
        Assert.assertEquals(I,"PRP");

    }


    @Test
    public void tesGetTextPosNull() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpcoreannotations/GetTextPosTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        String ran = NlpCoreAnnotationsUtils.getTextPos(nlpState, "run");

        Assert.assertEquals(ran,null);


    }


}
