package com.wordsum.publish.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class CommandLineProcessBuilder {


    private static Logger logger = LoggerFactory.getLogger(CommandLineProcessBuilder.class);

    protected CommandLineProcessBuilder() {
    }

    public static ProcessBuilder initProcess(List<String> arguments) throws Exception {

        if (arguments.isEmpty()) {
            throw new Exception("You need define arguments for the process in CommandLineProcessBuilder's buildProcess.");
        }

        logger.info("Building process for command: " + arguments.toString());
        ProcessBuilder processBuilder = new ProcessBuilder(arguments);
        processBuilder.inheritIO().redirectErrorStream(true);

        return processBuilder;
    }

    Process start(String param) throws IOException {
        return null;
    }

    public Process execute(ProcessBuilder processBuilder) throws IOException, InterruptedException {

        Process process = processBuilder.start();
        process.waitFor();

        return process;
    }


    public void printProcess(Process process) throws IOException {

        String line;

        process.getOutputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while ((line = bufferedReader.readLine()) != null) {
            logger.info(line);
        }


    }


}
