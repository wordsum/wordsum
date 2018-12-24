package com.wordsum.service;

import com.wordsum.process.read.models.text.FileState;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ProcessFileStateServiceTests {

    FileState fileState;

    @BeforeTest
    public void testSetup() {
        fileState = new FileState();
    }

    @Test
    public void testProcessTxt(){

        MockMultipartFile mockMultipartFile = new MockMultipartFile("foo", "foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello wordsum".getBytes());

        ProcessFileStateService service = new ProcessFileStateService();
        service.processTxt(fileState, mockMultipartFile);

        Assert.assertEquals(fileState.getParagraphStates().get(0).getSentenceStates().get(0).getFragments().get(0).getText(), "Hello wordsum");
    }

    @Test(expectedExceptions = ServiceUtilException.class)
    public void testProcessTxtNull(){

        ProcessFileStateService service = new ProcessFileStateService();
        service.processTxt(fileState, null);
    }

    @Test(expectedExceptions = ServiceUtilFileNotFoundException.class)
    public void testProcessTxtNullOriginalFilename(){

        MockMultipartFile mockMultipartFile = new MockMultipartFile("foo", null, MediaType.TEXT_PLAIN_VALUE, "Hello wordsum".getBytes());

        ProcessFileStateService service = new ProcessFileStateService();

        service.processTxt(fileState, mockMultipartFile);
    }

}
