package com.wordsum.process.read.builders.sentence;


import com.wordsum.process.read.models.sentence.NarrativeState;
import com.wordsum.process.read.models.text.Fragment;
import com.wordsum.process.read.models.text.SentenceState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2018 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */
public final class SentenceStateBuilder {

    private SentenceStateBuilder(){}

    public static void build(@NotNull SentenceState sentenceState, @NotNull String sentence) throws IOException {
        addStringText(sentenceState, sentence);
        buildNarrativeState(sentenceState);
    }


    public static void build(@NotNull SentenceState sentenceState, StanfordCoreNLP stanfordCoreNLP) throws IOException {
        buildNarrativeState(sentenceState, stanfordCoreNLP);
    }

    public static void addStringText(@NotNull SentenceState sentenceState, @NotNull String sentence){

        List<Fragment> framgments = SentenceUtil.parseSentence(SentenceUtil.REGEX_FRAGMENT, sentence);

        Map<Fragment.Type, List<Fragment>> fragmentCheckReturn = new LinkedHashMap<Fragment.Type, List<Fragment>>();

        if(framgments.stream().anyMatch(t -> t.getType().equals(Fragment.Type.NONE))) {
            fragmentCheckReturn = SentenceUtil.tagSentence(Fragment.Type.NARRATIVE, framgments);
        }

        sentenceState.setFragments(fragmentCheckReturn.get(fragmentCheckReturn.keySet().iterator().next()));
    }


    public static void buildNarrativeState(@NotNull SentenceState sentenceState) {

        List<NarrativeState> narrativeStates = new LinkedList<NarrativeState>();

        if(sentenceState.getFragments().isEmpty()){
            throw new NullPointerException("sentenceState.getFragments() is null");
        }

        if(sentenceState.getFragments().stream().anyMatch(e -> e.getType().equals(Fragment.Type.DIALOG)) &&
                sentenceState.getFragments().stream().anyMatch(e -> e.getType().equals(Fragment.Type.NARRATIVE))){

            NarrativeState narrative = new NarrativeState();
            narrative.setFragments(sentenceState.getFragments());
            narrativeStates.add(narrative);

            NarrativeState dialog = new NarrativeState();
            dialog.setFragments(getDialogList(sentenceState.getFragments()));
            narrativeStates.add(dialog);

        } else {

            NarrativeState narrativeState = new NarrativeState();
            narrativeState.setFragments(sentenceState.getFragments());
            narrativeStates.add(narrativeState);

        }

        sentenceState.setNarrativeStates(narrativeStates);
    }


    public static void buildNarrativeState(@NotNull SentenceState sentenceState, StanfordCoreNLP stanfordCoreNLP) throws IOException {

        if(sentenceState.getFragments().isEmpty()){
            throw new NullPointerException("sentenceState.getFragments() is null");
        }

        for(NarrativeState narrativeState: sentenceState.getNarrativeStates()) {

            NarrativeStateBuilder.addNLP(narrativeState, stanfordCoreNLP);
        }

    }

    public static List<Fragment> getDialogList(List<Fragment> fragments){

        return fragments.stream()
                .filter(d -> d.getType().equals(Fragment.Type.DIALOG))
                .collect(Collectors.toList());
    }

}