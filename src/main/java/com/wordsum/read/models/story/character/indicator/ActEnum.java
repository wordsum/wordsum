package com.wordsum.read.models.story.character.indicator;

/**
 * Enum to have the tags of acts.
 */
public enum ActEnum {

    VB("VB"),
    VBD("VBD"),
    VBG("VBS"),
    VBN("VBN"),
    VBP("VBP"),
    VBZ("VBZ"),
    ALL("VB");


    ActEnum(String verb){
        this.verb = verb;
    }

    String verb;
    public String getActEnum() {
        return verb;
    }



}
