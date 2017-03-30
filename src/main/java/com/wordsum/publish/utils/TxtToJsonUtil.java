package com.wordsum.publish.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.text.FileState;
import com.wordsum.read.builders.text.FileStateBuilder;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
public class TxtToJsonUtil {
    String version = "0.9.0";
    String gitSha = "51952dbc2fdddaee32ebf0740364be16a9cdebc9";
    LocalDateTime time = LocalDateTime.now();
    List<String> writers = new ArrayList<String>();
    List<String> editors = new ArrayList<String>();
    List<String> publishers = new ArrayList<String>();
    StanfordCoreNLP stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
    LexicalizedParser lexicalizedParser = NlpStateBuilder.loadLexicalParser();



    public static void main(String[] args) throws Exception {

        String version = "0.0.2";
        String gitSha = "30edb575085b45266571fd12f3b14e086963ece2";
        String copyright = "Yes";
        LocalDateTime time = LocalDateTime.now();
        List<String> writers = new ArrayList<String>();
        List<String> editors = new ArrayList<String>();
        List<String> publishers = new ArrayList<String>();
        StanfordCoreNLP stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        LexicalizedParser lexicalizedParser = NlpStateBuilder.loadLexicalParser();

        writers.add("Kalab J. Oster");
        editors.add("Kalab J. Oster");
        publishers.add("Word Prostitute\u00ae");



        File textFile = new File("/gitbox/Word/Prostitute/Product/Goods/Words/Naturalization_Trilogy/Alien_Registration_Chip/1.txt");
        FileStateBuilder fileStateBuilder = new FileStateBuilder();
        FileState fileState = fileStateBuilder.toFileState(textFile, version, gitSha, time.toString(), copyright, writers, editors, publishers, stanfordCoreNLP, lexicalizedParser);

        //printPrettyObjectState(fileState,textFile.getParentFile() + "/SubjectVerbObjects.json");
        printPrettyObjectState(fileState, "/home/kalab/Desktop/tools/BrokenEnglishFictionModel.json");

    }

    public static void printPrettyObjectState(Object objectState, String pathFile) throws IOException {

        //Print the pretty
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonElement jsonElement = jsonParser.parse(objectMapper.writeValueAsString(objectState));

        String prettyJsonString = gson.toJson(jsonElement);

        FileUtils.writeStringToFile(new File(pathFile), prettyJsonString);

    }

}
