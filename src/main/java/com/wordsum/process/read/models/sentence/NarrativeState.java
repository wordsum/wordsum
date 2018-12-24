package com.wordsum.process.read.models.sentence;

import com.wordsum.process.read.models.dictionary.DictionaryState;
import com.wordsum.process.read.models.nlp.NlpState;
import com.wordsum.process.read.models.sentence.perspective.PerspectiveState;
import com.wordsum.process.read.models.sentence.tense.TenseState;
import com.wordsum.process.read.models.text.Fragment;

import java.util.List;

public class NarrativeState {

    private List<Fragment> fragments;
    private DictionaryState dictionaryState;
    private NlpState nlpState;
    private PerspectiveState perspectiveState;
    private TenseState tenseState;

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public DictionaryState getDictionaryState() {
        return dictionaryState;
    }

    public void setDictionaryState(DictionaryState dictionaryState) {
        this.dictionaryState = dictionaryState;
    }

    public NlpState getNlpState() {
        return nlpState;
    }

    public void setNlpState(NlpState nlpState) {
        this.nlpState = nlpState;
    }

    public PerspectiveState getPerspectiveState() {
        return perspectiveState;
    }

    public void setPerspectiveState(PerspectiveState perspectiveState) {
        this.perspectiveState = perspectiveState;
    }

    public TenseState getTenseState() {
        return tenseState;
    }

    public void setTenseState(TenseState tenseState) {
        this.tenseState = tenseState;
    }

}

