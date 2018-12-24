package com.wordsum.process.read.builders.sentence;

import com.wordsum.process.read.models.text.Fragment;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SentenceUtilTest {


    private static List<String> sentenceDialogMark = new ArrayList<>();
    private static List<String> defineSentenceDialogMark(){
        sentenceDialogMark.add("\"");
        sentenceDialogMark.add("''");
        sentenceDialogMark.add(">");
        sentenceDialogMark.add("<");

        return sentenceDialogMark;
    }

    private static List<String> sentencePunctuationNarrativeEndings = new ArrayList<>();
    private static List<String> defineSentencePunctuationNarrativeEndings(){
        sentencePunctuationEndings.add(".");
        sentencePunctuationEndings.add("!");
        sentencePunctuationEndings.add("?");
        sentencePunctuationEndings.add("...");

        return sentencePunctuationEndings;
    }

    private static List<String> sentencePunctuationDialogEndings = new ArrayList<>();
    private static List<String> defineSentencePunctuationDialogEndings(){

        sentencePunctuationEndings.add(".\"");
        sentencePunctuationEndings.add(".<");
        sentencePunctuationEndings.add(".''");
        sentencePunctuationEndings.add(".>");

        sentencePunctuationEndings.add("!\"");
        sentencePunctuationEndings.add("!<");
        sentencePunctuationEndings.add("!''");
        sentencePunctuationEndings.add("!>");

        sentencePunctuationEndings.add("?\"");
        sentencePunctuationEndings.add("?<");
        sentencePunctuationEndings.add("?''");
        sentencePunctuationEndings.add("?>");

        return sentencePunctuationEndings;
    }

    private static List<String> sentencePunctuationEndings = new ArrayList<>();
    private static List<String> defineSentencePunctuationEndings(){
        sentencePunctuationEndings.addAll(defineSentencePunctuationNarrativeEndings());
        sentencePunctuationEndings.addAll(defineSentencePunctuationDialogEndings());

        return sentencePunctuationEndings;
    }

    private static List<String> framgmentTransitions = new ArrayList<>();
    private static List<String> defineTransitionsNarativeDialog(){
        framgmentTransitions.add(", ''");
        framgmentTransitions.add(", \"");
        framgmentTransitions.add(", <");
        framgmentTransitions.add(", >");
        framgmentTransitions.add(",'' ");
        framgmentTransitions.add(",\" ");
        framgmentTransitions.add(",< ");
        framgmentTransitions.add(",> ");
        return framgmentTransitions;
    }

    @Test
    public static void testParseParagraph(){

        String paragraphSentences = "I am running%s I am running here%s I am standing there.";

        for(String ending: defineSentencePunctuationEndings()){
            String paragraph = String.format(paragraphSentences, ending, ending);
            List<String> sentences = SentenceUtil.parseParagraphToSentences(SentenceUtil.REGEX_PARAGRAPH, paragraph);

            Assert.assertEquals(sentences.size(), 3);
        }
    }

    @Test
    public static void testParseSentence(){

        String sentenceFragments = "This is the first sentence%s";

        for(String transition: defineTransitionsNarativeDialog()){
            String sentence = String.format(sentenceFragments, transition);
            List<Fragment> framgments = SentenceUtil.parseSentence(SentenceUtil.REGEX_FRAGMENT, sentence);

            Assert.assertEquals(framgments.size(), 2);
        }
    }

    @Test
    public static void testParseSentences(){

        String sentenceFragments = "This is the first sentence%sThis is the second sentence%sThis is the third sentence%sThis is the fourth and final sentence.";

        for(String transition: defineTransitionsNarativeDialog()){
            String sentence = String.format(sentenceFragments, transition, transition, transition);
            List<Fragment> framgments = SentenceUtil.parseSentence(SentenceUtil.REGEX_FRAGMENT, sentence);

            Assert.assertEquals(framgments.size(), 4);
        }
    }

    @Test
    public static void testTag(){

        String beginSentence = "%sDialog mark begins the sentence.";
        String endSentence = "Dialog mark ends the sentence.%s";
        String beginendSentence = "%sDialog mark begins and ends the sentence.%s";
        String sentence = "No mark, no swapping, no A.I. only hypen-word a 1 _.";

        List<Fragment> testExpectedFragments = new ArrayList<Fragment>();
        Fragment efr1 = new Fragment();
        efr1.setType(Fragment.Type.DIALOG);
        efr1.setOrder(1);
        testExpectedFragments.add(efr1);
        Fragment efr2 = new Fragment();
        efr2.setType(Fragment.Type.DIALOG);
        efr2.setOrder(2);
        testExpectedFragments.add(efr2);
        Fragment efr3 = new Fragment();
        efr3.setType(Fragment.Type.DIALOG);
        efr3.setOrder(3);
        testExpectedFragments.add(efr3);
        Fragment efr4 = new Fragment();
        efr4.setType(Fragment.Type.NARRATIVE);
        efr4.setOrder(4);
        testExpectedFragments.add(efr4);

        for(String mark: defineSentenceDialogMark()) {

            List<Fragment> testFragments = new ArrayList<Fragment>();
            Fragment fr1 = new Fragment();
            fr1.setType(Fragment.Type.NONE);
            fr1.setOrder(1);
            fr1.setText(String.format(beginendSentence, mark, mark));
            testFragments.add(fr1);
            Fragment fr2 = new Fragment();
            fr2.setType(Fragment.Type.NONE);
            fr2.setOrder(2);
            fr2.setText(String.format(beginSentence , mark));
            testFragments.add(fr2);
            Fragment fr3 = new Fragment();
            fr3.setType(Fragment.Type.NONE);
            fr3.setOrder(3);
            fr3.setText(String.format(endSentence, mark));
            testFragments.add(fr3);
            Fragment fr4 = new Fragment();
            fr4.setType(Fragment.Type.NONE);
            fr4.setOrder(4);
            fr4.setText(sentence);
            testFragments.add(fr4);

            Map<Fragment.Type, List<Fragment>> testReturn = SentenceUtil.tagSentence(Fragment.Type.NONE, testFragments);

            Assert.assertEquals(testReturn.get(testReturn.keySet().iterator().next()).get(0).getType(), testExpectedFragments.get(0).getType());

        }
    }


    @Test
    public static void testParseParagraphToLabel(){

        String paragraph = "''Run,'' I said, ''It is time to run. And walk. And be,'' while running from the tree. " +
                "We were running to be free and tire the shout. \"It is glorious to be!\" And we'll see. We will see.";

        List<String> sentences = SentenceUtil.parseParagraphToSentences(SentenceUtil.REGEX_PARAGRAPH, paragraph);

        List<List<Fragment>> sentencesLabeled = SentenceUtil.tagSentences(sentences);

        Assert.assertEquals(sentencesLabeled.get(0).get(0).getType(), Fragment.Type.DIALOG);
        Assert.assertEquals(sentencesLabeled.get(6).get(0).getType(), Fragment.Type.NARRATIVE);
    }

    @Test
    public static void testWordCountSuccess(){

        String sentence = "A sentence with five words.";

        Long l = SentenceUtil.getWordCount(sentence);

        Assert.assertEquals(l, new Long(5));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public static void testWordCountNull(){
        SentenceUtil.getWordCount(null);
    }

    @Test
    public static void testWordLengthAverageSuccess(){

        String sentence = "A sentence with five words.";

        Double d = SentenceUtil.getAverageWordLength(sentence);

        Assert.assertEquals(d, new Double(4.6));
    }
}
