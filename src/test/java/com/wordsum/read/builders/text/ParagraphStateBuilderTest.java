package com.wordsum.read.builders.text;

import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.text.ParagraphState;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.text.SentenceState;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

public class ParagraphStateBuilderTest {

    private static String FILE = "/home/kalab/github/wordsum-java/src/test/resources/ParagraphStateBuilderTest.txt";
    private LexicalizedParser lexicalizedParser;
    private StanfordCoreNLP stanfordCoreNLP;
    private ParagraphState paragraphState;


    @BeforeTest
    public void setup() {
        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        lexicalizedParser = NlpStateBuilder.loadLexicalParser();

    }

    @Test
    public void testParseParagraph() throws Exception {

        ParagraphState paragraphState = new ParagraphState();
        String paragraph = FileReader.readTxtFileToString("/home/kalab/github/wordsum-java/src/test/resources/ParagraphStateBuilderTest.txt");

        paragraphState.setParagraph(paragraph);
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState(), null);
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getDialogState().isDialogBegin(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getDialogState(), null);
    }

    @Test
    public void testParseParagraphParseOneNarratorOneAudio() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog. ''I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''I continue then stop.");
    }

    @Test
    public void testParseParagraphParseOneAudioOneNarratorNoSentenceStates() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("''I continue then stop.'' This is not dialog.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "''I continue then stop.''");
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(2));
    }

    @Test
    public void testParseParagraphParseOneAudioOneNarratorSentenceStates() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("''I continue then stop.'' This is not dialog.");
        paragraphState.setSentenceStates(new ArrayList<SentenceState>());
        paragraphState.setSentenceCount(new Integer(0));
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "''I continue then stop.''");
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(2));
    }

    @Test
    public void testParseParagraphParseOneNarratorOneInternal() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog. <I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(2));
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<I continue then stop.");
    }


    @Test
    public void testParseParagraphParseOneNarratorOneInternalContinue() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog. <|I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<|I continue then stop.");
    }


    @Test
    public void testParseParagraphParseOneNarratorExclamationOneTelepathic() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog! >I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog!");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ">I continue then stop.");
    }

    @Test
    public void testParseParagraphParseOneNarratorQuestionOneAudio() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog? ,,I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog?");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ",,I continue then stop.");
    }


    @Test
    public void testParseParagraphParseTwoNarratorPeriodSentences() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog. I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "I continue then stop.");
    }


    @Test
    public void testParseParagraphParseTwoNarratorExclamationSentences() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog! I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog!");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "I continue then stop.");
    }


    @Test
    public void testParseParagraphParseTwoNarratorQuestionSentences() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        paragraphState.setParagraph("This is not dialog? I continue then stop.");
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "This is not dialog?");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "I continue then stop.");
    }


    @Test
    public void parseTokenizeDialogSentenceBegin() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "''I talk these words,'' says Jaz.";
        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, says Jaz.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''I talk these words,''");


    }


    @Test
    public void parseTokenizeDialogSentenceBeginContinue() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "''I talk these words,'' says Jaz and looks, ''Why me?''";

        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, says Jaz and looks, DIALOG_OBJECT_2");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''I talk these words,''");
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getSentence(), "''Why me?''");

    }


    @Test
    public void parseTokenizeDialogSentenceDialogOnly() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "I say, ,,I talk these words.''";

        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "I say, DIALOG_OBJECT_1");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ",,I talk these words.''");

    }


    @Test
    public void parseTokenizeDialogSentenceDialogMoreThanOneSentence() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "I say, ,,I talk these words.";

        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "I say, DIALOG_OBJECT_1");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ",,I talk these words.");

    }

    @Test
    public void parseTokenizeDialogSentenceDialogTypes() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "<I think,> I thought while running and saying, ,,Catch me,'' and breathing then shouting, ''HERE!''";


        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, I thought while running and saying, DIALOG_OBJECT_2, and breathing then shouting, DIALOG_OBJECT_3");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<I think,>");
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getSentence(), "''HERE!''");

    }

    @Test
    public void parseTokenizeDialogSentenceDialogNoBeginAndLong() throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        String sentence = "I thought while running and saying, ,,Catch me,'' and thinking, <Run,> breathing then shouting, ''HERE!''";


        paragraphState.setParagraph(sentence);
        paragraphState = ParagraphStateBuilder.parseTokenizeDialogSentence(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence().trim(), "I thought while running and saying, DIALOG_OBJECT_1, and thinking, DIALOG_OBJECT_2, breathing then shouting, DIALOG_OBJECT_3");
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getSentence(), "''HERE!''");

    }


    @Test
    public void testParseTokenizeDialogSentenceDialogNoBeginAndLong() throws Exception {

        List<String> dialog = new ArrayList<String>();
        dialog.add(",,Catch me,''");
        dialog.add("<Run,>");
        dialog.add("''HERE!''");

        String narrator = "I thought while running and saying, DIALOG_1, and thinking, DIALOG_2, breathing then shouting, DIALOG_3";
        ParagraphState paragraphState = new ParagraphState();
        paragraphState = ParagraphStateBuilder.loadNarrativeParseDialogIntoSentenceStateArray(paragraphState, dialog, narrator);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "I thought while running and saying, DIALOG_1, and thinking, DIALOG_2, breathing then shouting, DIALOG_3");
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState(), null);

        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ",,Catch me,''");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().getOriginOfDialogFromOrderParagraph(), new Integer(1));

        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getSentence(), "<Run,>");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().getOriginOfDialogFromOrderParagraph(), new Integer(1));

        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getSentence(), "''HERE!''");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().getOriginOfDialogFromOrderParagraph(), new Integer(1));

    }


    @Test
    public void testCreateNarratorSentenceState() {

        ParagraphState paragraphState = new ParagraphState();
        String sentence = "They ran far.";

        paragraphState = ParagraphStateBuilder.createNarratorSentenceState(paragraphState, sentence);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), sentence);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState(), null);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));

    }


    @Test
    public void testCreateDialogSentenceStateNotNullToken() throws Exception {

        ParagraphState paragraphState = new ParagraphState();
        String sentence = "''My dialog token is not null.''";
        Integer narratorToken = new Integer(23);

        paragraphState = ParagraphStateBuilder.createDialogSentenceState(paragraphState, sentence, narratorToken);


        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), sentence);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState().getOriginOfDialogFromOrderParagraph(), new Integer(23));
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState().getSentence(), sentence);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(23));

    }

    @Test
    public void testCreateDialogSentenceStateNullToken() throws Exception {

        ParagraphState paragraphState = new ParagraphState();
        String sentence = "''I say without thought.''";

        paragraphState = ParagraphStateBuilder.createDialogSentenceState(paragraphState, sentence, null);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), sentence);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState().getSentence(), sentence);
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));

    }

    @Test
    public void testSentenceOrder() throws Exception {

        String paragraph = "I said, ,,Ye are neat. Ye are the one. Ye be the second. Ye be. I be alive.'' " +
                "I have new action. This is not dialog. ''I continue. I will have another sentence to test. " +
                "This is a third sentence.'' I thought, <We need a wayout,> as I do some action.";

        ParagraphState paragraphState = new ParagraphState();
        paragraphState.setParagraph(paragraph);
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getOrderParagraph(), new Integer(2));
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getOrderParagraph(), new Integer(3));
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getOrderParagraph(), new Integer(4));

    }


    @Test
    public void testSentenceOrderInitialsAbbreviations() throws Exception {

        String paragraph = "I said, ,,Ye are neat F.B.I.. Ye are the one. Ye be the second F.B.I. I've known. Ye be. I be Sara Jr. and alive.'' " +
                "I have new action. This is not dialog. ''I continue. I will have another sentence to test. " +
                "This is a third sentence.'' I thought, <We need a wayout,> as I do some action.";

        ParagraphState paragraphState = new ParagraphState();
        paragraphState.setParagraph(paragraph);
        paragraphState = ParagraphStateBuilder.parseParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getOrderParagraph(), new Integer(2));
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getOrderParagraph(), new Integer(3));
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getOrderParagraph(), new Integer(4));

    }

    @Test
    public void testToParagraphStateOneBeginAudioAndNarrator() throws Exception {


        String paragraph = ",,No,'' exhales cigarette smoke.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), ",,No,''");
    }

    @Test
    public void testToParagraphStateAudioEndAndNarrator() throws Exception {


        String paragraph = "And we can fight Baba Yaga from the lands of our people,'' says Soarin Unterson.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, says Soarin Unterson.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "And we can fight Baba Yaga from the lands of our people,''");

    }

    @Test
    public void testToParagraphStateTelepathicEndAndNarrator() throws Exception {


        String paragraph = "And we can fight Baba Yaga from the lands of our people,< says Soarin Unterson.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, says Soarin Unterson.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "And we can fight Baba Yaga from the lands of our people,<");

    }


    @Test
    public void testToParagraphStateInternalEndAndNarrator() throws Exception {


        String paragraph = "And we can fight Baba Yaga from the lands of our people,> says Soarin Unterson.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, says Soarin Unterson.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "And we can fight Baba Yaga from the lands of our people,>");

    }


    @Test
    public void testToParagraphStateOneContinueAudioAndNarrator() throws Exception {


        String paragraph = "''No,'' exhales cigarette smoke.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''No,''");
    }




    @Test
    public void testToParagraphStateOneBeginInternalAndNarrator() throws Exception {


        String paragraph = "<No,> exhales cigarette smoke.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<No,>");
    }

    @Test
    public void testToParagraphStateOneContinueInternalAndNarrator() throws Exception {


        String paragraph = "<|No,> exhales cigarette smoke.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<|No,>");
    }


    @Test
    public void testToParagraphStateNarratorOneAndBeginInternal() throws Exception {


        String paragraph = "Exhales cigarette smoke, <No.>";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke, DIALOG_OBJECT_1");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<No.>");
    }

    @Test
    public void testToParagraphStateNarratorAndOneContinueInternal() throws Exception {


        String paragraph = "Exhales cigarette smoke, <|No.>";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke, DIALOG_OBJECT_1");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<|No.>");

    }

    @Test
    public void testToParagraphStateNarratorAndOneContinueInternalMoreThanOneDialogSentence() throws Exception {


        String paragraph = "Exhales cigarette smoke, <|No. It's fucked. It's going on and on. And I don't know why>";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke, DIALOG_OBJECT_1");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<|No.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getSentence(), "It's fucked.");

    }



    @Test
    public void testToParagraphStateNarratorEndAudioContinue() throws Exception {


        String paragraph = "Exhales cigarette smoke. ''No.''";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''No.''");
    }


    @Test
    public void testToParagraphStateNarratorEndAudioContinueMore() throws Exception {


        String paragraph = "Exhales cigarette smoke. ''No. And more.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "''No.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getSentence(), "And more.");
    }


    @Test
    public void testToParagraphStateNarratorEndInternalContinueMore() throws Exception {


        String paragraph = "Exhales cigarette smoke. <No. And more.";
        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getSentence(), "Exhales cigarette smoke.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getSentence(), "<No.");
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getSentence(), "And more.");
    }


    @Test
    public void testToParagraphState() throws Exception {

        paragraphState = ParagraphStateBuilder.toParagraphState(FileReader.readTxtFileToString(FILE), new Integer(10), stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(paragraphState.getOrder(), new Integer(10));
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getNlpState().getCoreAnnotations().get(0).get("text"), "Jack");
        Assert.assertEquals(paragraphState.getSentenceStates().get(paragraphState.getSentenceStates().size() - 1).getNlpState().getCoreAnnotations().get(0).get("text"), "Can");
        Assert.assertEquals(paragraphState.getWordCount().toString(), "148");
        Assert.assertEquals(paragraphState.isDialog(), true);

    }

    @Test
    public void testDefineParagraphDialogStateTestSentencesOfDialog() throws Exception {

        String paragraph = "I said, ,,Ye are neat. Ye are the one. Ye be the second. Ye be. I be alive.''";

        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);
        paragraphState = ParagraphStateBuilder.defineParagraphDialogStates(paragraphState);
        paragraphState = ParagraphStateBuilder.defineParagraphWordCount(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState().isDialog(), false);
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(5).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getWordCount().toString(), "18");

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getOrderParagraph(), new Integer(1));
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getOrderParagraph(), new Integer(2));
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getOrderParagraph(), new Integer(3));
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getOrderParagraph(), new Integer(4));


    }

    @Test
    public void testDefineParagraphDialogStateTestSentencesOfDialogAndDescriptionAfterAndContinueDialog() throws Exception {


        String paragraph = "I said, ,,Ye are neat. Ye are the one. Ye be the second. Ye be. I be alive.'' " +
                "I have new action. This is not dialog. ''I continue. I will have another sentence to test. " +
                "This is a third sentence.'' I thought, <We need a wayout,> as I do some action." +
                " ,,Hi. I have done this,'' said me.";


        ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph, new Integer(1), stanfordCoreNLP, lexicalizedParser);


        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getDialogState().isDialog(), false);
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().isDialogBegin(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(1).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(2).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(3).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(4).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(5).getDialogState().isDialogEnd(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(5).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(6).getDialogState().isDialog(), false);
        Assert.assertEquals(paragraphState.getSentenceStates().get(7).getDialogState().isDialog(), false);
        Assert.assertEquals(paragraphState.getSentenceStates().get(8).getDialogState().isDialogContinue(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(8).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(9).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(10).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(11).getDialogState().isDialog(), false);
        Assert.assertEquals(paragraphState.getSentenceStates().get(12).getDialogState().isDialog(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(12).getDialogState().isDialogBegin(), true);
        Assert.assertEquals(paragraphState.getSentenceStates().get(12).getDialogState().isDialogEnd(), true);
        Assert.assertEquals(paragraphState.getWordCount().toString(), "58");


    }

    @Test
    public void testDefineParagraphCheckDefineWordCountWithEmptyValue() throws Exception {

        paragraphState = new ParagraphState();

        paragraphState = ParagraphStateBuilder.defineParagraphWordCount(paragraphState);

        Assert.assertEquals(paragraphState.getWordCount().toString(), "0");


    }


}
