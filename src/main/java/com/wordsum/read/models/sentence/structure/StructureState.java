package com.wordsum.read.models.sentence.structure;

import com.wordsum.read.models.nlp.NlpState;

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

public class StructureState {

    private String sentence;
    private NlpState nlpState;
    private boolean maybeSimpleSentence;
    private boolean maybeComplexSentence;
    private boolean maybeCompoundSentence;
    private boolean maybeFragment;


    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public NlpState getNlpState() {
        return nlpState;
    }

    public void setNlpState(NlpState nlpState) {
        this.nlpState = nlpState;
    }

    public boolean isMaybeSimpleSentence() {
        return maybeSimpleSentence;
    }

    public void setMaybeSimpleSentence(boolean isSimpleSentence) {
        this.maybeSimpleSentence = isSimpleSentence;
    }

    public boolean isMaybeComplexSentence() {
        return maybeComplexSentence;
    }

    public void setMaybeComplexSentence(boolean isComplexSentence) {
        this.maybeComplexSentence = isComplexSentence;
    }

    public boolean isMaybeCompoundSentence() {
        return maybeCompoundSentence;
    }

    public void setMaybeCompoundSentence(boolean isCompoundSentence) {
        this.maybeCompoundSentence = isCompoundSentence;
    }

    public boolean isMaybeFragment() {
        return maybeFragment;
    }

    public void setMaybeFragment(boolean maybeFragment) {
        this.maybeFragment = maybeFragment;
    }
}
