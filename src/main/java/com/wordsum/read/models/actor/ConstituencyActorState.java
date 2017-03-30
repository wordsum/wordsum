package com.wordsum.read.models.actor;

import com.wordsum.read.models.nlp.PennTreebankState;

import java.util.ArrayList;
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

public class ConstituencyActorState {

    private String sentence;
    private PennTreebankState pennTreebankState;
    private boolean isSimpleSentence;
    private boolean isComplexSentence;
    private boolean isCompoundSentence;
    private boolean isPast;
    private boolean isPresent;
    private boolean isFuture;
    private boolean isDeclarative;
    private boolean isImperative;
    private boolean isInterrogative;
    private boolean isExclamatory;
    private List<String> performers = new ArrayList<String>();
    private List<String> acts = new ArrayList<String>();
    private List<String> receivers = new ArrayList<String>();


    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public PennTreebankState getPennTreebankState() {
        return pennTreebankState;
    }

    public void setPennTreebankState(PennTreebankState pennTreebankState) {
        this.pennTreebankState = pennTreebankState;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public void setPerformers(List<String> performers) {
        this.performers = performers;
    }

    public List<String> getActs() {
        return acts;
    }

    public void setActs(List<String> acts) {
        this.acts = acts;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }
}
