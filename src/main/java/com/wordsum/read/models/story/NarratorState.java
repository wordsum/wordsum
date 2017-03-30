package com.wordsum.read.models.story;

import com.wordsum.read.models.text.SentenceState;

import java.util.List;

/**
 * Created by kalab on 9/6/15.
 */
public class NarratorState {


    String pointOfView;
    String reliabilityState;
    Integer number;
    List<SentenceState> sentenceStates;

    public String getPointOfView() {
        return pointOfView;
    }

    public void setPointOfView(String pointOfView) {
        this.pointOfView = pointOfView;
    }

    public String getReliabilityState() {
        return reliabilityState;
    }

    public void setReliabilityState(String reliabilityState) {
        this.reliabilityState = reliabilityState;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<SentenceState> getSentenceStates() {
        return sentenceStates;
    }

    public void setSentenceStates(List<SentenceState> sentenceStates) {
        this.sentenceStates = sentenceStates;
    }

    public void addSentenceState(SentenceState sentenceState) {
        this.sentenceStates.add(sentenceState);
    }
}
