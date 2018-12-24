package com.wordsum.service;

import com.wordsum.process.read.builders.text.FileStateBuilder;
import com.wordsum.process.read.models.text.FileState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Service;

@Service
public class ProcessNlpStateService implements NlpStateService {

    @Override
    public FileState process(StanfordCoreNLP stanfordCoreNLP, FileState fileState) {

        if(fileState == null) {
            throw new NlpStateException("fileState is null.");
        }

        try {
            fileState = FileStateBuilder.buildFileState(fileState, stanfordCoreNLP);
        } catch (Exception e) {
            throw new FileStateBuildException("Could not build the wordsum model.", e);
        }

        return fileState;
    }
}
