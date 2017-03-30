package com.wordsum.read.builders.sentence.structure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.read.models.text.FileState;
import com.wordsum.publish.utils.FileReader;
import org.testng.annotations.BeforeTest;

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

public class StructureStateBuilderTest {


    private File simplePresentSentencesFile;
    private FileState simplePresentSentencesState;
    private File complexPresentSentencesFile;
    private FileState complexPresentSentencesState;
    private File compoundPresentSentencesFile;
    private FileState compoundPresentSentencesState;

    @BeforeTest
    public void setup() throws Exception {

        //Make all the file objects.
        simplePresentSentencesFile = FileReader.readResourceFile("/sentencemodel/SimplePresentSentences.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        simplePresentSentencesState = simpleMapper.readValue(simplePresentSentencesFile, FileState.class);

        complexPresentSentencesFile = FileReader.readResourceFile("/sentencemodel/ComplexPresentSentences.json");
        ObjectMapper complexMapper = new ObjectMapper();
        complexPresentSentencesState = complexMapper.readValue(complexPresentSentencesFile, FileState.class);

        compoundPresentSentencesFile = FileReader.readResourceFile("/sentencemodel/CompoundPresentSentences.json");
        ObjectMapper compoundMapper = new ObjectMapper();
        compoundPresentSentencesState = compoundMapper.readValue(compoundPresentSentencesFile, FileState.class);


    }


    /**
     * Keep test for ideas to old thought to be great logic.
    @Test
    public  void  testIsSimpleConstituencySucceedsWithOneSentenceExample()  throws Exception {

        StructureState structureState = new StructureState();
        structureState.setSentence(simplePresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        structureState.getNlpState().setPennTreebankState(simplePresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getPennTreebankState());

        structureState = StructureStateBuilder.isSimpleConstituency(structureState);


        Assert.assertEquals(structureState.isMaybeSimpleSentence(),true);

    }

    @Test
    public  void  testIsSimpleConstituencySucceedsWithAllSentenceExamples()  throws Exception {


        for(ParagraphState paragraphState: simplePresentSentencesState.getParagraphStates()) {

            StructureState structureState = new StructureState();
            structureState.setSentence(paragraphState.getSentenceStates().get(0).getNlpState().getSentence());
            structureState.getNlpState().setPennTreebankState(paragraphState.getSentenceStates().get(0).getNlpState().getPennTreebankState());

            structureState = StructureStateBuilder.isSimpleConstituency(structureState);


            Assert.assertEquals(structureState.isMaybeSimpleSentence(), true);

        }
    }

    @Test
    public  void  testIsComplexConstituencySucceed() throws Exception {

        StructureState structureState = new StructureState();
        structureState.setSentence(complexPresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        structureState.getNlpState().setPennTreebankState(complexPresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getPennTreebankState());

        structureState = StructureStateBuilder.isComplexConstituency(structureState);


        Assert.assertEquals(structureState.isMaybeComplexSentence(),true);

    }

    @Test
    public  void  testIsCompoundConstituencySucceedsWithOneSentenceExample() throws Exception {

        StructureState structureState = new StructureState();
        structureState.setSentence(compoundPresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        structureState.getNlpState().setPennTreebankState(compoundPresentSentencesState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getPennTreebankState());

        structureState = StructureStateBuilder.isCompoundConstituency(structureState);


        Assert.assertEquals(structureState.isMaybeCompoundSentence(),true);

    }

    @Test
    public  void  testIsCompoundConstituencySucceedsWithAllSentenceExamples() throws Exception {


        for(ParagraphState paragraphState: compoundPresentSentencesState.getParagraphStates()) {

            StructureState structureState = new StructureState();
            structureState.setSentence(paragraphState.getSentenceStates().get(0).getNlpState().getSentence());
            structureState.getNlpState().setPennTreebankState(paragraphState.getSentenceStates().get(0).getNlpState().getPennTreebankState());

            structureState = StructureStateBuilder.isCompoundConstituency(structureState);


            Assert.assertEquals(structureState.isMaybeCompoundSentence(), true);

        }

    }
    **/

/**
    THIS IS COMMENTED OUT AND NOT REMOVED BECAUSE I WANT USE AND REMEMBER THE PATTERN FOR THE TESTING OF
    THE NEW STATE THAT HAS BEEN REMOVED AND IS BEGINNING TO BE REWRITTEN AGAIN.
    @Test
    public void testGetRootIntoAction() throws Exception {

        SimpleStructureState simpleStructureState = new SimpleStructureState();
        simpleStructureState.setSentence(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        simpleStructureState.setRootTypedDependency(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getRootTypedDependency());

        simpleStructureState = SimpleStateBuilder.getRootIntoAction(simpleStructureState);


        Assert.assertEquals(simpleStructureState.getActs().get(0),"sat");

    }

    @Test
    public void testGetNsubjIntoPerformer() throws Exception {

        SimpleStructureState simpleStructureState = new SimpleStructureState();
        simpleStructureState.setSentence(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        simpleStructureState.setRootTypedDependency(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getRootTypedDependency());

        simpleStructureState =  SimpleStateBuilder.getNsubjIntoPerformer(simpleStructureState);

        Assert.assertEquals(simpleStructureState.getPerformers().get(0),"I");


    }

    @Test
    public void testGetNmodIntoReceiver() throws Exception {

        SimpleStructureState simpleStructureState = new SimpleStructureState();
        simpleStructureState.setSentence(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getSentence());
        simpleStructureState.setRootTypedDependency(subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getRootTypedDependency());

        simpleStructureState =  SimpleStateBuilder.getNmodIntoReceiver(simpleStructureState);

        Assert.assertEquals(simpleStructureState.getReceivers().get(0),"table");


    }
    **/


}
