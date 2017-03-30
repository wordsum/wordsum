package com.wordsum.publish.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
public class FileReader {


    protected FileReader() {
    }

    public static Properties readPropertiesFileToStream(String propertiesFile) throws IOException {

        Properties properties = new Properties();

        if (propertiesFile.isEmpty()) {
            throw new FileNotFoundException("Where's the fucking properties file?");
        }

        InputStream propertiesStream = FileReader.class.getResourceAsStream(propertiesFile);

        if (propertiesStream != null) {
            properties.load(propertiesStream);
        }


        return properties;

    }


    public static File readResourceFile(String file) throws Exception {

        File resourceFile = null;

        if (file.isEmpty()) {
            throw new Exception("No File for readResourceFile.");
        }

        resourceFile = new File(FileReader.class.getResource(file).getFile());

        return resourceFile;

    }

    public static String readResourceToString(File file) {

        String stringFile = null;

        try {
            stringFile = FileUtils.readFileToString(file);
        } catch (IOException e) {

        }


        return stringFile;

    }

    public static boolean checkPathAndTxtFile(String txt) {

        if (txt.isEmpty()) {
            return true;
        }

        try {
            File file = new File(txt);
        } catch (Exception e) {
            return false;
        }

        try {
            if (!new File(txt).isFile()) {
                return false;
            }

        } catch (Exception e) {

        }
        return true;
    }


    public static String readTxtFileToString(String path) {

        String stringFile = null;

        try {

            File file = new File(path);

            stringFile = FileUtils.readFileToString(file);


        } catch (IOException e) {

            e.printStackTrace();

        }

        return stringFile;

    }

}
