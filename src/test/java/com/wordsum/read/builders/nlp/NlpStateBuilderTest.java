package com.wordsum.read.builders.nlp;

import com.wordsum.read.models.nlp.NlpState;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.TypedDependency;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

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
 * A class for testing the NLP Builder.
 *
 * @author Kalab J. Oster
 */
public class NlpStateBuilderTest {

    private LexicalizedParser lexicalizedParser;
    private StanfordCoreNLP stanfordCoreNLP;
    private StanfordCoreNLP stanfordCoreNlpRegexNer;

    private Collection<TypedDependency> tdl;

    @BeforeTest
    public void setup() {

        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        lexicalizedParser = NlpStateBuilder.loadLexicalParser();
        stanfordCoreNlpRegexNer = NlpStateBuilder.loadStanfordCoreNLP("/home/kalab/github/wordsum-java/src/test/resources/RegexNerTest.txt");


    }

    @Test
    public void testLoadStanfordCoreNLProperties() {
        Properties properties = stanfordCoreNLP.getProperties();
        Assert.assertEquals(properties.toString(), "{parse.flags=-retainTmpSubcategories, ssplit.isOneSentence=true, " +
                "parse.model=edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz, " +
                "ner.corenlp.model=edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz, parse.maxlen=10000, " +
                "tokenize.options=ptb3Escaping=false, annotators=tokenize,ssplit,pos,lemma,ner,parse}");
    }


    @Test
    public void testLoadStanfordCoreNLPropertiesRegexNer() {
        Properties properties = stanfordCoreNlpRegexNer.getProperties();
        Assert.assertEquals(properties.toString(), "{parse.flags=-retainTmpSubcategories, ssplit.isOneSentence=true, " +
                "parse.model=edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz, " +
                "regexner.mapping=/home/kalab/github/wordsum-java/src/test/resources/RegexNerTest.txt, " +
                "ner.corenlp.model=edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz, " +
                "parse.maxlen=10000, tokenize.options=ptb3Escaping=false, " +
                "annotators=tokenize,ssplit,pos,lemma,ner,parse,regexner}");
    }


    @Test
    public void testRemoveCommunicationMark(){

        String sentence1 = "\"I have dialog.\"";
        String sentence2 = "<I have dialog.>";
        String sentence3 = "''I have dialog.''";
        String sentence4 = ">|I have dialog.<";
        String sentence5 = ",,I have dialog.''";

        sentence1 = NlpStateBuilder.removeCommunicationMark(sentence1);
        sentence2 = NlpStateBuilder.removeCommunicationMark(sentence2);
        sentence3 = NlpStateBuilder.removeCommunicationMark(sentence3);
        sentence4 = NlpStateBuilder.removeCommunicationMark(sentence4);
        sentence5 = NlpStateBuilder.removeCommunicationMark(sentence5);


        Assert.assertEquals(sentence1, "I have dialog.");
        Assert.assertEquals(sentence2, "I have dialog.");
        Assert.assertEquals(sentence3, "I have dialog.");
        Assert.assertEquals(sentence4, "I have dialog.");
        Assert.assertEquals(sentence5, "I have dialog.");


    }

