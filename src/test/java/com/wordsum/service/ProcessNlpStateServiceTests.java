package com.wordsum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.process.publish.utils.FileReaderUtil;
import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.models.text.FileState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ProcessNlpStateServiceTests {

    FileState fileState;
    StanfordCoreNLP stanfordCoreNLP;

    @BeforeTest
    public void setup() throws Exception {
        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
        File testFile = FileReaderUtil.readResourceFile("/BabaYagaSneakAttack.txt.json");
        ObjectMapper mapper = new ObjectMapper();
        fileState = mapper.readValue(testFile, FileState.class);
    }

    @Test
    public void testProcessSuccess(){

        ProcessNlpStateService service = new ProcessNlpStateService();
        FileState testFileState = service.process(stanfordCoreNLP, fileState);

        Assert.assertEquals(testFileState.getParagraphStates().get(0).getSentenceStates().get(0).getNarrativeStates().get(0).getNlpState().getSentences().get(0).getIndex(), new Integer(0));
    }
}
