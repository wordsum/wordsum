package com.wordsum.read.builders.communication;

import com.wordsum.read.models.communication.DialogState;
import com.wordsum.read.models.communication.DialogStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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


/*
 * This builds an object of dialog state of a string. Its purpose is to be able to define sentences of dialog in a
 * narrative has dialog and if it does then defined as much about its state.
 *
 */
public class DialogStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(DialogStateBuilder.class);

    public DialogStateBuilder() {
    }

    /**
     * A method to set the syntax for the types of known communication.
     *
     * @param dialogState
     * @return
     * @throws IOException
     */
    public DialogState defineDialogStateSyntax(DialogState dialogState) throws IOException {

        //Defined the token NLP knows by default as dialog.
        dialogState.setDialogNplToken(DialogStateEnum.Nlp.Token.get());

        //Define Telepathic syntax
        dialogState.setTelepathicBeginRegex(DialogStateEnum.Telepathic.BeginRegex.get());
        dialogState.setTelepathicContinueRegex(DialogStateEnum.Telepathic.ContinueRegex.get());
        dialogState.setTelepathicEndRegex(DialogStateEnum.Telepathic.EndRegex.get());

        dialogState.setTelepathicBeginMark(DialogStateEnum.Telepathic.BeginMark.get());
        dialogState.setTelepathicContinueMark(DialogStateEnum.Telepathic.ContinueMark.get());
        dialogState.setTelepathicEndMark(DialogStateEnum.Telepathic.EndMark.get());

        dialogState.setTelepathicBeginUnicode(DialogStateEnum.Telepathic.BeginUnicode.get());
        dialogState.setTelepathicContinueUnicode(DialogStateEnum.Telepathic.ContinueUnicode.get());
        dialogState.setTelepathicEndUnicode(DialogStateEnum.Telepathic.EndUnicode.get());

        //Define internal dialog syntax.
        dialogState.setInternalBeginRegex(DialogStateEnum.Internal.BeginRegex.get());
        dialogState.setInternalContinueRegex(DialogStateEnum.Internal.ContinueRegex.get());
        dialogState.setInternalEndRegex(DialogStateEnum.Internal.EndRegex.get());

        dialogState.setInternalBeginMark(DialogStateEnum.Internal.BeginMark.get());
        dialogState.setInternalContinueMark(DialogStateEnum.Internal.ContinueMark.get());
        dialogState.setInternalEndMark(DialogStateEnum.Internal.EndMark.get());

        dialogState.setInternalBeginUnicode(DialogStateEnum.Internal.BeginUnicode.get());
        dialogState.setInternalContinueUnicode(DialogStateEnum.Internal.ContinueUnicode.get());
        dialogState.setInternalEndUnicode(DialogStateEnum.Internal.EndUnicode.get());

        //Define talking syntax
        dialogState.setAudioBeginRegex(DialogStateEnum.Audio.BeginRegex.get());
        dialogState.setAudioContinueRegex(DialogStateEnum.Audio.ContinueRegex.get());
        dialogState.setAudioEndRegex(DialogStateEnum.Audio.EndRegex.get());

        dialogState.setAudioBeginMark(DialogStateEnum.Audio.BeginMark.get());
        dialogState.setAudioContinueMark(DialogStateEnum.Audio.ContinueMark.get());
        dialogState.setAudioEndMark(DialogStateEnum.Audio.EndMark.get());

        dialogState.setAudioBeginUnicode(DialogStateEnum.Audio.BeginUnicode.get());
        dialogState.setAudioContinueUnicode(DialogStateEnum.Audio.ContinueUnicode.get());
        dialogState.setAudioEndUnicode(DialogStateEnum.Audio.EndUnicode.get());

        return dialogState;

    }


    public DialogState checkSentenceForDialogMark(DialogState dialogState) throws Exception {

        if (dialogState.getSentence() == null) {
            throw new Exception("dialogState.getSentence() in checkSentenceForDialogMark is null.");
        }

        //TODO: Make the audio begin some enum result that could be checked and set.
        dialogState = checkAudioBegin(dialogState);
        dialogState = checkAudioContinue(dialogState);
        dialogState = checkAudioEnd(dialogState);

        dialogState = checkTelepathicBegin(dialogState);
        dialogState = checkTelepathicContinue(dialogState);
        dialogState = checkTelepathicEnd(dialogState);

        dialogState = checkInternalBegin(dialogState);
        dialogState = checkInternalContinue(dialogState);
        dialogState = checkInternalEnd(dialogState);

        return dialogState;
    }

    public boolean isDialogInString(String sentence){

        boolean is = false;

        for(DialogStateEnum.Audio dialog: DialogStateEnum.audio){
            if(sentence.contains(dialog.get())){
                is = true;
            }
        }


        for(DialogStateEnum.Internal dialog: DialogStateEnum.internal){
            if(sentence.contains(dialog.get())){
                is = true;
            }
        }

        for(DialogStateEnum.Telepathic dialog: DialogStateEnum.telepathic){
            if(sentence.contains(dialog.get())){
                is = true;
            }
        }


        return is;
    }


    /**
     * Check to to see it the string begins and ends with dialog marks.
     * We can use this to assmuse if parsed then it is dialog beginning to end.
     *
     * @param sentence
     * @return
     */
    public boolean isDialogInStringComplete(String sentence){

        boolean is = false;

        if(sentence.matches(DialogStateEnum.Audio.BeginEndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Audio.ContinueEndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Telepathic.BeginEndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Telepathic.ContinueEndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Internal.BeginEndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Internal.ContinueEndRegex.get())){
            is = true;
        }

        return is;
    }


    public boolean isDialogBeginString(String sentence){

        boolean is = false;

        if(sentence.matches(DialogStateEnum.Audio.BeginString.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Telepathic.BeginString.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Internal.BeginString.get())){
            is = true;
        }

        return is;
    }


    public boolean isDialogEndString(String sentence){

        boolean is = false;

        if(sentence.matches(DialogStateEnum.Audio.EndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Telepathic.EndRegex.get())){
            is = true;
        }
        if(sentence.matches(DialogStateEnum.Internal.EndRegex.get())){
            is = true;
        }

        return is;
    }


    public DialogState checkAudioBegin(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getAudioBeginRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getAudioBeginRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogBegin(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }

    //TODO: All the following methods could be one.
    /**
     *
     * @param dialogState
     * @return
     */
    public DialogState checkAudioContinue(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getAudioContinueRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getAudioContinueRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogContinue(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }

    public DialogState checkAudioEnd(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getAudioEndRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getAudioEndRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogEnd(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }

    public DialogState checkTelepathicBegin(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getTelepathicBeginRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getTelepathicBeginRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogBegin(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }


    public DialogState checkTelepathicContinue(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getTelepathicContinueRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getTelepathicContinueRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogContinue(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }


    public DialogState checkTelepathicEnd(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getTelepathicEndRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getTelepathicEndRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogEnd(true);
            dialogState.setIsDialog(true);

        }


        return dialogState;
    }

    public DialogState checkInternalBegin(DialogState dialogState) {


        if (dialogState.getSentence().matches(dialogState.getInternalBeginRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getInternalBeginRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogBegin(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }

    public DialogState checkInternalContinue(DialogState dialogState) {


        if (dialogState.getSentence().matches(dialogState.getInternalContinueRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getInternalContinueRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogContinue(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }


    public DialogState checkInternalEnd(DialogState dialogState) {

        if (dialogState.getSentence().matches(dialogState.getInternalEndRegex())) {

            List marks = dialogState.getDialogMark();
            if (marks == null) {
                marks = new ArrayList();
            }

            marks.add(dialogState.getInternalEndRegex());

            dialogState.setDialogMark(marks);
            dialogState.setDialogEnd(true);
            dialogState.setIsDialog(true);

        }

        return dialogState;
    }

    public void findDialogCreator() {

    }


}
