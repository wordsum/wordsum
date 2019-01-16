package com.wordsum.process.read.models.sentence;

import com.wordsum.process.read.models.nlp.NlpState;
import com.wordsum.process.read.models.text.Fragment;

import java.util.List;

public class NarrativeState {

    private List<Fragment> fragments;
    private NlpState nlpState;

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public NlpState getNlpState() {
        return nlpState;
    }

    public void setNlpState(NlpState nlpState) {
        this.nlpState = nlpState;
    }

}

