package com.wordsum.read.builders.sentence.structure.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.publish.utils.FileReader;
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

public class SubjectVerbObjectConBuilderTest {

    @Test
    public void testHasSubjectVerbObject_1() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectVerbObject.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);

        boolean simple0 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState());
        boolean simple1 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(1).getSentenceStates().get(0).getNlpState());
        boolean simple2 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(2).getSentenceStates().get(0).getNlpState());
        boolean simple3 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(3).getSentenceStates().get(0).getNlpState());
        boolean simple4 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(4).getSentenceStates().get(0).getNlpState());
        boolean simple5 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(5).getSentenceStates().get(0).getNlpState());
        boolean simple6 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(6).getSentenceStates().get(0).getNlpState());
        boolean simple7 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(7).getSentenceStates().get(0).getNlpState());
        boolean simple8 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(8).getSentenceStates().get(0).getNlpState());
        boolean simple9 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(9).getSentenceStates().get(0).getNlpState());
        boolean simple10 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(10).getSentenceStates().get(0).getNlpState());
        boolean simple11 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(11).getSentenceStates().get(0).getNlpState());
        boolean simple12 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(12).getSentenceStates().get(0).getNlpState());
        boolean simple13 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(13).getSentenceStates().get(0).getNlpState());
        boolean simple14 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(14).getSentenceStates().get(0).getNlpState());
        boolean simple15 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(15).getSentenceStates().get(0).getNlpState());
        boolean simple16 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(16).getSentenceStates().get(0).getNlpState());
        boolean simple17 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(17).getSentenceStates().get(0).getNlpState());
        boolean simple18 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(18).getSentenceStates().get(0).getNlpState());
        boolean simple19 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(19).getSentenceStates().get(0).getNlpState());
        boolean simple20 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(20).getSentenceStates().get(0).getNlpState());
        boolean simple21 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(21).getSentenceStates().get(0).getNlpState());
        boolean simple22 = SubjectVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(22).getSentenceStates().get(0).getNlpState());


        Assert.assertEquals(simple0, true);
        Assert.assertEquals(simple1, true);
        Assert.assertEquals(simple2, true);
        Assert.assertEquals(simple3, true);
        Assert.assertEquals(simple4, true);
        Assert.assertEquals(simple5, true);
        Assert.assertEquals(simple6, true);
        Assert.assertEquals(simple7, true);
        Assert.assertEquals(simple8, true);
        Assert.assertEquals(simple9, true);
        Assert.assertEquals(simple10, true);
        Assert.assertEquals(simple11, true);
        Assert.assertEquals(simple12, true);
        Assert.assertEquals(simple13, true);
        Assert.assertEquals(simple14, true);
        Assert.assertEquals(simple15, true);
        Assert.assertEquals(simple16, true);
        Assert.assertEquals(simple17, true);
        Assert.assertEquals(simple18, true);
        Assert.assertEquals(simple19, true);
        Assert.assertEquals(simple20, true);
        Assert.assertEquals(simple21, true);
        Assert.assertEquals(simple22, true);
    }


}
