package com.wordsum.service;

import com.wordsum.process.read.builders.text.FileStateBuilder;
import com.wordsum.process.read.models.text.FileState;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static com.wordsum.service.ServiceUtil.processMulitifleToFile;

@Service
public class ProcessFileStateService implements FileStateService {

    @Override
    public FileState processTxt(FileState fileState, MultipartFile multipartFile) {

        File file = processMulitifleToFile(multipartFile);

        if(fileState == null) {
            fileState = new FileState();
        }
        fileState.setFile(multipartFile.getOriginalFilename());

        try {
            fileState = FileStateBuilder.buildFileState(fileState, file);
        } catch (Exception e) {
            throw new FileStateBuildException("Could not build the wordsum model.", e);
        }

        return fileState;
    }
}
