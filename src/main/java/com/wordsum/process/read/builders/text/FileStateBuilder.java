package com.wordsum.process.read.builders.text;

import com.wordsum.process.publish.utils.FileReaderUtil;
import com.wordsum.process.read.builders.sentence.SentenceUtil;
import com.wordsum.process.read.models.text.FileState;
import com.wordsum.process.read.models.text.ParagraphState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.LinkedList;

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

public final class FileStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(FileStateBuilder.class);

    private final static String REGEX_PARAGRAPH = "(\n\n|\n)";

    private FileStateBuilder() {
    }


    public static FileState buildFileState(@NotNull FileState fileState, @NotNull File file) throws Exception {

        fileState.setFile(file.getAbsolutePath());

        buildParagraphStatesFile(fileState);

        return fileState;
    }

    public static FileState buildFileState(@NotNull FileState fileState, @NotNull StanfordCoreNLP stanfordCoreNLP) throws Exception {

        buildParagraphStatesNlp(fileState, stanfordCoreNLP);

        return fileState;
    }

    public static FileState buildParagraphStatesFile(@NotNull FileState fileState) throws Exception {

        if(fileState.getFile() == null){
            throw new NullPointerException("fileState.getFile() is null");
        }
        if(fileState.getParagraphStates() == null){
            fileState.setParagraphStates(new LinkedList<ParagraphState>());
        }

        File file = new File(fileState.getFile());
        int order = 1;

        for(String paragraph: FileReaderUtil.readFileToString(file).split(REGEX_PARAGRAPH)){
            ParagraphState paragraphState = new ParagraphState();
            ParagraphStateBuilder.addStringText(paragraphState, paragraph);
            SentenceUtil.tagParagraph(paragraphState);
            paragraphState.setOrder(order);
            fileState.getParagraphStates().add(paragraphState);
            order++;
        }

        return fileState;
    }

    public static FileState buildParagraphStatesNlp(@NotNull FileState fileState, @NotNull StanfordCoreNLP stanfordCoreNLP) throws Exception {

        for(ParagraphState paragraphState: fileState.getParagraphStates()){
            ParagraphStateBuilder.addNlp(paragraphState, stanfordCoreNLP);
        }

        return fileState;
    }

}
