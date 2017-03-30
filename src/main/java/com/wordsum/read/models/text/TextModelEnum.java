package com.wordsum.read.models.text;

import java.util.ArrayList;

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
 * And enum for a place to begin to define enums used by the builders to text.
 * <p/>
 * This will likely change but for now I don't want to think about the right place
 * for these.
 *
 * @author Kalab J. Oster
 */
public class TextModelEnum {


    public enum ParagraphEnd {

        All("\\n\\n");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        ParagraphEnd(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray() {
            return this.array;
        }

    }


    public enum SentenceEnd {
        // The enum to hold the regex for dialog beginning.
        RexExMerge("|"),
        DialogBeginSentence("^(''|>|<)"),
        NarratorContinueDialog("(?<=\\, <)|(?<=\\, >)|(?<=\\, ,,)|(?<=\\, '')"),
        DialogContinueNarrator("(?<=\\,'' )|(?<=\\,> )|(?<=\\,< )"),
        NarratorEndDialogBegin("(?<=\\. <)|(?<=\\. >)|(?<=\\. ,,)|(?<=\\. '')|(?<=\\! <)|(?<=\\! >)|(?<=\\! ,,)|(?<=\\! '')|(?<=\\? <)|(?<=\\? >)|(?<=\\? ,,)|(?<=\\? '')"),
        DialogEnd("(\\n)|(?<=\\.''\\ )|(?<=\\?''\\ )|(?<=\\!''\\ )|(?<=\\.>\\ )|(?<=\\?>\\ )|(?<=\\!>\\ )|(?<=\\.<\\ )|(?<=\\?<\\ )|(?<=\\!<\\ )"),
        NarratorEnd("(?<=! )|(?<=\\. )|(?<=\\? )"),
        //END("(?<=! )|(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?)\\s|(\\n)|(?<=\\.''\\ )|(?<=\\?''\\ )|(?<=\\!''\\ )|(?<=\\.>\\ )|(?<=\\?>\\ )|(?<=\\!>\\ )|(?<=\\.<\\ )|(?<=\\?<\\ )|(?<=\\!<\\ )"),
        END("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=([.|?|!])(''|<|>|\\s))"),


        //Edit to move to enums that make sense.There is no logic in what is written here for code. It's bad. Move it.
        Pattern("\"(\\n)|(?<=\\.\\ )|(?<=\\!\\ )|(?<=\\?\\ )|(?<=\\.''\\ )|(?<=\\?''\\ )|(?<=\\,''\\ )|(?<=\\!''\\ )|(?<=\\.>\\ )|(?<=\\?>\\ )|(?<=\\,>\\ )|(?<=\\!>\\ )|(?<=\\.<\\ )|(?<=\\?<\\ )|(?<=\\,<\\ )|(?<=\\!<\\ )|\""),
        CommaDialogBeginPattern("(?<=\\, <)|(?<=\\, >)|(?<=\\, ,,)|(?<=\\, '')");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        SentenceEnd(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray() {
            return this.array;
        }

    }


    public enum SanitizeDialogMarkPatterns {

        CommaDialogAudioBegin(", ,,", ",", ",,"),
        CommaDialogAudioContinue(", ''", ",", "''"),
        CommaDialogInternalBegin(", <", ",", "<"),
        CommaDialogInternalContinue(", <|", ",", "<|"),
        CommaDialogExternalBegin(", >", ",", ">"),
        CommaDialogExternalContinue(", >|", ",", ">|"),

        //For some my parsing needs to be better, so it will be better this way.
        PeriodDialogAudioBegin(". ,,", ".", ",,"),
        PeriodDialogAudioContinue(". ''", ".", "''"),
        PeriodDialogInternalBegin(". <", ".", "<"),
        PeriodDialogInternalContinue(". <|", ".", "<|"),
        PeriodDialogExternalBegin(". >", ".", ">"),
        PeriodDialogExternalContinue(". >|", ".", ">|"),

