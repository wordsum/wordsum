package com.wordsum.read.builders.text;

import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.punctuation.PeriodStates;
import com.wordsum.read.models.text.SentenceState;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


/**
 * Tests to test the class SentenceStateBuilder.
 *
 * @author Kalab J. Oster
 */
public class SentenceStateBuilderTest {

    private LexicalizedParser lexicalizedParser;
    private StanfordCoreNLP stanfordCoreNLP;


    @BeforeTest
    public void setupTest() throws Exception {

        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        lexicalizedParser = NlpStateBuilder.loadLexicalParser();

    }

    @Test
    public void testWordStateCheckWord() throws Exception {


        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("I am testing you with mispell.", new Integer(1), stanfordCoreNLP, lexicalizedParser);


        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "am");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "testing");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "you");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "with");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), "mispell");


    }

    @Test
    public void testWordStateCheckAudioMarkBeginEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState(",,I need to test audio dialog.''.", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "audio");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(6).get("text"), ".");

    }


    @Test
    public void testWordStateCheckAudioMarkContinueEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("''I need to test audio dialog.''", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "audio");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(6).get("text"), ".");

    }

    @Test
    public void testWordStateCheckTelepathicContinueMark() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState(">|I need to test dialog.<", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), ".");

    }

    @Test
    public void testWordStateCheckInternalMarkWithMoreWithCommaAtEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("<I need to test dialog,>", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), ",");

    }


    @Test
    public void testWordStateCheckInternalMarkContinueEndWithMoreWithCommaAtEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("<|I need to test dialog,>", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), ",");


    }


    @Test
    public void testWordStateCheckInternalMarkBeginWithMoreWithCommaAtEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("<I need test dialog.", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), ".");


    }

    @Test
    public void testWordStateCheckInternalMarkEndWithMoreWithCommaAtEnd() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("I need to test dialog,>", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("text"), "I");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("text"), "need");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("text"), "to");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("text"), "test");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("text"), "dialog");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("text"), ",");

    }




    @Test
    public void testWordStateCheckInternalMarkPOS() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("<I need to test dialog.>", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("pos"), "PRP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("pos"), "VBP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("pos"), "TO");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("pos"), "VB");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("pos"), "NN");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("pos"), ".");

    }

    @Test
    public void testWordStateCheckInternalMarkPOSNoMark() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("I need to test dialog.", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("pos"), "PRP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("pos"), "VBP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("pos"), "TO");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("pos"), "VB");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("pos"), "NN");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("pos"), ".");


    }


    @Test
    public void testWordStateCheckPOS() throws Exception {

        SentenceState sentenceState = SentenceStateBuilder.toSentenceState("I am testing you with mispell.", new Integer(0), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(0).get("pos"), "PRP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(1).get("pos"), "VBP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(2).get("pos"), "VBG");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(3).get("pos"), "PRP");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(4).get("pos"), "IN");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(5).get("pos"), "NN");
        Assert.assertEquals(sentenceState.getNlpState().getCoreAnnotations().get(6).get("pos"), ".");

    }


    @Test
    public void testDefineWordCountExpectedWithMoreThanTwoSpaces() throws Exception {

        SentenceState sentenceState = new SentenceState();
        sentenceState.setSentence("I am  words with  two or more   spaces    between each word.");

        sentenceState = SentenceStateBuilder.defineWordCount(sentenceState);

        Assert.assertEquals(sentenceState.getWordCount().toString(), "11");

    }


    @Test
    public void testDefineWordCountExpectedWithOneSpace() throws Exception {

        SentenceState sentenceState = new SentenceState();
        sentenceState.setSentence("I am words with one space between each word.");

        sentenceState = SentenceStateBuilder.defineWordCount(sentenceState);

        Assert.assertEquals(sentenceState.getWordCount().toString(), "9");

    }


    @Test
    public void testDefineWordCountExpectedZero() throws Exception {

        SentenceState sentenceState = new SentenceState();
        sentenceState.setSentence("");

        sentenceState = SentenceStateBuilder.defineWordCount(sentenceState);

        Assert.assertEquals(sentenceState.getWordCount().toString(), "0");

    }


    @Test
    public void testDefineWordCountExpectedNull() throws Exception {

        SentenceState sentenceState = new SentenceState();
        sentenceState.setSentence(null);

        sentenceState = SentenceStateBuilder.defineWordCount(sentenceState);

        Assert.assertEquals(sentenceState.getWordCount().toString(), "0");

    }

    @Test
    public void testDefinePunctuationState() {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "A sentence called the initials I.E. with an AntiPattern of .He with an Ellispsis...THEN a period.";

        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.definePunctuationState(sentenceState);


        Assert.assertEquals(sentenceState.getPunctuationState().getPeriodState().patterns.get(PeriodStates.ELLIPSIS.name()).get(0), "Ellispsis...THEN");
        Assert.assertEquals(sentenceState.getPunctuationState().getPeriodState().patterns.get(PeriodStates.INITIAL.name()).get(0), "I.E.");
        Assert.assertEquals(sentenceState.getPunctuationState().getPeriodState().patterns.get(PeriodStates.PERIOD.name()).get(0), "period.");
        Assert.assertEquals(sentenceState.getPunctuationState().getPeriodState().patterns.get(PeriodStates.ANTI.name()).get(0), ".He");

    }

    @Test
    public void testDefineTenseSimplePast() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She ran to town.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Past]");

    }

    @Test
    public void testDefineTenseSimplePresent() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She runs to town.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Present]");

    }

    @Test
    public void testDefineTenseAuxiliaryPast() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She had run to town.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Past, PastParticiple]");

    }

    @Test
    public void testDefineTenseAuxiliaryPresent() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She has been running to town.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Present, PastParticiple, PresentParticiple]");

    }

    @Test
    public void testDefineTenseBePast() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She was sleeping.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Past, PresentParticiple]");

    }

    @Test
    public void testDefineTenseBePresent() throws Exception {

        SentenceState sentenceState = new SentenceState();
        String testSentence = "She is smart.";
        sentenceState.setSentence(testSentence);

        SentenceStateBuilder.defineDialogState(sentenceState);
        SentenceStateBuilder.defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        SentenceStateBuilder.defineTense(sentenceState);

        Assert.assertEquals(sentenceState.getTense().toString(),"[Present]");

    }

}