    @Test
    public void testDefineStanfordNlpStateStanfordCoreNLPIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.defineStanfordNlpState("Not null", null, lexicalizedParser);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testDefineStanfordNlpStateStringIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.defineStanfordNlpState(null, stanfordCoreNLP, lexicalizedParser);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }


    @Test
    public void testDefineLExicalParserStringIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.defineStanfordNlpState("Not null", stanfordCoreNLP, null);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testGetSentenceSemanticGraphStanfordCoreNLPIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.getSentenceSemanticGraph("Not null", null);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testGetSentenceSemanticGraphStringIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.getSentenceSemanticGraph(null, stanfordCoreNLP);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }


    @Test
    public void testGetSentenceCoreAnnotationsStanfordCoreNLPIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.getSentenceCoreAnnotations("Not Null", null);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testGetSentenceCoreAnnotationsStringIsNull() throws InterruptedException {

        try {
            NlpStateBuilder.getSentenceCoreAnnotations(null, stanfordCoreNLP);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }


    @Test
    public void testHashMapTypedDependencyNull() {

        try {
            NlpStateBuilder.getTypedDependencies(null);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testDefineStanfordNlpStateSentenceWithDifferentSpacing() throws InterruptedException {


        List<String> sentences = new ArrayList<String>();

        sentences.add("He runs home.");
        sentences.add("He runs       home.");
        sentences.add("He        runs       home.");

        for (String sentence : sentences) {

            NlpState stanfordNlpState = NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser);

            List<HashMap<String, HashMap<String, String>>> testMap = stanfordNlpState.getTypedDependency();
            //Test 'He'
            Assert.assertEquals(testMap.get(0).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(0).get("reln").get("string"), "root(ROOT-0, runs-2)");
            Assert.assertEquals(testMap.get(0).get("reln").get("tag"), "root");
            Assert.assertEquals(testMap.get(0).get("reln").get("parent"), null);
            Assert.assertEquals(testMap.get(0).get("reln").get("name"), "root");

            Assert.assertEquals(testMap.get(0).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(0).get("gov").get("word"), null);
            Assert.assertEquals(testMap.get(0).get("gov").get("index"), "0");
            Assert.assertEquals(testMap.get(0).get("gov").get("tag"), null);
            Assert.assertEquals(testMap.get(0).get("gov").get("lemma"), null);
            Assert.assertEquals(testMap.get(0).get("gov").get("ren"), null);

            Assert.assertEquals(testMap.get(0).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(0).get("dep").get("word"), "runs");
            Assert.assertEquals(testMap.get(0).get("dep").get("index"), "2");
            Assert.assertEquals(testMap.get(0).get("dep").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(0).get("dep").get("lemma"), "run");
            Assert.assertEquals(testMap.get(0).get("dep").get("ren"), null);
            //Test 'runs'
            Assert.assertEquals(testMap.get(1).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(1).get("reln").get("string"), "nsubj(runs-2, He-1)");
            Assert.assertEquals(testMap.get(1).get("reln").get("tag"), "nsubj");
            Assert.assertEquals(testMap.get(1).get("reln").get("parent").toString(), "subj");
            Assert.assertEquals(testMap.get(1).get("reln").get("name"), "nominal subject");

            Assert.assertEquals(testMap.get(1).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(1).get("gov").get("word"), "runs");
            Assert.assertEquals(testMap.get(1).get("gov").get("index"), "2");
            Assert.assertEquals(testMap.get(1).get("gov").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(1).get("gov").get("lemma"), "run");

            Assert.assertEquals(testMap.get(1).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(1).get("dep").get("word"), "He");
            Assert.assertEquals(testMap.get(1).get("dep").get("index"), "1");
            Assert.assertEquals(testMap.get(1).get("dep").get("tag"), "PRP");
            Assert.assertEquals(testMap.get(1).get("dep").get("lemma"), "he");
            Assert.assertEquals(testMap.get(1).get("dep").get("ren"), null);

            //Test 'home'
            Assert.assertEquals(testMap.get(2).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(2).get("reln").get("string"), "dobj(runs-2, home-3)");
            Assert.assertEquals(testMap.get(2).get("reln").get("tag"), "dobj");
            Assert.assertEquals(testMap.get(2).get("reln").get("parent").toString(), "obj");
            Assert.assertEquals(testMap.get(2).get("reln").get("name"), "direct object");

            Assert.assertEquals(testMap.get(2).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(2).get("gov").get("word"), "runs");
            Assert.assertEquals(testMap.get(2).get("gov").get("index"), "2");
            Assert.assertEquals(testMap.get(2).get("gov").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(2).get("gov").get("lemma"), "run");

            Assert.assertEquals(testMap.get(2).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(2).get("dep").get("word"), "home");
            Assert.assertEquals(testMap.get(2).get("dep").get("index"), "3");
            Assert.assertEquals(testMap.get(2).get("dep").get("tag"), "NN");
            Assert.assertEquals(testMap.get(2).get("dep").get("lemma"), "home");
        }


    }

    @Test
    public void testDefineStanfordNlpStateSentenceWithDifferentSyntaxEnd() throws InterruptedException {

        List<String> sentences = new ArrayList<String>();

        sentences.add("He runs home.");
        sentences.add("He runs home,");
        sentences.add("He runs home?");
        sentences.add("He runs home!");
        sentences.add("He runs home");

        for (String sentence : sentences) {

            NlpState stanfordNlpState = NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser);

            List<HashMap<String, HashMap<String, String>>> testMap = stanfordNlpState.getTypedDependency();
            //Test 'He'
            Assert.assertEquals(testMap.get(0).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(0).get("reln").get("string"), "root(ROOT-0, runs-2)");
            Assert.assertEquals(testMap.get(0).get("reln").get("tag"), "root");
            Assert.assertEquals(testMap.get(0).get("reln").get("parent"), null);
            Assert.assertEquals(testMap.get(0).get("reln").get("name"), "root");

            Assert.assertEquals(testMap.get(0).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(0).get("gov").get("word"), null);
            Assert.assertEquals(testMap.get(0).get("gov").get("index"), "0");
            Assert.assertEquals(testMap.get(0).get("gov").get("tag"), null);
            Assert.assertEquals(testMap.get(0).get("gov").get("lemma"), null);

            Assert.assertEquals(testMap.get(0).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(0).get("dep").get("word"), "runs");
            Assert.assertEquals(testMap.get(0).get("dep").get("index"), "2");
            Assert.assertEquals(testMap.get(0).get("dep").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(0).get("dep").get("lemma"), "run");

            //Test 'runs'
            Assert.assertEquals(testMap.get(1).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(1).get("reln").get("string"), "nsubj(runs-2, He-1)");
            Assert.assertEquals(testMap.get(1).get("reln").get("tag"), "nsubj");
            Assert.assertEquals(testMap.get(1).get("reln").get("parent").toString(), "subj");
            Assert.assertEquals(testMap.get(1).get("reln").get("name"), "nominal subject");

            Assert.assertEquals(testMap.get(1).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(1).get("gov").get("word"), "runs");
            Assert.assertEquals(testMap.get(1).get("gov").get("index"), "2");
            Assert.assertEquals(testMap.get(1).get("gov").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(1).get("gov").get("lemma"), "run");

            Assert.assertEquals(testMap.get(1).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(1).get("dep").get("word"), "He");
            Assert.assertEquals(testMap.get(1).get("dep").get("index"), "1");
            Assert.assertEquals(testMap.get(1).get("dep").get("tag"), "PRP");
            Assert.assertEquals(testMap.get(1).get("dep").get("lemma"), "he");

            //Test 'home'
            Assert.assertEquals(testMap.get(2).containsKey("reln"), true);
            Assert.assertEquals(testMap.get(2).get("reln").get("string"), "dobj(runs-2, home-3)");
            Assert.assertEquals(testMap.get(2).get("reln").get("tag"), "dobj");
            Assert.assertEquals(testMap.get(2).get("reln").get("parent").toString(), "obj");
            Assert.assertEquals(testMap.get(2).get("reln").get("name"), "direct object");

            Assert.assertEquals(testMap.get(2).containsKey("gov"), true);
            Assert.assertEquals(testMap.get(2).get("gov").get("word"), "runs");
            Assert.assertEquals(testMap.get(2).get("gov").get("index"), "2");
            Assert.assertEquals(testMap.get(2).get("gov").get("tag"), "VBZ");
            Assert.assertEquals(testMap.get(2).get("gov").get("lemma"), "run");

            Assert.assertEquals(testMap.get(2).containsKey("dep"), true);
            Assert.assertEquals(testMap.get(2).get("dep").get("word"), "home");
            Assert.assertEquals(testMap.get(2).get("dep").get("index"), "3");
            Assert.assertEquals(testMap.get(2).get("dep").get("tag"), "NN");
            Assert.assertEquals(testMap.get(2).get("dep").get("lemma"), "home");
        }


    }

    @Test
    public void testGetSentencePartsList() throws InterruptedException {

        String sentence = "I SHOUT, \"Hello, person, I am ruler of the world. I got $500 and a %5 raise!\" He stood - right now? ...And ran.";

        List<HashMap<String, String>> listHashMappedTest = NlpStateBuilder.getSentenceCoreAnnotations(sentence, stanfordCoreNLP);

        Assert.assertEquals(listHashMappedTest.get(0).get("text"), "I");
        Assert.assertEquals(listHashMappedTest.get(0).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(0).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(1).get("text"), "SHOUT");
        Assert.assertEquals(listHashMappedTest.get(1).get("pos"), "VBP");
        Assert.assertEquals(listHashMappedTest.get(1).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(2).get("text"), ",");
        Assert.assertEquals(listHashMappedTest.get(2).get("pos"), ",");
        Assert.assertEquals(listHashMappedTest.get(2).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(3).get("text"), "\"");
        Assert.assertEquals(listHashMappedTest.get(3).get("pos"), "``");
        Assert.assertEquals(listHashMappedTest.get(3).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(4).get("text"), "Hello");
        Assert.assertEquals(listHashMappedTest.get(4).get("pos"), "UH");
        Assert.assertEquals(listHashMappedTest.get(4).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(5).get("text"), ",");
        Assert.assertEquals(listHashMappedTest.get(5).get("pos"), ",");
        Assert.assertEquals(listHashMappedTest.get(5).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(6).get("text"), "person");
        Assert.assertEquals(listHashMappedTest.get(6).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(6).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(7).get("text"), ",");
        Assert.assertEquals(listHashMappedTest.get(7).get("pos"), ",");
        Assert.assertEquals(listHashMappedTest.get(7).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(8).get("text"), "I");
        Assert.assertEquals(listHashMappedTest.get(8).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(8).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(9).get("text"), "am");
        Assert.assertEquals(listHashMappedTest.get(9).get("pos"), "VBP");
        Assert.assertEquals(listHashMappedTest.get(9).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(10).get("text"), "ruler");
        Assert.assertEquals(listHashMappedTest.get(10).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(10).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(11).get("text"), "of");
        Assert.assertEquals(listHashMappedTest.get(11).get("pos"), "IN");
        Assert.assertEquals(listHashMappedTest.get(11).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(12).get("text"), "the");
        Assert.assertEquals(listHashMappedTest.get(12).get("pos"), "DT");
        Assert.assertEquals(listHashMappedTest.get(12).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(13).get("text"), "world");
        Assert.assertEquals(listHashMappedTest.get(13).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(13).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(14).get("text"), ".");
        Assert.assertEquals(listHashMappedTest.get(14).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(14).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(15).get("text"), "I");
        Assert.assertEquals(listHashMappedTest.get(15).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(15).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(16).get("text"), "got");
        Assert.assertEquals(listHashMappedTest.get(16).get("pos"), "VBD");
        Assert.assertEquals(listHashMappedTest.get(16).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(17).get("text"), "$");
        Assert.assertEquals(listHashMappedTest.get(17).get("pos"), "$");
        Assert.assertEquals(listHashMappedTest.get(17).get("net"), "MONEY");

        Assert.assertEquals(listHashMappedTest.get(18).get("text"), "500");
        Assert.assertEquals(listHashMappedTest.get(18).get("pos"), "CD");
        Assert.assertEquals(listHashMappedTest.get(18).get("net"), "MONEY");

        Assert.assertEquals(listHashMappedTest.get(19).get("text"), "and");
        Assert.assertEquals(listHashMappedTest.get(19).get("pos"), "CC");
        Assert.assertEquals(listHashMappedTest.get(19).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(20).get("text"), "a");
        Assert.assertEquals(listHashMappedTest.get(20).get("pos"), "DT");
        Assert.assertEquals(listHashMappedTest.get(20).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(21).get("text"), "%");
        Assert.assertEquals(listHashMappedTest.get(21).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(21).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(22).get("text"), "5");
        Assert.assertEquals(listHashMappedTest.get(22).get("pos"), "CD");
        Assert.assertEquals(listHashMappedTest.get(22).get("net"), "NUMBER");

        Assert.assertEquals(listHashMappedTest.get(23).get("text"), "raise");
        Assert.assertEquals(listHashMappedTest.get(23).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(23).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(24).get("text"), "!");
        Assert.assertEquals(listHashMappedTest.get(24).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(24).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(25).get("text"), "\"");
        Assert.assertEquals(listHashMappedTest.get(25).get("pos"), "''");
        Assert.assertEquals(listHashMappedTest.get(25).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(26).get("text"), "He");
        Assert.assertEquals(listHashMappedTest.get(26).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(26).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(27).get("text"), "stood");
        Assert.assertEquals(listHashMappedTest.get(27).get("pos"), "VBD");
        Assert.assertEquals(listHashMappedTest.get(27).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(28).get("text"), "-");
        Assert.assertEquals(listHashMappedTest.get(28).get("pos"), ":");
        Assert.assertEquals(listHashMappedTest.get(28).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(29).get("text"), "right");
        Assert.assertEquals(listHashMappedTest.get(29).get("pos"), "RB");
        Assert.assertEquals(listHashMappedTest.get(29).get("net"), "DATE");

        Assert.assertEquals(listHashMappedTest.get(30).get("text"), "now");
        Assert.assertEquals(listHashMappedTest.get(30).get("pos"), "RB");
        Assert.assertEquals(listHashMappedTest.get(30).get("net"), "DATE");

        Assert.assertEquals(listHashMappedTest.get(31).get("text"), "?");
        Assert.assertEquals(listHashMappedTest.get(31).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(31).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(32).get("text"), "...");
        Assert.assertEquals(listHashMappedTest.get(32).get("pos"), ":");
        Assert.assertEquals(listHashMappedTest.get(32).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(33).get("text"), "And");
        Assert.assertEquals(listHashMappedTest.get(33).get("pos"), "CC");
        Assert.assertEquals(listHashMappedTest.get(33).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(34).get("text"), "ran");
        Assert.assertEquals(listHashMappedTest.get(34).get("pos"), "VBD");
        Assert.assertEquals(listHashMappedTest.get(34).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(35).get("text"), ".");
        Assert.assertEquals(listHashMappedTest.get(35).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(35).get("net"), "O");

    }


    @Test
    public void testGetSentencePartsListFromDefineStanfordNlpState() throws InterruptedException {

        String sentence = "\"Hello, person, I am ruler of the world. I got $500 and a %5 raise!\"";

        NlpState stanfordNlpState = NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser);

        List<HashMap<String, String>> listHashMappedTest = stanfordNlpState.getCoreAnnotations();


        Assert.assertEquals(listHashMappedTest.get(0).get("text"), "Hello");
        Assert.assertEquals(listHashMappedTest.get(0).get("pos"), "UH");
        Assert.assertEquals(listHashMappedTest.get(0).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(1).get("text"), ",");
        Assert.assertEquals(listHashMappedTest.get(1).get("pos"), ",");
        Assert.assertEquals(listHashMappedTest.get(1).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(2).get("text"), "person");
        Assert.assertEquals(listHashMappedTest.get(2).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(2).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(3).get("text"), ",");
        Assert.assertEquals(listHashMappedTest.get(3).get("pos"), ",");
        Assert.assertEquals(listHashMappedTest.get(3).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(4).get("text"), "I");
        Assert.assertEquals(listHashMappedTest.get(4).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(4).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(5).get("text"), "am");
        Assert.assertEquals(listHashMappedTest.get(5).get("pos"), "VBP");
        Assert.assertEquals(listHashMappedTest.get(5).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(6).get("text"), "ruler");
        Assert.assertEquals(listHashMappedTest.get(6).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(6).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(7).get("text"), "of");
        Assert.assertEquals(listHashMappedTest.get(7).get("pos"), "IN");
        Assert.assertEquals(listHashMappedTest.get(7).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(8).get("text"), "the");
        Assert.assertEquals(listHashMappedTest.get(8).get("pos"), "DT");
        Assert.assertEquals(listHashMappedTest.get(8).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(9).get("text"), "world");
        Assert.assertEquals(listHashMappedTest.get(9).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(9).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(10).get("text"), ".");
        Assert.assertEquals(listHashMappedTest.get(10).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(10).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(11).get("text"), "I");
        Assert.assertEquals(listHashMappedTest.get(11).get("pos"), "PRP");
        Assert.assertEquals(listHashMappedTest.get(11).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(12).get("text"), "got");
        Assert.assertEquals(listHashMappedTest.get(12).get("pos"), "VBD");
        Assert.assertEquals(listHashMappedTest.get(12).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(13).get("text"), "$");
        Assert.assertEquals(listHashMappedTest.get(13).get("pos"), "$");
        Assert.assertEquals(listHashMappedTest.get(13).get("net"), "MONEY");

        Assert.assertEquals(listHashMappedTest.get(14).get("text"), "500");
        Assert.assertEquals(listHashMappedTest.get(14).get("pos"), "CD");
        Assert.assertEquals(listHashMappedTest.get(14).get("net"), "MONEY");

        Assert.assertEquals(listHashMappedTest.get(15).get("text"), "and");
        Assert.assertEquals(listHashMappedTest.get(15).get("pos"), "CC");
        Assert.assertEquals(listHashMappedTest.get(15).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(16).get("text"), "a");
        Assert.assertEquals(listHashMappedTest.get(16).get("pos"), "DT");
        Assert.assertEquals(listHashMappedTest.get(16).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(17).get("text"), "%");
        Assert.assertEquals(listHashMappedTest.get(17).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(17).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(18).get("text"), "5");
        Assert.assertEquals(listHashMappedTest.get(18).get("pos"), "CD");
        Assert.assertEquals(listHashMappedTest.get(18).get("net"), "NUMBER");

        Assert.assertEquals(listHashMappedTest.get(19).get("text"), "raise");
        Assert.assertEquals(listHashMappedTest.get(19).get("pos"), "NN");
        Assert.assertEquals(listHashMappedTest.get(19).get("net"), "O");

        Assert.assertEquals(listHashMappedTest.get(20).get("text"), "!");
        Assert.assertEquals(listHashMappedTest.get(20).get("pos"), ".");
        Assert.assertEquals(listHashMappedTest.get(20).get("net"), "O");


    }


    @Test
    public void testNerDefault() throws InterruptedException {

        List<String> sentences = new ArrayList<String>();

        sentences.add("John and Bill Gates dance around the trees of the Washington Monument.");

        for (String sentence : sentences) {

            NlpState stanfordNlpState = NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser);

            List<HashMap<String, HashMap<String, String>>> testMap = stanfordNlpState.getTypedDependency();

            Assert.assertEquals(testMap.get(0).get("gov").get("ner"), null);
            Assert.assertEquals(testMap.get(1).get("gov").get("ner"), "PERSON");
            Assert.assertEquals(testMap.get(2).get("gov").get("ner"), "PERSON");
            Assert.assertEquals(testMap.get(3).get("gov").get("ner"), "PERSON");
            Assert.assertEquals(testMap.get(4).get("gov").get("ner"), "PERSON");
        }

    }



    @Test
    public void testPennTreebankJsonObject() {

        String[] sentence = {"She", "follows", "Rind", "."};

        String tree = NlpStateBuilder.getPennTreebankJsonObject(sentence, lexicalizedParser);

        Assert.assertEquals(tree, "{\"node\":{\"node\":{\"node\":[{\"node\":{\"leaf\":{\"value\":\"She\"},\"value\":\"PRP\"},\"value\":\"NP\"},{\"node\":[{\"leaf\":{\"value\":\"follows\"},\"value\":\"VBZ\"},{\"node\":{\"leaf\":{\"value\":\"Rind\"},\"value\":\"NNP\"},\"value\":\"NP\"}],\"value\":\"VP\"},{\"leaf\":{\"value\":\".\"},\"value\":\".\"}],\"value\":\"S\"},\"value\":\"ROOT\"}}");

    }


    @Test
    public void testPennTreebank() throws Exception {

        String sentence = "She follows Rind.";

        NlpState stanfordNlpState = NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser);

        String tree = NlpStateBuilder.getPennTreebank(stanfordNlpState.getCoreAnnotations(), lexicalizedParser);

        Assert.assertEquals(tree, "{\"node\":{\"node\":{\"node\":[{\"node\":{\"leaf\":{\"value\":\"She\"},\"value\":\"PRP\"},\"value\":\"NP\"},{\"node\":[{\"leaf\":{\"value\":\"follows\"},\"value\":\"VBZ\"},{\"node\":{\"leaf\":{\"value\":\"Rind\"},\"value\":\"NNP\"},\"value\":\"NP\"}],\"value\":\"VP\"},{\"leaf\":{\"value\":\".\"},\"value\":\".\"}],\"value\":\"S\"},\"value\":\"ROOT\"}}");
    }


    @Test
    public void testPennTree() throws Exception {

    }


}