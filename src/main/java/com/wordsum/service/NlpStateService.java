package com.wordsum.service;

import com.wordsum.process.read.models.text.FileState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public interface NlpStateService {

    FileState process(StanfordCoreNLP stanfordCoreNLP, FileState fileState);

}
