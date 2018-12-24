package com.wordsum.process.read.builders.sentence;

import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.models.text.Fragment;
import com.wordsum.process.read.models.text.SentenceState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;;

/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2018 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */

public class SentenceStateBuilderBaseTests {

    @Test
    public static void testAddSentenceNoDialog(){

        String testSentence = "We build information with sentences.";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);

        Assert.assertEquals(sentenceState.getFragments().get(0).getType(), Fragment.Type.NARRATIVE);
    }

    @Test
    public static void testAddSentenceDialog(){

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);

        Assert.assertEquals(sentenceState.getFragments().get(0).getType(), Fragment.Type.NARRATIVE);
        Assert.assertEquals(sentenceState.getFragments().get(1).getType(), Fragment.Type.DIALOG);
        Assert.assertEquals(sentenceState.getFragments().get(2).getType(), Fragment.Type.NARRATIVE);
        Assert.assertEquals(sentenceState.getFragments().get(3).getType(), Fragment.Type.DIALOG);
    }

    @Test
    public static void testGetDialogMap(){

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);

        List<Fragment> testFragments = SentenceStateBuilder.getDialogList(sentenceState.getFragments());

        Assert.assertEquals(testFragments.get(0).getType(), Fragment.Type.DIALOG);
        Assert.assertEquals(testFragments.get(1).getType(), Fragment.Type.DIALOG);
    }

    @Test
    public static void testBuildNarrativeStateWithDialog() throws IOException {

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);
        SentenceStateBuilder.buildNarrativeState(sentenceState);

        Assert.assertEquals(sentenceState.getNarrativeStates().size(), 2);
    }

    @Test
    public static void testBuildNarrativeStateWithNoDialog() throws IOException {

        String testSentence = "We build information with sentences.";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);
        SentenceStateBuilder.buildNarrativeState(sentenceState);

        Assert.assertEquals(sentenceState.getNarrativeStates().size(), 1);
    }

    @Test
    public static void testBuildNarrative() throws IOException {

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);
        SentenceStateBuilder.buildNarrativeState(sentenceState);

        Assert.assertEquals(sentenceState.getNarrativeStates().get(1).getFragments().get(1).getText(), ", \"We breathe.\"");
    }

    @Test
    public static void testBuild() throws IOException {

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.build(sentenceState, testSentence);

        Assert.assertEquals(sentenceState.getNarrativeStates().get(1).getFragments().get(1).getText(), ", \"We breathe.\"");

    }
}
