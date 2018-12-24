package com.wordsum.process.publish.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2017 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */

/*
 * A simple class to create a temp file for loading data
 * or test.
 *
 * It write the list of strings to the file.
 */
public class FileTemp {


    Logger LOGGER = LoggerFactory.getLogger(FileTemp.class);
    private String LINE_ENDING = "\n";

    public FileTemp(){

    }


    public File create(List<String> lines){

        File tempFile = null;

        try{

            tempFile = File.createTempFile("tempfile", ".tmp");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            for(String line: lines){
                bufferedWriter.write(line+ LINE_ENDING);
            }

            bufferedWriter.close();


        }catch(IOException e){

            e.printStackTrace();

        }

        tempFile.deleteOnExit();

        return tempFile;

    }



}
