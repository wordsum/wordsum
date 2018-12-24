package com.wordsum.service;

import com.wordsum.process.publish.utils.FileReaderUtil;
import com.wordsum.process.read.models.text.FileState;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;

public class ServiceUtilTests {

    @Test
    public void testProcessMulitifleToFileSuccess() throws Exception {
        File testFile = FileReaderUtil.readResourceFile("/filestate.json");
        byte[] fileBytes = Files.readAllBytes(testFile.toPath());
        MockMultipartFile mockMultipartFile = new MockMultipartFile("foo", "foo.json", MediaType.TEXT_PLAIN_VALUE, fileBytes);

        File file = ServiceUtil.processMulitifleToFile(mockMultipartFile);

        Assert.assertNotNull(file);
        Assert.assertEquals(file.length(), 7108691);
    }

    @Test(expectedExceptions = ServiceUtilException.class)
    public void testProcessMulitifleToFileNullFile() throws Exception {
        File file = ServiceUtil.processMulitifleToFile(null);
    }

    @Test
    public void testDeserializeFileState() throws Exception {
        File testFile = FileReaderUtil.readResourceFile("/filestate.json");
        FileState fileState = ServiceUtil.deserializeFileState(testFile);

        Assert.assertEquals(fileState.getParagraphStates().get(0).getSentenceStates().get(0).getFragments().get(0).getText(), "\"Why?\" ");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testDeserializeFileStateNull() throws Exception {
        ServiceUtil.deserializeFileState(null);
    }

}
