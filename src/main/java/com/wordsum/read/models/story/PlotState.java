package com.wordsum.read.models.story;

import com.wordsum.read.models.text.FileState;

import java.util.List;
import java.util.Map;

/**
 * A model to define a story current plot state.
 */

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

public class PlotState {


    public List<FileState> fileStates;
    private Map<String, Map<String, List<Float>>> wordVectors;


}