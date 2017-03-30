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

public class SubjectVerbsObjectConBuilderTest {


    @Test
    public void testHasSubjectVerbObject_1() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectVerbsObject.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);

        boolean simple0 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState());
        boolean simple1 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(1).getSentenceStates().get(0).getNlpState());
        boolean simple2 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(2).getSentenceStates().get(0).getNlpState());
        boolean simple3 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(3).getSentenceStates().get(0).getNlpState());
        boolean simple4 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(4).getSentenceStates().get(0).getNlpState());
        boolean simple5 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(5).getSentenceStates().get(0).getNlpState());
        boolean simple6 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(6).getSentenceStates().get(0).getNlpState());
        boolean simple7 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(7).getSentenceStates().get(0).getNlpState());
        boolean simple8 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(8).getSentenceStates().get(0).getNlpState());
        boolean simple9 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(9).getSentenceStates().get(0).getNlpState());
        boolean simple10 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(10).getSentenceStates().get(0).getNlpState());
        boolean simple11 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(11).getSentenceStates().get(0).getNlpState());
        boolean simple12 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(12).getSentenceStates().get(0).getNlpState());
        boolean simple13 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(13).getSentenceStates().get(0).getNlpState());
        boolean simple14 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(14).getSentenceStates().get(0).getNlpState());
        boolean simple15 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(15).getSentenceStates().get(0).getNlpState());
        boolean simple16 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(16).getSentenceStates().get(0).getNlpState());
        boolean simple17 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(17).getSentenceStates().get(0).getNlpState());
        boolean simple18 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(18).getSentenceStates().get(0).getNlpState());
        boolean simple19 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(19).getSentenceStates().get(0).getNlpState());
        boolean simple20 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(20).getSentenceStates().get(0).getNlpState());
        boolean simple21 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(21).getSentenceStates().get(0).getNlpState());
        boolean simple22 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(22).getSentenceStates().get(0).getNlpState());
        boolean simple23 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(23).getSentenceStates().get(0).getNlpState());
        boolean simple24 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(24).getSentenceStates().get(0).getNlpState());
        boolean simple25 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(25).getSentenceStates().get(0).getNlpState());
        boolean simple26 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(26).getSentenceStates().get(0).getNlpState());
        boolean simple27 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(27).getSentenceStates().get(0).getNlpState());
        boolean simple28 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(28).getSentenceStates().get(0).getNlpState());
        boolean simple29 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(29).getSentenceStates().get(0).getNlpState());
        boolean simple30 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(30).getSentenceStates().get(0).getNlpState());
        boolean simple31 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(31).getSentenceStates().get(0).getNlpState());
        boolean simple32 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(32).getSentenceStates().get(0).getNlpState());
        boolean simple33 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(33).getSentenceStates().get(0).getNlpState());
        boolean simple34 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(34).getSentenceStates().get(0).getNlpState());
        boolean simple35 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(35).getSentenceStates().get(0).getNlpState());
        boolean simple36 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(36).getSentenceStates().get(0).getNlpState());
        boolean simple37 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(37).getSentenceStates().get(0).getNlpState());
        boolean simple38 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(38).getSentenceStates().get(0).getNlpState());
        boolean simple39 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(39).getSentenceStates().get(0).getNlpState());
        boolean simple40 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(40).getSentenceStates().get(0).getNlpState());
        boolean simple41 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(41).getSentenceStates().get(0).getNlpState());
        boolean simple42 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(42).getSentenceStates().get(0).getNlpState());
        boolean simple43 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(43).getSentenceStates().get(0).getNlpState());
        boolean simple44 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(44).getSentenceStates().get(0).getNlpState());
        boolean simple45 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(45).getSentenceStates().get(0).getNlpState());
        boolean simple46 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(46).getSentenceStates().get(0).getNlpState());
        boolean simple47 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(47).getSentenceStates().get(0).getNlpState());
        boolean simple48 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(48).getSentenceStates().get(0).getNlpState());
        boolean simple49 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(49).getSentenceStates().get(0).getNlpState());
        boolean simple50 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(50).getSentenceStates().get(0).getNlpState());
        boolean simple51 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(51).getSentenceStates().get(0).getNlpState());
        boolean simple52 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(52).getSentenceStates().get(0).getNlpState());
        boolean simple53 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(53).getSentenceStates().get(0).getNlpState());
        boolean simple54 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(54).getSentenceStates().get(0).getNlpState());
        boolean simple55 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(55).getSentenceStates().get(0).getNlpState());
        boolean simple56 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(56).getSentenceStates().get(0).getNlpState());
        boolean simple57 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(57).getSentenceStates().get(0).getNlpState());
        boolean simple58 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(58).getSentenceStates().get(0).getNlpState());
        boolean simple59 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(59).getSentenceStates().get(0).getNlpState());
        boolean simple60 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(60).getSentenceStates().get(0).getNlpState());
        boolean simple61 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(61).getSentenceStates().get(0).getNlpState());
        boolean simple62 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(62).getSentenceStates().get(0).getNlpState());
        boolean simple63 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(63).getSentenceStates().get(0).getNlpState());
        boolean simple64 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(64).getSentenceStates().get(0).getNlpState());
        boolean simple65 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(65).getSentenceStates().get(0).getNlpState());
        boolean simple66 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(66).getSentenceStates().get(0).getNlpState());
        boolean simple67 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(67).getSentenceStates().get(0).getNlpState());
        boolean simple68 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_1(subjectVerbObjectState.getParagraphStates().get(68).getSentenceStates().get(0).getNlpState());


        Assert.assertEquals(simple0, true);
        Assert.assertEquals(simple1, false);
        Assert.assertEquals(simple2, true);
        Assert.assertEquals(simple3, false);
        Assert.assertEquals(simple4, true);
        Assert.assertEquals(simple5, false);
        Assert.assertEquals(simple6, false);
        Assert.assertEquals(simple7, true);
        Assert.assertEquals(simple8, false);
        Assert.assertEquals(simple9, true);
        Assert.assertEquals(simple10, false);
        Assert.assertEquals(simple11, true);
        Assert.assertEquals(simple12, false);
        Assert.assertEquals(simple13, true);
        Assert.assertEquals(simple14, false);
        Assert.assertEquals(simple15, true);
        Assert.assertEquals(simple16, true);
        Assert.assertEquals(simple17, true);
        Assert.assertEquals(simple18, true);
        Assert.assertEquals(simple19, true);
        Assert.assertEquals(simple20, false);
        Assert.assertEquals(simple21, false);
        Assert.assertEquals(simple22, true);
        Assert.assertEquals(simple23, false);
        Assert.assertEquals(simple24, false);
        Assert.assertEquals(simple25, false);
        Assert.assertEquals(simple26, false);
        Assert.assertEquals(simple27, false);
        Assert.assertEquals(simple28, false);
        Assert.assertEquals(simple29, false);
        Assert.assertEquals(simple30, false);
        Assert.assertEquals(simple31, false);
        Assert.assertEquals(simple32, false);
        Assert.assertEquals(simple33, false);
        Assert.assertEquals(simple34, false);
        Assert.assertEquals(simple35, false);
        Assert.assertEquals(simple36, false);
        Assert.assertEquals(simple37, false);
        Assert.assertEquals(simple38, false);
        Assert.assertEquals(simple39, false);
        Assert.assertEquals(simple40, false);
        Assert.assertEquals(simple41, false);
        Assert.assertEquals(simple42, false);
        Assert.assertEquals(simple43, false);
        Assert.assertEquals(simple44, false);
        Assert.assertEquals(simple45, false);
        Assert.assertEquals(simple46, false);
        Assert.assertEquals(simple47, false);
        Assert.assertEquals(simple48, false);
        Assert.assertEquals(simple49, false);
        Assert.assertEquals(simple50, false);
        Assert.assertEquals(simple51, false);
        Assert.assertEquals(simple52, false);
        Assert.assertEquals(simple53, false);
        Assert.assertEquals(simple54, false);
        Assert.assertEquals(simple55, false);
        Assert.assertEquals(simple56, false);
        Assert.assertEquals(simple57, false);
        Assert.assertEquals(simple58, false);
        Assert.assertEquals(simple59, false);
        Assert.assertEquals(simple60, false);
        Assert.assertEquals(simple61, false);
        Assert.assertEquals(simple62, false);
        Assert.assertEquals(simple63, false);
        Assert.assertEquals(simple64, false);
        Assert.assertEquals(simple65, false);
        Assert.assertEquals(simple66, false);
        Assert.assertEquals(simple67, false);
        Assert.assertEquals(simple68, false);


    }

    @Test
    public void testHasSubjectVerbObject_2() throws Exception {


        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectVerbsObject.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);

        boolean simple0 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState());
        boolean simple1 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(1).getSentenceStates().get(0).getNlpState());
        boolean simple2 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(2).getSentenceStates().get(0).getNlpState());
        boolean simple3 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(3).getSentenceStates().get(0).getNlpState());
        boolean simple4 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(4).getSentenceStates().get(0).getNlpState());
        boolean simple5 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(5).getSentenceStates().get(0).getNlpState());
        boolean simple6 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(6).getSentenceStates().get(0).getNlpState());
        boolean simple7 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(7).getSentenceStates().get(0).getNlpState());
        boolean simple8 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(8).getSentenceStates().get(0).getNlpState());
        boolean simple9 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(9).getSentenceStates().get(0).getNlpState());
        boolean simple10 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(10).getSentenceStates().get(0).getNlpState());
        boolean simple11 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(11).getSentenceStates().get(0).getNlpState());
        boolean simple12 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(12).getSentenceStates().get(0).getNlpState());
        boolean simple13 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(13).getSentenceStates().get(0).getNlpState());
        boolean simple14 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(14).getSentenceStates().get(0).getNlpState());
        boolean simple15 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(15).getSentenceStates().get(0).getNlpState());
        boolean simple16 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(16).getSentenceStates().get(0).getNlpState());
        boolean simple17 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(17).getSentenceStates().get(0).getNlpState());
        boolean simple18 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(18).getSentenceStates().get(0).getNlpState());
        boolean simple19 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(19).getSentenceStates().get(0).getNlpState());
        boolean simple20 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(20).getSentenceStates().get(0).getNlpState());
        boolean simple21 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(21).getSentenceStates().get(0).getNlpState());
        boolean simple22 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(22).getSentenceStates().get(0).getNlpState());
        boolean simple23 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(23).getSentenceStates().get(0).getNlpState());
        boolean simple24 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(24).getSentenceStates().get(0).getNlpState());
        boolean simple25 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(25).getSentenceStates().get(0).getNlpState());
        boolean simple26 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(26).getSentenceStates().get(0).getNlpState());
        boolean simple27 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(27).getSentenceStates().get(0).getNlpState());
        boolean simple28 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(28).getSentenceStates().get(0).getNlpState());
        boolean simple29 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(29).getSentenceStates().get(0).getNlpState());
        boolean simple30 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(30).getSentenceStates().get(0).getNlpState());
        boolean simple31 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(31).getSentenceStates().get(0).getNlpState());
        boolean simple32 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(32).getSentenceStates().get(0).getNlpState());
        boolean simple33 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(33).getSentenceStates().get(0).getNlpState());
        boolean simple34 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(34).getSentenceStates().get(0).getNlpState());
        boolean simple35 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(35).getSentenceStates().get(0).getNlpState());
        boolean simple36 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(36).getSentenceStates().get(0).getNlpState());
        boolean simple37 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(37).getSentenceStates().get(0).getNlpState());
        boolean simple38 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(38).getSentenceStates().get(0).getNlpState());
        boolean simple39 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(39).getSentenceStates().get(0).getNlpState());
        boolean simple40 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(40).getSentenceStates().get(0).getNlpState());
        boolean simple41 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(41).getSentenceStates().get(0).getNlpState());
        boolean simple42 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(42).getSentenceStates().get(0).getNlpState());
        boolean simple43 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(43).getSentenceStates().get(0).getNlpState());
        boolean simple44 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(44).getSentenceStates().get(0).getNlpState());
        boolean simple45 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(45).getSentenceStates().get(0).getNlpState());
        boolean simple46 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(46).getSentenceStates().get(0).getNlpState());
        boolean simple47 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(47).getSentenceStates().get(0).getNlpState());
        boolean simple48 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(48).getSentenceStates().get(0).getNlpState());
        boolean simple49 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(49).getSentenceStates().get(0).getNlpState());
        boolean simple50 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(50).getSentenceStates().get(0).getNlpState());
        boolean simple51 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(51).getSentenceStates().get(0).getNlpState());
        boolean simple52 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(52).getSentenceStates().get(0).getNlpState());
        boolean simple53 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(53).getSentenceStates().get(0).getNlpState());
        boolean simple54 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(54).getSentenceStates().get(0).getNlpState());
        boolean simple55 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(55).getSentenceStates().get(0).getNlpState());
        boolean simple56 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(56).getSentenceStates().get(0).getNlpState());
        boolean simple57 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(57).getSentenceStates().get(0).getNlpState());
        boolean simple58 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(58).getSentenceStates().get(0).getNlpState());
        boolean simple59 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(59).getSentenceStates().get(0).getNlpState());
        boolean simple60 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(60).getSentenceStates().get(0).getNlpState());
        boolean simple61 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(61).getSentenceStates().get(0).getNlpState());
        boolean simple62 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(62).getSentenceStates().get(0).getNlpState());
        boolean simple63 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(63).getSentenceStates().get(0).getNlpState());
        boolean simple64 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(64).getSentenceStates().get(0).getNlpState());
        boolean simple65 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(65).getSentenceStates().get(0).getNlpState());
        boolean simple66 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(66).getSentenceStates().get(0).getNlpState());
        boolean simple67 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(67).getSentenceStates().get(0).getNlpState());
        boolean simple68 = SubjectVerbsObjectConBuilder.hasSubjectVerbsObject_2(subjectVerbObjectState.getParagraphStates().get(68).getSentenceStates().get(0).getNlpState());


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
        Assert.assertEquals(simple68, false);


    }
}
