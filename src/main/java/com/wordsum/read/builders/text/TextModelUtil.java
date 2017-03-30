package com.wordsum.read.builders.text;


import com.wordsum.publish.utils.TxtToJsonUtil;
import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.text.FileState;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

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

public class TextModelUtil {


    String version = "0.9.0";
    String gitSha = "51952dbc2fdddaee32ebf0740364be16a9cdebc9";
    LocalDateTime time = LocalDateTime.now();
    List<String> writers = new ArrayList<String>();
    List<String> editors = new ArrayList<String>();
    List<String> publishers = new ArrayList<String>();
    StanfordCoreNLP stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
    LexicalizedParser lexicalizedParser = NlpStateBuilder.loadLexicalParser();


    public static void main(String[] args) throws Exception {

        String version = "0.9.0";
        String gitSha = "51952dbc2fdddaee32ebf0740364be16a9cdebc9";
        LocalDateTime time = LocalDateTime.now();
        String copyright = "";
        List<String> writers = new ArrayList<String>();
        List<String> editors = new ArrayList<String>();
        List<String> publishers = new ArrayList<String>();
        StanfordCoreNLP stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        LexicalizedParser lexicalizedParser = NlpStateBuilder.loadLexicalParser();

        writers.add("Kalab J. Oster");
        editors.add("Kaleb Oster");
        publishers.add("Word Prostitute");


        File textFile = new File("/home/kalab/github/wordsum-java/src/test/resources/sentencemodel/ComplexPresentSentences.txt");
        FileStateBuilder  fileStateBuilder = new FileStateBuilder();
        FileState  fileState = fileStateBuilder.toFileState(textFile, version, gitSha, time.toString(), copyright, writers, editors, publishers, stanfordCoreNLP, lexicalizedParser);

        TxtToJsonUtil.printPrettyObjectState(fileState, textFile.getParentFile() + "/ComplexPresentSentences.json");


        textFile = new File("/home/kalab/github/wordsum-java/src/test/resources/sentencemodel/CompoundPresentSentences.txt");
        fileStateBuilder = new FileStateBuilder();
        fileState = fileStateBuilder.toFileState(textFile, version, gitSha, time.toString(), copyright, writers, editors, publishers, stanfordCoreNLP, lexicalizedParser);

        TxtToJsonUtil.printPrettyObjectState(fileState, textFile.getParentFile() + "/CompoundPresentSentences.json");


        textFile = new File("/home/kalab/github/wordsum-java/src/test/resources/sentencemodel/Fragments.txt");
        fileStateBuilder = new FileStateBuilder();
        fileState = fileStateBuilder.toFileState(textFile, version, gitSha, time.toString(), copyright, writers, editors, publishers, stanfordCoreNLP, lexicalizedParser);

        TxtToJsonUtil.printPrettyObjectState(fileState, textFile.getParentFile() + "/Fragments.json");


    }


}
