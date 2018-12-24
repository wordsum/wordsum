package com.wordsum.process.read.models.sentence.narrative;

import java.util.ArrayList;
import java.util.EnumSet;


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
 * An class of enum and enum sets to define and automate dialog creation.
 */
public class DialogStateEnum {

    public static EnumSet<Telepathic> telepathic = EnumSet.of(Telepathic.BeginMark, Telepathic.ContinueMark, Telepathic.EndMark, Telepathic.BeginUnicode, Telepathic.ContinueUnicode, Telepathic.EndUnicode,Telepathic.BeginRegex, Telepathic.ContinueRegex, Telepathic.EndRegex, Telepathic.BeginEndRegex, Telepathic.ContinueEndRegex, Telepathic.BeginString);
    public static EnumSet<Internal> internal = EnumSet.of(Internal.BeginMark, Internal.ContinueMark, Internal.EndMark, Internal.BeginUnicode, Internal.ContinueUnicode, Internal.EndUnicode,Internal.BeginRegex, Internal.ContinueRegex, Internal.EndRegex, Internal.BeginEndRegex, Internal.ContinueEndRegex, Internal.BeginString);
    public static EnumSet<Audio> audio = EnumSet.of(Audio.BeginMark, Audio.ContinueMark, Audio.EndMark, Audio.BeginUnicode, Audio.ContinueUnicode, Audio.EndUnicode,Audio.BeginRegex, Audio.ContinueRegex, Audio.EndRegex, Audio.BeginEndRegex, Audio.ContinueEndRegex, Audio.BeginString);

    /**
     *         if dialog_continuing_mark_to_narrator is None:
     self._dialog_continuing_mark_to_narrator = ",\"\s+|,''\s+|,>\s+|,<\s+"
     else:
     self._dialog_continuing_mark_to_narrator = dialog_continuing_mark_to_narrator


     if  dialog_mark_begin is None:
     self._dialog_mark_begin = "^''|^\"|^,,|^<|^>"
     else:
     self._dialog_mark_begin =  dialog_mark_begin


     if  dialog_mark_end is None:
     self._dialog_mark_end = "!''$|!\"$|!<$|!>$|\?''$|\?\"$|\?<$|\?>$|\.''$|\.\"$|\.<$|\.>$|\.$|!$|\?$"
     else:
     self._dialog_mark_end =  dialog_mark_end


     if  dialog_ending_mark is None:
     self._dialog_ending_mark = "\?''\s+|\.''\s+|!''\s+|\.>\s+|\?>\s+|!>\s+|\.<\s+|\?<\s+|!<\s+|!\"\s+|\.\"\s+|\?\"\s+"
     else:
     self._dialog_ending_mark =  dialog_ending_mark


     if  dialog_beginning_mark is None:
     self._dialog_beginning_mark = ",,|''|<\||>\||<|>|\""
     else:
     self._dialog_beginning_mark =  dialog_beginning_mark


     if  narrator_continuing_mark_to_dialog is None:
     self._narrator_continuing_mark_to_dialog = ",\s+>\||,\s+<\||,\s+>|,\s+<|,\s+''|,\s+,,|,\s+\""
     else:
     self._narrator_continuing_mark_to_dialog =  narrator_continuing_mark_to_dialog


     if narrator_ending_mark is None:
     self._narrator_ending_mark = "!\s+|\.\s+|\?\s+"
     else:
     self._narrator_ending_mark  = narrator_ending_mark



     if split is None:
     self._split =  "(" + self._narrator_continuing_mark_to_dialog + "|" + self._narrator_ending_mark + "|" + self._dialog_continuing_mark_to_narrator + "|" + self._dialog_mark_begin + "|" + self._dialog_mark_end + "|" + self._dialog_ending_mark + "|" + self._dialog_beginning_mark + ")"
     else:
     self._split = split

     */


    public enum Telepathic {

        BeginMark(">"),
        ContinueMark(">|"),
        EndMark("<"),

        BeginUnicode("u003E"),
        ContinueUnicode("u003Eu007C"),
        EndUnicode("u003C"),

        BeginRegex("(>[A-Za-z].*)|(>\\.+[A-Za-z].*)|([A-Za-z].*\\s>[A-Za-z].*)"),
        ContinueRegex("(>\\|[A-Za-z].*)|(>\\|\\.+[A-Za-z].*)|([A-Za-z].*\\s>\\|[A-Za-z].*)|([A-Za-z].*\\s>\\|\\.+[A-Za-z].*)"),
        EndRegex("(>\\.+[A-Za-z].*,< [A-Za-z].*)|(>\\|\\.+[A-Za-z].*,< [A-Za-z].*)|(>\\|[A-Za-z].*,< [A-Za-z].*)|(>[A-Za-z].*,< [A-Za-z].*)|([A-Za-z].*,< [A-Za-z].*)|(>[A-Za-z].*<)|(>\\.+[A-Za-z].*<)|(>\\|\\.+[A-Za-z].*<)|([A-Za-z].*\\s>[A-Za-z].*<)|(>\\|[A-Za-z].*<)|(>\\|\\.+[A-Za-z].*<)|([A-Za-z].*\\s>\\|[A-Za-z].*<)|([A-Za-z].*\\s>\\|\\.+[A-Za-z].*<)|([A-Za-z].*<)"),

