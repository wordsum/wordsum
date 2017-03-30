package com.wordsum.read.builders.text;

import com.wordsum.read.models.text.FileState;
import com.wordsum.read.models.text.ParagraphState;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.text.TextModelEnum;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
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

public class FileStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(FileStateBuilder.class);

    public FileStateBuilder() {
    }

    public static FileState toFileState(File file,
                                        String version,
                                        String gitSha,
                                        String localDateTime,
                                        String copyright,
                                        List<String> writers,
                                        List<String> editors,
                                        List<String> publishers,
                                        StanfordCoreNLP stanfordCoreNLP,
                                        LexicalizedParser lexicalizedParser) throws Exception {

        if (!file.exists()) {
            logger.error("Where be the file?");
        }

        String fileString = FileReader.readTxtFileToString(file.getAbsolutePath());

        FileState fileState = new FileState();
        fileState.setFile(file.getAbsolutePath());
        fileState.setVersion(version);
        fileState.setGitSha(gitSha);
        fileState.setLocalDateTime(localDateTime);
        fileState.setCopyright(copyright);
        fileState.setWriters(writers);
        fileState.setEditors(editors);
        fileState.setPublishers(publishers);
        fileState.setFileState(fileString);
        fileState.setParagraphStates(toParagraphStates(fileString, stanfordCoreNLP, lexicalizedParser));
        fileState = defineFileWordCount(fileState);

        return fileState;
    }

    public static List<ParagraphState> toParagraphStates(String file, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws Exception {


        List<ParagraphState> paragraphStates = new ArrayList<ParagraphState>();

        int paragraphInc = 0;


        for (String paragraph : file.split(TextModelEnum.ParagraphEnd.All.get())) {

            paragraphInc++;

            logger.debug(paragraph.trim());
            ParagraphState paragraphState = ParagraphStateBuilder.toParagraphState(paragraph.trim(), new Integer(paragraphInc), stanfordCoreNLP, lexicalizedParser);
            paragraphStates.add(paragraphState);

        }


        return paragraphStates;
    }

    public static FileState defineFileWordCount(FileState fileState) {

        int fileWordCount = 0;

        if (fileState.getParagraphStates() == null || fileState.getParagraphStates().isEmpty()) {

            logger.debug("fileState.getParagraphStates() is null or Empty", fileState);

        } else {

            for (ParagraphState paragraphState : fileState.getParagraphStates()) {

                fileWordCount += paragraphState.getWordCount();

            }
        }

        fileState.setWordCount(fileWordCount);

        return fileState;
    }


}
