package com.wordsum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.process.read.models.text.FileState;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileOutputStream;

@Validated
public final class ServiceUtil {

    private ServiceUtil(){}

    public static File processMulitifleToFile(@NotNull MultipartFile multipartFile){

        if(multipartFile == null){
            throw new ServiceUtilFileNotFoundException("Posted multipart file is null.");
        }

        if(multipartFile.getOriginalFilename() == null) {
            throw new ServiceUtilFileNotFoundException("Posted multipart file is null.");
        }

        File file = new File(multipartFile.getOriginalFilename());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();
        } catch (Exception e) {
            throw new ServiceUtilFileNotFoundException("Could not read file: " + file.getAbsolutePath(), e);
        }

        return file;
    }

    public static FileState deserializeFileState(File file){

        FileState fileState;
        ObjectMapper mapper = new ObjectMapper();
        try {
            fileState = mapper.readValue(file, FileState.class);
        } catch (Exception e){
            throw new ServiceUtilDeserializeException("Could not deserialize the file: " + file.getAbsolutePath(), e);
        }

        return fileState;
    }
}
