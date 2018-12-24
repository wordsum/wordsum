package com.wordsum.process.read.models.nlp;

import java.util.HashMap;
import java.util.Map;

public class Token {

    private Integer index;
    private String word;
    private String originalText;
    private String lemma;
    private Integer characterOffsetBegin;
    private Integer characterOffsetEnd;
    private String pos;
    private String ner;
    private String speaker;
    private String normalizedNER;
    private Object timex;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public Integer getCharacterOffsetBegin() {
        return characterOffsetBegin;
    }

    public void setCharacterOffsetBegin(Integer characterOffsetBegin) {
        this.characterOffsetBegin = characterOffsetBegin;
    }

    public Integer getCharacterOffsetEnd() {
        return characterOffsetEnd;
    }

    public void setCharacterOffsetEnd(Integer characterOffsetEnd) {
        this.characterOffsetEnd = characterOffsetEnd;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getNer() {
        return ner;
    }

    public void setNer(String ner) {
        this.ner = ner;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getNormalizedNER() {
        return normalizedNER;
    }

    public void setNormalizedNER(String normalizedNER) {
        this.normalizedNER = normalizedNER;
    }

    public void setTimex(Object timex) {
        this.timex = timex;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
