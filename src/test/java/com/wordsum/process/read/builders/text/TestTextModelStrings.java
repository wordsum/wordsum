package com.wordsum.process.read.builders.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTextModelStrings {

    public static final String PARAGRAPH_NO_DIALOG = "The valley filled with smoke smoldering from pine trees.  " +
                                     " She teleported from the mountain!" +
                                     " The wordless shout echoes from Sue." +
                                     " Does she smell like smoke?" +
                                     " Only her nose knows.";

    public static final String PARAGRAPH_REPEAT_PATTERN = "I wake. I stand. I code. I lay. I sleep.";

    public static final String PARAGRAPH_BEGIN_AUDIO_DIALOG = ",,What.'' I said, ,,The time has come to stop!'' Then I ran for the lake. The killer bees were chasing as I was shouting, ''RUN, SUE!''" +
                                         " Sue heard. Sue looked back. ,,What?'' She breathed and thought, <Run. Run fast.>" +
                                         " I thought to her, >I will miss you.< And I dived into the river. >|I will never forget.< I stand tall. <|I want that.> Dog stands. <I have not fun.>";


    public static final String PARAGRAPH_NARRATOR_DIALOG_MIX = "I ran and shouted from mind, <STOP! PLEASE! STOP A SECOND.> " +
                                        "The turned and pulled my hand from pocket, which she saw. Then she laughed. ,,You're funny. You're out of breath. And behind.'' I laughed. " +
                                        "We ran a bit more then stopped. We smiled and breathed. ''That was fun,'' she said. ''We need to do that again. Maybe tomorrow.";



    public static final List<String> PARAGRAPH_LIST_BEGIN_AUDIO_DIALOG = new ArrayList<String>(Arrays.asList(",,","What",".'' ","I said",","," ,,","The time has come to stop","!'' ","Then I ran for the lake",". ","The killer bees were chasing as I was shouting",","," ''","RUN, SUE","!'' ","Sue heard",". ","Sue looked back","."," ",",,","What","?'' ","She breathed and thought",","," <","Run",". ","Run fast",".> ","I thought to her",","," >","I will miss you",".< ","And I dived into the river","."," ",">","|","I will never forget",".< ","I stand tall","."," ","<","|","I want that",".> ","Dog stands","."," ","<","I have not fun",".>"));


    public static final String PARAGRAPHS_CONTINUE_DIALOG = "She sat before the computer and thought, <I have wrote this before,>" +
            " while saying to John, ,,I can help you,'' then stood and throught, <I need a more challenging job.";


    public static final List<String> PARAGRAPH_DIALOG_BEGIN_PATTERNS = new ArrayList<>(Arrays.asList(
            "''Where are we going?''",
            "\"I began this string.\"",
            ",,What are we thinking?''",
            ">I don't know.<",
            "<I don't know.>",
            ">|I don't know.<",
            "<|I don't know.>"));

    public static final List<String> PARAGRAPH_PATTERNS = new ArrayList<>(Arrays.asList(
            "I don't know?",
            "I don't know!",
            "I don't know."));

    public static final List<String> MARK_DIALOG_BEGIN_STRING = new ArrayList<>(Arrays.asList(
            "I don't know? ,,The some dialog.''",
            "I don't know? ''The some dialog.''",
            "I don't know? >|The some dialog.<",
            "I don't know? <|The some dialog.>",
            "I don't know? <The some dialog.>",
            "I don't know? >The some dialog.<",
            "I don't know. ,,The some dialog.''",
            "I don't know. ''The some dialog.''",
            "I don't know. >|The some dialog.<",
            "I don't know. <|The some dialog.>",
            "I don't know. <The some dialog.>",
            "I don't know. >The some dialog.<"));


    public static final List<String> NARRATOR_BEGIN_NARRATOR_PATTERNS_STRING = new ArrayList<>(Arrays.asList(
            "I say, \"I don't know?\"",
            "I say, ''The same dialog.''",
            "I speak, >|The some dialog.<",
            "I thought, <|The some dialog.>",
            "I thought, <The some dialog.>",
            "I speak, >The some dialog.<",
            "I say, ,,The some dialog.''"));

   public static final List<String> DIALOG_BEGIN_NARRATOR_PATTERNS_STRING = new ArrayList<>(Arrays.asList(
            "\"I don't know,\" I say.",
            "''The same dialog,'' I say.",
            ">|The some dialog,< I speak.",
            "<|The some dialog,> I thought.",
            "<The some dialog,> I thought."));


}
