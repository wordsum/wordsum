package com.wordsum.service;

import com.wordsum.process.read.models.text.FileState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.web.multipart.MultipartFile;

public interface FileStateService {

    FileState processTxt(FileState fileState, MultipartFile file) throws Exception;

}
