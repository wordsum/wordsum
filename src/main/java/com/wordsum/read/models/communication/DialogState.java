package com.wordsum.read.models.communication;

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

public class DialogState {


    private String sentence;
    private String speaker;
    private String audience;
    private String scene;
    private String dialogVolume;
    private Integer originOfDialogFromOrderParagraph;
    private List dialogMark;

    private String dialogNplToken;

    private String telepathicBeginRegex;
    private String telepathicContinueRegex;
    private String telepathicEndRegex;

    private String internalBeginRegex;
    private String internalContinueRegex;
    private String internalEndRegex;

    private String audioBeginRegex;
    private String audioContinueRegex;
    private String audioEndRegex;

    private String telepathicBeginUnicode;
    private String telepathicContinueUnicode;
    private String telepathicEndUnicode;

    private String internalBeginUnicode;
    private String internalContinueUnicode;
    private String internalEndUnicode;

    private String audioBeginUnicode;
    private String audioContinueUnicode;
    private String audioEndUnicode;

    private String dialogEnglishMark;

    private String telepathicBeginMark;
    private String telepathicContinueMark;
    private String telepathicEndMark;

    private String internalBeginMark;
    private String internalContinueMark;
    private String internalEndMark;

    private String audioBeginMark;
    private String audioContinueMark;
    private String audioEndMark;

    private boolean dialog;
    private boolean dialogBegin;
    private boolean dialogEnd;
    private boolean dialogContinue;
    private boolean isTelepathic;
    private boolean isInternal;
    private boolean isAudio;


    public DialogState() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getDialogVolume() {
        return dialogVolume;
    }

    public void setDialogVolume(String dialogVolume) {
        this.dialogVolume = dialogVolume;
    }

    public List getDialogMark() {
        return dialogMark;
    }

    public void setDialogMark(List dialogMark) {
        this.dialogMark = dialogMark;
    }

    public boolean isDialog() {
        return this.dialog;
    }

    public void setIsDialog(boolean isDialog) {
        this.dialog = isDialog;
    }

    public boolean isDialogContinue() {
        return dialogContinue;
    }

    public void setDialogContinue(boolean isDialogContinue) {
        this.dialogContinue = isDialogContinue;
    }

    public boolean isDialogBegin() {
        return dialogBegin;
    }

    public void setDialogBegin(boolean isDialogBegin) {
        this.dialogBegin = isDialogBegin;
    }

    public boolean isDialogEnd() {
        return dialogEnd;
    }

    public void setDialogEnd(boolean isDialogEnd) {
        this.dialogEnd = isDialogEnd;
    }

    public Integer getOriginOfDialogFromOrderParagraph() {
        return originOfDialogFromOrderParagraph;
    }

    public void setOriginOfDialogFromOrderParagraph(Integer originOfDialogFromOrderParagraph) {
        this.originOfDialogFromOrderParagraph = originOfDialogFromOrderParagraph;
    }

    public String getDialogNplToken() {
        return dialogNplToken;
    }

    public void setDialogNplToken(String dialogNplToken) {
        this.dialogNplToken = dialogNplToken;
    }

    public String getTelepathicBeginUnicode() {
        return telepathicBeginUnicode;
    }

    public void setTelepathicBeginUnicode(String telepathicBeginUnicode) {
        this.telepathicBeginUnicode = telepathicBeginUnicode;
    }

    public String getTelepathicContinueUnicode() {
        return telepathicContinueUnicode;
    }

    public void setTelepathicContinueUnicode(String telepathicContinueUnicode) {
        this.telepathicContinueUnicode = telepathicContinueUnicode;
    }

    public String getTelepathicEndUnicode() {
        return telepathicEndUnicode;
    }

    public void setTelepathicEndUnicode(String telepathicEndUnicode) {
        this.telepathicEndUnicode = telepathicEndUnicode;
    }

    public String getInternalBeginUnicode() {
        return internalBeginUnicode;
    }

    public void setInternalBeginUnicode(String internalBeginUnicode) {
        this.internalBeginUnicode = internalBeginUnicode;
    }

    public String getInternalContinueUnicode() {
        return internalContinueUnicode;
    }

    public void setInternalContinueUnicode(String internalContinueUnicode) {
        this.internalContinueUnicode = internalContinueUnicode;
    }

    public String getInternalEndUnicode() {
        return internalEndUnicode;
    }

    public void setInternalEndUnicode(String internalEndUnicode) {
        this.internalEndUnicode = internalEndUnicode;
    }

