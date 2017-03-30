package com.wordsum.read.models.nlp;


import java.util.HashMap;
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
 * A model to define an NlpState.
 *
 * Its purpose is to abstract what ever parse is used into a standard
 * model for all the other model so be able use fit into their model
 * if this model is used.
 */
public class NlpState {

    private String sentence;
    private List<HashMap<String, String>> coreAnnotations;
    private List<HashMap<String, HashMap<String, String>>> typedDependency;
    private PennTreebankState pennTreebankState;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<HashMap<String, String>> getCoreAnnotations() {
        return coreAnnotations;
    }

    public void setCoreAnnotations(List<HashMap<String, String>> coreAnnotations) {
        this.coreAnnotations = coreAnnotations;
    }

    public List<HashMap<String, HashMap<String, String>>> getTypedDependency() {
        return typedDependency;
    }

    public void setTypedDependency(List<HashMap<String, HashMap<String, String>>> typedDependency) {
        this.typedDependency = typedDependency;
    }

    public void addTypedDependencyList(HashMap<String, HashMap<String, String>> typedDependency) {
        this.typedDependency.add(typedDependency);
    }

    public PennTreebankState getPennTreebankState() {
        return pennTreebankState;
    }

    public void setPennTreebankState(PennTreebankState pennTreebankState) {
        this.pennTreebankState = pennTreebankState;
    }
}
