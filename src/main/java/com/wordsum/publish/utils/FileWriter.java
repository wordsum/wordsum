package com.wordsum.publish.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PrintWriter;
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
public class FileWriter {

    protected Logger LOG = LoggerFactory.getLogger(FileWriter.class);
    private String LINE_ENDING = "\n";

    protected String outputPath;
    protected String outputFile;
    protected List<String> lineArray;

    public FileWriter(){

    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public List<String> getLineArray() {
        return lineArray;
    }

    public void setLineArray(List<String> lineArray) {
        this.lineArray = lineArray;
    }

    public boolean publishArrayToText() throws Exception {
        boolean published = false;

        if(canPublish() && isArray(getLineArray())){
            LOG.debug("(canPublish() && isArray(getLineArray()))");
            LOG.debug("Publish array to file with print writer...");
            PrintWriter printWriter = new PrintWriter(getOutputPath() + File.separator + getOutputFile());
            for (String line: getLineArray()){
                printWriter.println(line + LINE_ENDING);
            }
            printWriter.close();
            LOG.debug("Published.");
            LOG.debug("");
            published = true;
        } else {
            LOG.debug("(canPublish() && isArray(getLineArray())) is false.");
            LOG.debug("It should be false.");
            published = false;
        }

        return published;
    }

    public boolean deleteFile(){
        boolean is = false;

        if(getOutputFile().isEmpty() || getOutputPath().isEmpty()){
            LOG.debug("(getOutputFile().isEmpty() || getOutputPath().isEmpty()) is true.");
            LOG.debug("It should be false.");
            is = false;
        } else {
            File file = new File(getOutputPath() + File.separator + getOutputFile());
            is = file.delete();
        }

        return is;
    }

    public boolean canPublish() throws Exception {

        boolean canPublish = true;

        if(getOutputFile().isEmpty() || getOutputPath().isEmpty()){
            LOG.debug("(getOutputFile().isEmpty() || getOutputPath().isEmpty()) is true.");
            LOG.debug("It should be false.");
            canPublish = false;
        }

        if(getLineArray().isEmpty()){
            LOG.debug("getLineArray().isEmpty() is true");
            LOG.debug("It should be false.");
            canPublish = false;
        }

        //Check for path
        if(!canOutputPath(getOutputPath())){
            LOG.debug(" (!canOutputPath(getOutputPath()) is true.");
            LOG.debug("It should be false.");
            canPublish = false;
        }

        /* TODO: Fix
        This doesn't work. I have not time to reason why right now.
        //Check for file
        if(!canOutputFile(getOutputPath(), getOutputFile())){
            LOG.debug("(!canOutputFile(getOutputPath(), getOutputFile())) is true.");
            LOG.debug("It should be false.");
            canPublish = false;
        }
        */
        return canPublish;
    }

    protected String concatPathFile(String path, String file){
        String pathFile = null;

        if(canOutputPath(path)){
            pathFile = path.concat(File.separator  + file);
        } else {
            LOG.debug("canOutputPath(path) is false");
            LOG.debug("It should be true.");
            pathFile = "_NO_PATH_";
        }

        return pathFile;
    }

    protected boolean canOutputPath(String path){
        boolean can = true;

        File file = null;

        if(path == null) {
            can = false;
        }

        if(can) {

            file = new File(path);

            if (!file.isDirectory()) {
                LOG.debug("(!file.isDirectory()) is true.");
                LOG.debug("It should be false.");
                can = false;
            }

            if (!file.canWrite()) {
                LOG.debug(" (!file.canWrite()) is true.");
                LOG.debug("It should be false.");
                can = false;
            }
        }

        return can;
    }

    protected boolean canOutputFile(String path, String file){
        boolean can = true;
        String stringPathFile = null;
        File pathFile = null;

        if(canOutputPath(path)){
           stringPathFile = concatPathFile(path, file);
        } else {
            LOG.debug("(canOutputPath(path)) is false.");
            LOG.debug("It should be true.");
            can = false;
        }

        pathFile = new File(stringPathFile);

        if(pathFile.isFile()){
            LOG.debug("(pathFile.isFile()) is true.");
            LOG.debug("It should be false.");
            can = false;
        }


        if(!pathFile.canWrite()){
            LOG.debug("(!pathFile.canWrite()) is true.");
            LOG.debug("It should be false.");
            can = false;
        }

        return can;
    }

    protected boolean isArray(List<String> array){
        boolean is = true;

        if(array == null){
            LOG.debug("array == null");
            LOG.debug("It should not be null.");
            is = false;
        }

        if(is){
            if(array.isEmpty()) {

                LOG.debug("array.isEmpty()");
                LOG.debug("It should not be empty.");
                is = false;
            }
        }

        return is;
    }




}
