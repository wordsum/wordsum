package com.wordsum.read.models.sentence.structure;

import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.sentence.structure.simple.SubjectVerbObjectDepEnumMap;

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

public class SimpleStructureState {

    private String sentence;
    private NlpState nlpState;
    private SubjectVerbObjectDepEnumMap subjectVerbObjectDepEnumMap;
    private List<String> subjects;
    private List<String> verbs;
    private List<String> objects;
    private boolean isState;

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

    public SubjectVerbObjectDepEnumMap getSubjectVerbObjectDepEnumMap() {
        return subjectVerbObjectDepEnumMap;
    }

    public void setSubjectVerbObjectDepEnumMap(SubjectVerbObjectDepEnumMap subjectVerbObjectDepEnumMap) {
        this.subjectVerbObjectDepEnumMap = subjectVerbObjectDepEnumMap;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getVerbs() {
        return verbs;
    }

    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    public List<String> getObjects() {
        return objects;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }

    public boolean isState() {
        return isState;
    }

    public void setState(boolean isState) {
        this.isState = isState;
    }


}
