package com.wordsum.process.read.models.text;

import com.wordsum.process.read.models.sentence.NarrativeState;
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


/**
 * SentenceState object to pass along and build.
 *
 * @author Kalab J. Oster
 */
public class SentenceState {

    private Integer order;
    private List<Fragment> fragments;
    private List<NarrativeState> narrativeStates;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public List<NarrativeState> getNarrativeStates() {
        return narrativeStates;
    }

    public void setNarrativeStates(List<NarrativeState> narrativeStates) {
        this.narrativeStates = narrativeStates;
    }

}
