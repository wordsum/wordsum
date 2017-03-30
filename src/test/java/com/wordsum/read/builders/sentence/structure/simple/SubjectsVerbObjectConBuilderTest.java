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

public class SubjectsVerbObjectConBuilderTest {

    @Test
    public void testHasSubjectVerbObject_1() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectsVerbObject.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);

        boolean simple0 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState());
        boolean simple1 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(1).getSentenceStates().get(0).getNlpState());
        boolean simple2 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(2).getSentenceStates().get(0).getNlpState());
        boolean simple3 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(3).getSentenceStates().get(0).getNlpState());
        boolean simple4 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(4).getSentenceStates().get(0).getNlpState());
        boolean simple5 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(5).getSentenceStates().get(0).getNlpState());
        boolean simple6 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(6).getSentenceStates().get(0).getNlpState());
        boolean simple7 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(7).getSentenceStates().get(0).getNlpState());
        boolean simple8 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(8).getSentenceStates().get(0).getNlpState());
        boolean simple9 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(9).getSentenceStates().get(0).getNlpState());
        boolean simple10 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(10).getSentenceStates().get(0).getNlpState());
        boolean simple11 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(11).getSentenceStates().get(0).getNlpState());
        boolean simple12 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(12).getSentenceStates().get(0).getNlpState());
        boolean simple13 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(13).getSentenceStates().get(0).getNlpState());
        boolean simple14 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(14).getSentenceStates().get(0).getNlpState());
        boolean simple15 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(15).getSentenceStates().get(0).getNlpState());
        boolean simple16 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(16).getSentenceStates().get(0).getNlpState());
        boolean simple17 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(17).getSentenceStates().get(0).getNlpState());
        boolean simple18 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(18).getSentenceStates().get(0).getNlpState());
        boolean simple19 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(19).getSentenceStates().get(0).getNlpState());
        boolean simple20 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(20).getSentenceStates().get(0).getNlpState());
        boolean simple21 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(21).getSentenceStates().get(0).getNlpState());
        boolean simple22 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(22).getSentenceStates().get(0).getNlpState());
        boolean simple23 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(23).getSentenceStates().get(0).getNlpState());
        boolean simple24 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(24).getSentenceStates().get(0).getNlpState());
        boolean simple25 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(25).getSentenceStates().get(0).getNlpState());
        boolean simple26 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(26).getSentenceStates().get(0).getNlpState());
        boolean simple27 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(27).getSentenceStates().get(0).getNlpState());
        boolean simple28 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(28).getSentenceStates().get(0).getNlpState());
        boolean simple29 = SubjectsVerbObjectConBuilder.hasSubjectVerbObject_1(subjectVerbObjectState.getParagraphStates().get(29).getSentenceStates().get(0).getNlpState());



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
        Assert.assertEquals(simple21, false);
        Assert.assertEquals(simple22, true);
        Assert.assertEquals(simple23, false);
        Assert.assertEquals(simple24, true);
        Assert.assertEquals(simple25, true);
        Assert.assertEquals(simple26, true);
        Assert.assertEquals(simple27, true);
        Assert.assertEquals(simple28, true);
        Assert.assertEquals(simple29, true);

    }


}
