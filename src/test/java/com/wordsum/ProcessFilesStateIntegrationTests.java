package com.wordsum;

import com.wordsum.process.read.models.text.FileState;
import com.wordsum.service.FileStateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessFilesStateIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private FileStateService fileStateService;

    @MockBean
    private FileState fileState;

    @LocalServerPort
    private int port;

    @Test
    public void testFilestate() throws Exception {
        ClassPathResource resource = new ClassPathResource("text.txt", getClass());
        fileState = new FileState();

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("file", resource);
        ResponseEntity<String> response = this.restTemplate.postForEntity("/filestate", map, String.class);

        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        then(fileStateService).should().processTxt(any(), any(MultipartFile.class));
    }


}
