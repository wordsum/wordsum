package com.wordsum.read.models.text;

import com.wordsum.read.models.actor.SentenceActorState;
import com.wordsum.read.models.communication.DialogState;
import com.wordsum.read.models.dictionary.JazzyState;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.punctuation.PunctuationState;

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

    private boolean isCompleteSentence;
    private String sentence;
    private Integer wordCount;
    private Integer orderParagraph;
    private List<String> tense;
    private NlpState nlpState;
    private SentenceActorState sentenceActorState;
    private PunctuationState punctuationState;
    private JazzyState jazzyState;
    private DialogState dialogState;


    public boolean isCompleteSentence() {
        return isCompleteSentence;
    }

    public void setCompleteSentence(boolean isCompleteSentence) {
        this.isCompleteSentence = isCompleteSentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getOrderParagraph() {
        return orderParagraph;
    }

    public void setOrderParagraph(Integer orderParagraph) {
        this.orderParagraph = orderParagraph;
    }

    public List<String> getTense() {
        return tense;
    }

    public void setTense(List<String> tense) {
        this.tense = tense;
    }

    public void addTense(List<String> tense) {
        this.tense = tense;
    }

    public NlpState getNlpState() {
        return nlpState;
    }

    public void setNlpState(NlpState nlpState) {
        this.nlpState = nlpState;
    }

    public SentenceActorState getSentenceActorState() {
        return sentenceActorState;
    }

    public void setSentenceActorState(SentenceActorState sentenceActorState) {
        this.sentenceActorState = sentenceActorState;
    }

    public PunctuationState getPunctuationState() {
        return punctuationState;
    }

    public void setPunctuationState(PunctuationState punctuationState) {
        this.punctuationState = punctuationState;
    }


    public JazzyState getJazzyState() {
        return jazzyState;
    }

    public void setJazzyState(JazzyState jazzyState) {
        this.jazzyState = jazzyState;
    }

    public DialogState getDialogState() {
        return dialogState;
    }

    public void setDialogState(DialogState dialogState) {
        this.dialogState = dialogState;
    }

}


