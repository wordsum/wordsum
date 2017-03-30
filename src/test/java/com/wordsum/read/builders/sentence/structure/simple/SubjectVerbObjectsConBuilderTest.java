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

public class SubjectVerbObjectsConBuilderTest {


    @Test
    public void testHasSubjectVerbObject_1() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectVerbObjects.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);

        boolean simple0 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState());
        boolean simple1 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(1).getSentenceStates().get(0).getNlpState());
        boolean simple2 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(2).getSentenceStates().get(0).getNlpState());
        boolean simple3 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(3).getSentenceStates().get(0).getNlpState());
        boolean simple4 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(4).getSentenceStates().get(0).getNlpState());
        boolean simple5 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(5).getSentenceStates().get(0).getNlpState());
        boolean simple6 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(6).getSentenceStates().get(0).getNlpState());
        boolean simple7 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(7).getSentenceStates().get(0).getNlpState());
        boolean simple8 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(8).getSentenceStates().get(0).getNlpState());
        boolean simple9 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(9).getSentenceStates().get(0).getNlpState());
        boolean simple10 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(10).getSentenceStates().get(0).getNlpState());
        boolean simple11 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(11).getSentenceStates().get(0).getNlpState());
        boolean simple12 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(12).getSentenceStates().get(0).getNlpState());
        boolean simple13 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(13).getSentenceStates().get(0).getNlpState());
        boolean simple14 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(14).getSentenceStates().get(0).getNlpState());
        boolean simple15 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(15).getSentenceStates().get(0).getNlpState());
        boolean simple16 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(16).getSentenceStates().get(0).getNlpState());
        boolean simple17 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(17).getSentenceStates().get(0).getNlpState());
        boolean simple18 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(18).getSentenceStates().get(0).getNlpState());
        boolean simple19 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(19).getSentenceStates().get(0).getNlpState());
        boolean simple20 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(20).getSentenceStates().get(0).getNlpState());
        boolean simple21 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(21).getSentenceStates().get(0).getNlpState());
        boolean simple22 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(22).getSentenceStates().get(0).getNlpState());
        boolean simple23 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(23).getSentenceStates().get(0).getNlpState());
        boolean simple24 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(24).getSentenceStates().get(0).getNlpState());
        boolean simple25 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(25).getSentenceStates().get(0).getNlpState());
        boolean simple26 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(26).getSentenceStates().get(0).getNlpState());
        boolean simple27 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(27).getSentenceStates().get(0).getNlpState());
        boolean simple28 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(28).getSentenceStates().get(0).getNlpState());
        boolean simple29 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(29).getSentenceStates().get(0).getNlpState());
        boolean simple30 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(30).getSentenceStates().get(0).getNlpState());
        boolean simple31 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(31).getSentenceStates().get(0).getNlpState());
        boolean simple32 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(32).getSentenceStates().get(0).getNlpState());
        boolean simple33 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(33).getSentenceStates().get(0).getNlpState());
        boolean simple34 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(34).getSentenceStates().get(0).getNlpState());
        boolean simple35 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(35).getSentenceStates().get(0).getNlpState());
        boolean simple36 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(36).getSentenceStates().get(0).getNlpState());
        boolean simple37 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(37).getSentenceStates().get(0).getNlpState());
        boolean simple38 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(38).getSentenceStates().get(0).getNlpState());
        boolean simple39 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(39).getSentenceStates().get(0).getNlpState());
        boolean simple40 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(40).getSentenceStates().get(0).getNlpState());
        boolean simple41 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(41).getSentenceStates().get(0).getNlpState());
        boolean simple42 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(42).getSentenceStates().get(0).getNlpState());
        boolean simple43 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(43).getSentenceStates().get(0).getNlpState());
        boolean simple44 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(44).getSentenceStates().get(0).getNlpState());
        boolean simple45 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(45).getSentenceStates().get(0).getNlpState());
        boolean simple46 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(46).getSentenceStates().get(0).getNlpState());
        boolean simple47 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(47).getSentenceStates().get(0).getNlpState());
        boolean simple48 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(48).getSentenceStates().get(0).getNlpState());
        boolean simple49 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(49).getSentenceStates().get(0).getNlpState());
        boolean simple50 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(50).getSentenceStates().get(0).getNlpState());
        boolean simple51 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(51).getSentenceStates().get(0).getNlpState());
        boolean simple52 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(52).getSentenceStates().get(0).getNlpState());
        boolean simple53 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(53).getSentenceStates().get(0).getNlpState());
        boolean simple54 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(54).getSentenceStates().get(0).getNlpState());
        boolean simple55 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(55).getSentenceStates().get(0).getNlpState());
        boolean simple56 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(56).getSentenceStates().get(0).getNlpState());
        boolean simple57 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(57).getSentenceStates().get(0).getNlpState());
        boolean simple58 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(58).getSentenceStates().get(0).getNlpState());
        boolean simple59 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(59).getSentenceStates().get(0).getNlpState());
        boolean simple60 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(60).getSentenceStates().get(0).getNlpState());
        boolean simple61 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(61).getSentenceStates().get(0).getNlpState());
        boolean simple62 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(62).getSentenceStates().get(0).getNlpState());
        boolean simple63 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(63).getSentenceStates().get(0).getNlpState());
        boolean simple64 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(64).getSentenceStates().get(0).getNlpState());
        boolean simple65 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(65).getSentenceStates().get(0).getNlpState());
        boolean simple66 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(66).getSentenceStates().get(0).getNlpState());
        boolean simple67 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(67).getSentenceStates().get(0).getNlpState());
        boolean simple68 = SubjectVerbObjectsConBuilder.hasSubjectVerbObjects_1(subjectVerbObjectState.getParagraphStates().get(68).getSentenceStates().get(0).getNlpState());


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
        Assert.assertEquals(simple23, true);
        Assert.assertEquals(simple24, true);
        Assert.assertEquals(simple25, true);
        Assert.assertEquals(simple26, true);
        Assert.assertEquals(simple27, true);
        Assert.assertEquals(simple28, true);
        Assert.assertEquals(simple29, true);
        Assert.assertEquals(simple30, true);
        Assert.assertEquals(simple31, true);
        Assert.assertEquals(simple32, true);
        Assert.assertEquals(simple33, true);
        Assert.assertEquals(simple34, true);
        Assert.assertEquals(simple35, true);
        Assert.assertEquals(simple36, true);
        Assert.assertEquals(simple37, true);
        Assert.assertEquals(simple38, true);
        Assert.assertEquals(simple39, true);
        Assert.assertEquals(simple40, true);
        Assert.assertEquals(simple41, true);
        Assert.assertEquals(simple42, true);
        Assert.assertEquals(simple43, true);
        Assert.assertEquals(simple44, true);
        Assert.assertEquals(simple45, true);
        Assert.assertEquals(simple46, true);
        Assert.assertEquals(simple47, true);
        Assert.assertEquals(simple48, true);
        Assert.assertEquals(simple49, true);
        Assert.assertEquals(simple50, true);
        Assert.assertEquals(simple51, true);
        Assert.assertEquals(simple52, true);
        Assert.assertEquals(simple53, true);
        Assert.assertEquals(simple54, true);
        Assert.assertEquals(simple55, true);
        Assert.assertEquals(simple56, true);
        Assert.assertEquals(simple57, true);
        Assert.assertEquals(simple58, true);
        Assert.assertEquals(simple59, true);
        Assert.assertEquals(simple60, true);
        Assert.assertEquals(simple61, true);
        Assert.assertEquals(simple62, true);
        Assert.assertEquals(simple63, true);
        Assert.assertEquals(simple64, true);
        Assert.assertEquals(simple65, true);
        Assert.assertEquals(simple66, true);
        Assert.assertEquals(simple67, true);
        Assert.assertEquals(simple68, true);


    }
    
    
}
