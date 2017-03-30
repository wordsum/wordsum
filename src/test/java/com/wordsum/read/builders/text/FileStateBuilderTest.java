package com.wordsum.read.builders.text;

import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.text.FileState;
import com.wordsum.publish.utils.FileReader;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.wordsum.publish.utils.TxtToJsonUtil;

import java.io.File;
import java.time.LocalDateTime;
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

public class FileStateBuilderTest {


    private File TestFile;

    private FileStateBuilder fileStateBuilder;
    private FileState fileState;

    private StanfordCoreNLP stanfordCoreNLP;
    private LexicalizedParser lexicalizedParser;

    @BeforeTest
    public void setup() throws Exception {


        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        lexicalizedParser = NlpStateBuilder.loadLexicalParser();

    }

    @Test
    public void testToParagraphState() throws Exception {

        File testFile = FileReader.readResourceFile("/FileStateBuilderTest.txt");
        fileState = fileStateBuilder.toFileState(testFile, null, null, null, null, null, null, null, stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(fileState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState().getCoreAnnotations().get(0).get("text"), "In");
        Assert.assertEquals(fileState.getParagraphStates().get(20).getSentenceStates().get(1).getNlpState().getCoreAnnotations().get(1).get("text"), "you");
        Assert.assertEquals(fileState.getParagraphStates().get(21).getSentenceStates().get(0).getSentence(), "DIALOG_OBJECT_1, exhales cigarette smoke.");
    }

    @Test
    public void testIsStates() throws Exception {

        File testFile = FileReader.readResourceFile("/FileStateBuilderTest.txt");
        String version = "0.9.0";
        String gitSha = "51952dbc2fdddaee32ebf0740364be16a9cdebc9";
        String copyright = "Yes";
        LocalDateTime time = LocalDateTime.now();
        List<String> writers = new ArrayList<String>();
        List<String> editors = new ArrayList<String>();
        List<String> publishers = new ArrayList<String>();

        writers.add("Kaleb");
        writers.add("Kalab J. Oster");

        editors.add("-v-");
        editors.add("Portland");

        publishers.add("Word Prostitute");
        publishers.add("epopee");

        fileState = fileStateBuilder.toFileState(testFile, version, gitSha, time.toString(), copyright, writers, editors, writers, stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(fileState.getFile(), testFile.getAbsolutePath());
        Assert.assertEquals(fileState.getWordCount().toString(), "296");

    }


    @Test
    public void testIsNotFile() throws Exception {

        try {
            fileState = fileStateBuilder.toFileState(null, null, null, null, null, null, null, null, stanfordCoreNLP, lexicalizedParser);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getClass(), NullPointerException.class);
        }

    }

    @Test
    public void testIsNotStatesButIsFile() throws Exception {

        File testFile = FileReader.readResourceFile("/FileStateBuilderTest.txt");
        fileState = fileStateBuilder.toFileState(testFile, null, null, null, null, null, null, null, stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(fileState.getLocalDateTime(), null);
        Assert.assertEquals(fileState.getEditors(), null);
        Assert.assertEquals(fileState.getPublishers(), null);
        Assert.assertEquals(fileState.getWriters(), null);
        Assert.assertEquals(fileState.getVersion(), null);
        Assert.assertEquals(fileState.getWordCount().toString(), "296");


    }

    @Test
    public void testParagraphOrder() throws Exception {

        File testFile = FileReader.readResourceFile("/FileStateBuilderTest.txt");
        fileState = fileStateBuilder.toFileState(testFile, null, null, null, null, null, null, null, stanfordCoreNLP, lexicalizedParser);

        Assert.assertEquals(fileState.getParagraphStates().get(0).getOrder(), new Integer(1));
        Assert.assertEquals(fileState.getParagraphStates().get(fileState.getParagraphStates().size() - 1).getOrder(), new Integer(fileState.getParagraphStates().size()));
        Assert.assertEquals(fileState.getWordCount().toString(), "296");

    }

    @Test
    public void testCompareParagraphStateObject() throws Exception {

        File testFile = FileReader.readResourceFile("/read/builders/sentence/structure/simple/SubjectVerbsObject.txt");
        String version = "0.0.5";
        String gitSha = "30edb575085b45266571fd12f3b14e086963ece2";
        String copyright = "";
        LocalDateTime time = LocalDateTime.now();
        List<String> writers = new ArrayList<String>();
        List<String> editors = new ArrayList<String>();
        List<String> publishers = new ArrayList<String>();
        writers.add("Kalab J. Oster");
        editors.add("Kalab J. Oster");
        publishers.add("Word Prostitute\u00ae");


        fileState = new FileState();
        fileState = fileStateBuilder.toFileState(testFile, version, gitSha, time.toString(), copyright, writers, editors, publishers, stanfordCoreNLP, lexicalizedParser);

        TxtToJsonUtil.printPrettyObjectState(fileState, "/home/kalab/github/wordsum-java/src/test/resources/read/builders/sentence/structure/simple/SubjectVerbsObject.json");
    }


    @Test
    void testDefineFileWordCountNull() {

        FileState fileState = new FileState();

        fileState = FileStateBuilder.defineFileWordCount(fileState);

        Assert.assertEquals(fileState.getWordCount().toString(), "0");

    }


}