        BeginEndRegex("^(>[A-Za-z].*<)$"),
        ContinueEndRegex("^(>\\|[A-Za-z].*<)$"),
        BeginString("^(>[A-Za-z].*)|^(>\\.+[A-Za-z].*)|^(>\\|[A-Za-z].*)|^(>\\|\\.+[A-Za-z].*)");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        Telepathic(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

    public enum Internal {

        BeginMark("<"),
        ContinueMark("<|"),
        EndMark(">"),

        BeginUnicode("u003C"),
        ContinueUnicode("u003Cu007C"),
        EndUnicode("u003E"),

        BeginRegex("(<[A-Za-z].*)|(<\\.+[A-Za-z].*)|([A-Za-z].*\\s<[A-Za-z].*)"),
        ContinueRegex("(<\\|[A-Za-z].*)|(<\\|\\.+[A-Za-z].*)|([A-Za-z].*\\s<\\|[A-Za-z].*)|([A-Za-z].*\\s<\\|\\.+[A-Za-z].*)"),
        EndRegex("(<\\|\\.*[A-Za-z].*,> [A-Za-z].*)|(<\\.*[A-Za-z].*,> [A-Za-z].*)|(<\\|[A-Za-z].*,> [A-Za-z].*)|(<[A-Za-z].*,> [A-Za-z].*)|([A-Za-z].*,> [A-Za-z].*)|(<[A-Za-z].*>)|(<\\.+[A-Za-z].*>)|([A-Za-z].*\\s<[A-Za-z].*>)|(<\\|[A-Za-z].*>)|(<\\|\\.+[A-Za-z].*>)|([A-Za-z].*\\s<\\|[A-Za-z].*>)|([A-Za-z].*\\s<\\|\\.+[A-Za-z].*>)|([A-Za-z].*>)"),

        BeginEndRegex("^(<[A-Za-z].*>)$"),
        ContinueEndRegex("^(<\\|[A-Za-z].*>)$"),
        BeginString("^(<[A-Za-z].*)|^(<\\.+[A-Za-z].*)|^(<\\|[A-Za-z].*)|^(<\\|\\.+[A-Za-z].*)");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        Internal(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }


    public enum Audio {

        BeginMark(",,"),
        ContinueMark("''"),
        EndMark("''"),

        BeginUnicode("u002Cu002C"),
        ContinueUnicode("u0027u0027"),
        EndUnicode("u0027u0027"),

        BeginRegex("(,,[A-Za-z].*)|(,,\\.+[A-Za-z].*)|([A-Za-z].*\\s,,[A-Za-z].*)"),
        ContinueRegex("(''[A-Za-z].*)|(''\\.+[A-Za-z].*)|([A-Za-z].*\\s''[A-Za-z].*)|([A-Za-z].*\\s''\\.+[A-Za-z].*)"),
        EndRegex("(,,[A-Za-z].*'')|(,,\\.+[A-Za-z].*'')|([A-Za-z].*\\s,,[A-Za-z].*'')|(''[A-Za-z].*'')|(''\\.+[A-Za-z].*'')|([A-Za-z].*\\s''[A-Za-z].*'')|([A-Za-z].*,'' [A-Za-z].*)|([A-Za-z].*'')"),

        BeginEndRegex("^(,,[A-Za-z].*'')$"),
        ContinueEndRegex("^(''[A-Za-z].*'')$"),
        BeginString("^(,,[A-Za-z].*)|^(,,\\.+[A-Za-z].*)|^(''[A-Za-z].*)|^(''\\.+[A-Za-z].*)");


        String mark;

        ArrayList<String> array = new ArrayList<>();

        Audio (String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

    public enum AudioInternal {

        BeginAudio(",,<"),
        ContinueAudio("''<|"),
        EndAudio(">''"),
        BeginAudioInternal("<,,"),
        ContinueInternal("<|''"),
        EndMarkInternal("''>");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        AudioInternal (String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

    public enum AudioTelepathic {

        BeginAudio(",,>"),
        ContinueAudio("''>|"),
        EndAudio("<''"),
        BeginAudioTelepathic(">,,"),
        ContinueTelepathic(">|''"),
        EndMarkTelepathic("''<");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        AudioTelepathic (String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }


    public enum StandardEnglishDialog {

        BeginMark(",,"),
        ContinueMark("''"),
        EndMark("''"),

        BeginUnicode("u002Cu002C"),
        ContinueUnicode("u0027u0027"),
        EndUnicode("u0027u0027");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        StandardEnglishDialog (String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }


    }
    public enum Nlp {

        Token("''"),
        Marks("(\"|\'\'|,,|<|>|\\|)");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        Nlp(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

}