        QuestionDialogAudioBegin("? ,,", "?", ",,"),
        QuestionDialogAudioContinue("? ''", "?", "''"),
        QuestionDialogInternalBegin("? <", "?", "<"),
        QuestionDialogInternalContinue("? <|", "?", "<|"),
        QuestionDialogExternalBegin("? >", "?", ">"),
        QuestionDialogExternalContinue("? >|", "?", ">|"),


        ExclamationDialogAudioBegin("! ,,", "!", ",,"),
        ExclamationDialogAudioContinue("! ''", "!", "''"),
        ExclamationDialogInternalBegin("! <", "!", "<"),
        ExclamationDialogInternalContinue("! <|", "!", "<|"),
        ExclamationDialogExternalBegin("! >", "!", ">"),
        ExclamationDialogExternalContinue("! >|", "!", ">|");

        String find;
        String replace;
        String concat;


        SanitizeDialogMarkPatterns(String find, String replace, String concat) {
            this.find = find;
            this.replace = replace;
            this.concat = concat;

        }

        public String getFind() {
            return find;
        }

        public String getReplace() {
            return replace;
        }

        public String getConcat() {
            return concat;
        }

    }


    public enum DialogEnd {

        EndAudioPeriod(".''"),
        EndInternalPeriod(".<"),
        EndTelepathicPeriod(".>"),
        EndAudioComma(",''"),
        EndInternalComma(",<"),
        EndTelepathicComma(",>"),
        EndAudioEllipsis("...''"),
        EndInternalEllipsis("...<"),
        EndTelepathicEllipsis("...>"),
        EndAudioExclamation("!''"),
        EndInternalExclamation("!<"),
        EndTelepathicExclamation("!>"),
        EndAudioQuestion("?''"),
        EndInternalQuestion("?<"),
        EndTelepathicQuestion("?>");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        DialogEnd(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray() {
            return this.array;
        }


    }


    public enum Dialog {

        /**
         * The point is to find these pattern to accept as dialog (assume it is).
         * <p/>
         * ''This diglog and good.''
         * ,,This diglog and good.''
         * ''I said only this.
         * >|This diglog and good.<
         * <|I said only this.
         * <|I said only this.
         * >|I said only this.<
         * >|I said only this.
         * >I said only this.
         * <I sttad.>
         * <I stay.
         */
        Only("((>\\||>|''|,,|<\\||<)(([a-zA-Z0-9]\\s*)*)[.|!|?](>|''|<))|((>\\||>|''|,,|<\\||<)(([a-zA-Z0-9]\\s*)*)[.|!|?])(\\s*)"),
        Marks("(\"|\'\'|,,|<|>|\\|)");

        String mark;

        ArrayList<String> array = new ArrayList<>();

        Dialog(String mark) {
            this.mark = mark;
            this.array.add(0, this.mark);

        }

        public String get() {
            return mark;
        }

        public ArrayList<String> getArray() {
            return this.array;
        }
    }


    public enum Token {

        DialogObject("DIALOG_OBJECT");

        String token;

        ArrayList<String> array = new ArrayList<>();

        Token(String token) {
            this.token = token;
            this.array.add(0, this.token);

        }

        public String get() {
            return token;
        }

        public ArrayList<String> getArray() {
            return this.array;
        }
    }


    /**
     * An enum that to list and organize all P.O.S. that defines a past tense.
     */
    public enum PennTreeTensePast {

        VBD("Past"),
        VBN("PastParticiple");

        private String label;

        PennTreeTensePast(String label) {
            this.label = label;
        }

        public String get() {
            return label;
        }

    }

    /**
     * An enum that lists and organizes all the P.O.S. that defines a tense.
     */
    public enum PennTreeTensePresent {

        VBP("Present"),
        VBZ("Present"),
        VBG("PresentParticiple");

        private String label;

        PennTreeTensePresent(String label) {
            this.label = label;
        }

        public String get() {
            return label;
        }

    }


}