    public String getAudioBeginUnicode() {
        return audioBeginUnicode;
    }

    public void setAudioBeginUnicode(String audioBeginUnicode) {
        this.audioBeginUnicode = audioBeginUnicode;
    }

    public String getAudioContinueUnicode() {
        return audioContinueUnicode;
    }

    public void setAudioContinueUnicode(String audioContinueUnicode) {
        this.audioContinueUnicode = audioContinueUnicode;
    }

    public String getAudioEndUnicode() {
        return audioEndUnicode;
    }

    public void setAudioEndUnicode(String audioEndUnicode) {
        this.audioEndUnicode = audioEndUnicode;
    }

    public String getDialogEnglishMark() {
        return dialogEnglishMark;
    }

    public void setDialogEnglishMark(String dialogEnglishMark) {
        this.dialogEnglishMark = dialogEnglishMark;
    }

    public String getTelepathicBeginMark() {
        return telepathicBeginMark;
    }

    public void setTelepathicBeginMark(String telepathicBeginMark) {
        this.telepathicBeginMark = telepathicBeginMark;
    }

    public String getTelepathicContinueMark() {
        return telepathicContinueMark;
    }

    public void setTelepathicContinueMark(String telepathicContinueMark) {
        this.telepathicContinueMark = telepathicContinueMark;
    }

    public String getTelepathicEndMark() {
        return telepathicEndMark;
    }

    public void setTelepathicEndMark(String telepathicEndMark) {
        this.telepathicEndMark = telepathicEndMark;
    }

    public String getInternalBeginMark() {
        return internalBeginMark;
    }

    public void setInternalBeginMark(String internalBeginMark) {
        this.internalBeginMark = internalBeginMark;
    }

    public String getInternalContinueMark() {
        return internalContinueMark;
    }

    public void setInternalContinueMark(String internalContinueMark) {
        this.internalContinueMark = internalContinueMark;
    }

    public String getInternalEndMark() {
        return internalEndMark;
    }

    public void setInternalEndMark(String internalEndMark) {
        this.internalEndMark = internalEndMark;
    }

    public String getAudioBeginMark() {
        return audioBeginMark;
    }

    public void setAudioBeginMark(String audioBeginMark) {
        this.audioBeginMark = audioBeginMark;
    }

    public String getAudioContinueMark() {
        return audioContinueMark;
    }

    public void setAudioContinueMark(String audioContinueMark) {
        this.audioContinueMark = audioContinueMark;
    }

    public String getAudioEndMark() {
        return audioEndMark;
    }

    public void setAudioEndMark(String audioEndMark) {
        this.audioEndMark = audioEndMark;
    }


    public String getTelepathicBeginRegex() {
        return telepathicBeginRegex;
    }

    public void setTelepathicBeginRegex(String telepathicBeginRegex) {
        this.telepathicBeginRegex = telepathicBeginRegex;
    }

    public String getTelepathicContinueRegex() {
        return telepathicContinueRegex;
    }

    public void setTelepathicContinueRegex(String telepathicContinueRegex) {
        this.telepathicContinueRegex = telepathicContinueRegex;
    }

    public String getTelepathicEndRegex() {
        return telepathicEndRegex;
    }

    public void setTelepathicEndRegex(String telepathicEndRegex) {
        this.telepathicEndRegex = telepathicEndRegex;
    }

    public String getInternalBeginRegex() {
        return internalBeginRegex;
    }

    public void setInternalBeginRegex(String internalBeginRegex) {
        this.internalBeginRegex = internalBeginRegex;
    }

    public String getInternalContinueRegex() {
        return internalContinueRegex;
    }

    public void setInternalContinueRegex(String internalContinueRegex) {
        this.internalContinueRegex = internalContinueRegex;
    }

    public String getInternalEndRegex() {
        return internalEndRegex;
    }

    public void setInternalEndRegex(String internalEndRegex) {
        this.internalEndRegex = internalEndRegex;
    }

    public String getAudioBeginRegex() {
        return audioBeginRegex;
    }

    public void setAudioBeginRegex(String audioBeginRegex) {
        this.audioBeginRegex = audioBeginRegex;
    }

    public String getAudioContinueRegex() {
        return audioContinueRegex;
    }

    public void setAudioContinueRegex(String audioContinueRegex) {
        this.audioContinueRegex = audioContinueRegex;
    }

    public String getAudioEndRegex() {
        return audioEndRegex;
    }

    public void setAudioEndRegex(String audioEndRegex) {
        this.audioEndRegex = audioEndRegex;
    }

}
