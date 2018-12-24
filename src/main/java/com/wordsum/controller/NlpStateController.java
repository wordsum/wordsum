package com.wordsum.controller;

import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.models.text.FileState;
import com.wordsum.service.NlpStateService;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NlpStateController {

    private static Logger logger = LoggerFactory.getLogger(NlpStateController.class);

    private final NlpStateService nlpStateService;
    private final StanfordCoreNLP stanfordCoreNLP;

    @Autowired
    public NlpStateController (NlpStateService nlpStateService) {
        this.stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        this.nlpStateService = nlpStateService;
    }

    @RequestMapping(value = "/filestate/nlpstate", method = RequestMethod.POST)
    @ResponseBody
    public FileState nlpState(@RequestBody FileState fileState){

        nlpStateService.process(stanfordCoreNLP, fileState);

        return fileState;
    }


}
