package com.wordsum.process.publish.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Open Story License
 * <p>
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2018 Kalab J. Oster(TM)
 * <p>
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */
public final class FileReaderUtil {


    private FileReaderUtil() {}

    public static Properties readPropertiesFileToStream(String propertiesFile) throws IOException {

        Properties properties = new Properties();

        if (propertiesFile.isEmpty()) {
            throw new FileNotFoundException("Missing properties file.");
        }

        InputStream propertiesStream = FileReaderUtil.class.getResourceAsStream(propertiesFile);

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

        resourceFile = new File(FileReaderUtil.class.getResource(file).getFile());

        return resourceFile;

    }

    public static String readFileToString(File file) throws IOException {

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        return contentBuilder.toString();

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

}
