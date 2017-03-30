package com.wordsum.edit.utils;

import com.wordsum.read.models.text.FileState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;

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
public class SpellCheck {

    private static FileState fileState;


    private static Logger logger = LoggerFactory.getLogger(SpellCheck.class);


    public static FileState main(String[] args) throws Exception {

        if (args.length == 0) {
            logger.error("You only need one argument, a path to a txt file to spellcheck.");
            logger.error("You provided zero arguments.");
            throw new FileNotFoundException();
        }

        File file = new File(args[0]);

        if (!file.isFile()) {
            logger.error("Your first argument is not a file");
            throw new FileNotFoundException();
        }

        //fileState = toFileState(args[0]);

        return fileState;
    }

}
