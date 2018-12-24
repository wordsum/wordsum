package com.wordsum.process.read.builders.sentence;

import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.models.text.SentenceState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NarrativeStateBuilderTest {

    private final static StanfordCoreNLP stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();

    @Test
    public static void testAddNLP() throws IOException {

        String testSentence = "I sit and write code.";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);
        SentenceStateBuilder.buildNarrativeState(sentenceState);
        SentenceStateBuilder.buildNarrativeState(sentenceState, stanfordCoreNLP);

        NarrativeStateBuilder.addNLP(sentenceState.getNarrativeStates().get(0), NlpStateBuilder.loadStanfordCoreNLP());

        Assert.assertEquals(sentenceState.getNarrativeStates().get(0).getNlpState().getSentences().get(0).getSentimentValue(), new Integer(2).toString());
    }


    @Test
    public static void testBuildFragmentString() throws IOException {

        String testSentence = "We build information with sentences, \"I dialog,\" the narrative returns, \"We breathe.\"";
        SentenceState sentenceState = new SentenceState();
        SentenceStateBuilder.addStringText(sentenceState, testSentence);
        SentenceStateBuilder.buildNarrativeState(sentenceState);
        SentenceStateBuilder.buildNarrativeState(sentenceState, stanfordCoreNLP);
        String testStringBoth = NarrativeStateBuilder.buildFragmentString(sentenceState.getNarrativeStates().get(0).getFragments());
        Assert.assertEquals(testStringBoth, "We build information with sentences DIALOGOBJECT the narrative returns DIALOGOBJECT ");
        String testStringDialog =  NarrativeStateBuilder.buildFragmentString(sentenceState.getNarrativeStates().get(1).getFragments());
        Assert.assertEquals(testStringDialog, " I dialog We breathe.");

    }

    @Test
    public static void testReplaceDialogMarkInAllDialog(){

        String testString = "\"I dialog, \"We breathe.\"";

        testString = NarrativeStateBuilder.replaceDialogMarkInAllDialog(testString);

        Assert.assertEquals(testString, "I dialog We breathe.");
    }

    @Test
    public static void testReplaceDialogMarkInNarrative(){

        String testString = "We build information with sentences DIALOGOBJECT ,\" the narrative returns DIALOGOBJECT ";

        testString = NarrativeStateBuilder.replaceDialogMarkInNarrative(testString);

        Assert.assertEquals(testString, "We build information with sentences DIALOGOBJECT the narrative returns DIALOGOBJECT ");
    }
}
