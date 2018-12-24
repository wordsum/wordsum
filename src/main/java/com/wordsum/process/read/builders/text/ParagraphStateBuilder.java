package com.wordsum.process.read.builders.text;

import com.wordsum.process.read.builders.sentence.SentenceStateBuilder;
import com.wordsum.process.read.models.text.ParagraphState;
import com.wordsum.process.read.models.text.SentenceState;
import com.wordsum.process.read.models.text.TextModelEnum;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class ParagraphStateBuilder {

    private ParagraphStateBuilder(){}

    public final static void addStringText(@NotNull ParagraphState paragraphState, @NotNull String paragraph) throws IOException {

        List<SentenceState> sentenceStates = new LinkedList<SentenceState>();
        int order = 1;
        for(String sentence: paragraph.split("(?<=" + TextModelEnum.NARRATOR_ENDING_MARK.get() + TextModelEnum.DIALOG_ENDING_MARK.get() + ")")){
            SentenceState sentenceState = new SentenceState();
            SentenceStateBuilder.build(sentenceState, sentence);
            sentenceState.setOrder(order);
            sentenceStates.add(sentenceState);
            order++;
        }

        paragraphState.setSentenceStates(sentenceStates);
    }

    public final static void addNlp(@NotNull ParagraphState paragraphState, StanfordCoreNLP stanfordCoreNLP) throws IOException {

        for(SentenceState sentenceState: paragraphState.getSentenceStates()){
            SentenceStateBuilder.build(sentenceState, stanfordCoreNLP);
        }
    }
}
