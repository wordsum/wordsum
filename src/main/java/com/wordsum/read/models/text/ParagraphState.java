package com.wordsum.read.models.text;

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
 * Created by kalab on 6/12/15.
 * <p/>
 * A model of a state of a sentence.
 * <p/>
 * Fixes/Features:
 * ------------------
 * 1. dialog check is always false.. It's false when it is true and the sentence dialog check is working.
 * 2. parsing patterns for paragraphs and sentences = These are missing from the state and need to be in the states should be in the document.
 * 3. the properties file with the sentence and the paragraph parsing should be an enum.
 */
public class ParagraphState {

    private String paragraph;
    private Integer wordCount;
    private Integer order;
    private Integer sentenceCount;
    private boolean dialog;
    private List<String> tense;
    private List<SentenceState> sentenceStates;


    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isDialog() {
        return dialog;
    }

    public void setDialog(boolean dialog) {
        this.dialog = dialog;
    }

    public Integer getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(Integer sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public List<String> getTense() {
        return tense;
    }

    public void setTense(List<String> tense) {
        this.tense = tense;
    }

    public List<SentenceState> getSentenceStates() {
        return sentenceStates;
    }

    public void setSentenceStates(List<SentenceState> sentenceStates) {
        this.sentenceStates = sentenceStates;
    }


}
