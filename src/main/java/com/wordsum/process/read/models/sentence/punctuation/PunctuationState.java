package com.wordsum.process.read.models.sentence.punctuation;

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

public class PunctuationState {

    public PeriodState periodState;
    public CommaState commaState;
    public CaseState caseState;
    public String sentence;

    public PeriodState getPeriodState() {
        return periodState;
    }

    public void setPeriodState(PeriodState periodState) {
        this.periodState = periodState;
    }

    public CommaState getCommaState() {
        return commaState;
    }

    public void setCommaState(CommaState commaState) {
        this.commaState = commaState;
    }

    public CaseState getCaseState() {
        return caseState;
    }

    public void setCaseState(CaseState caseState) {
        this.caseState = caseState;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
