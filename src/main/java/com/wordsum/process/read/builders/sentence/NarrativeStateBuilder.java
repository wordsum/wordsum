package com.wordsum.process.read.builders.sentence;

import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.models.sentence.NarrativeState;
import com.wordsum.process.read.models.text.Fragment;
import com.wordsum.process.read.models.text.TextModelEnum;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

public class NarrativeStateBuilder {

    protected NarrativeStateBuilder(){}

    public static void addNLP(@NotNull NarrativeState narrativeState, StanfordCoreNLP stanfordCoreNLP) throws IOException {

        String nlpSentence = buildFragmentString(narrativeState.getFragments());

        narrativeState.setNlpState(NlpStateBuilder.getNLP(nlpSentence, stanfordCoreNLP));
    }

    public static String buildFragmentString(List<Fragment> fragments){

        String nlpSentence = "";

        for(Fragment fragment: fragments) {

            if(fragments.stream().anyMatch(e -> e.getType().equals(Fragment.Type.DIALOG)) &&
                    fragments.stream().anyMatch(e -> e.getType().equals(Fragment.Type.NARRATIVE))){

                if(fragment.getType().equals(Fragment.Type.DIALOG)) {
                    nlpSentence = nlpSentence.concat(Fragment.DIALOG_SPACE + Fragment.Type.DIALOG.name() + Fragment.DIALOG_OBJECT + Fragment.DIALOG_SPACE);

                } else {
                    nlpSentence = nlpSentence.concat(replaceDialogMarkInNarrative(fragment.getText()));
                }

            }  else {
                nlpSentence = nlpSentence.concat(replaceDialogMarkInAllDialog(fragment.getText()));
            }

        }

        return nlpSentence;
    }

    public static String replaceDialogMarkInAllDialog(String sentence){

        sentence = sentence.replaceAll(TextModelEnum.NARRATOR_CONTINUING_MARK_TO_DIALOG.get(), " ");
        sentence = sentence.replaceAll(TextModelEnum.DIALOG_MARK_BEGIN.get(), "");
        sentence = sentence.replaceAll(TextModelEnum.DIALOG_MARK_END.get(), ".");

        return sentence;
    }

    public static String replaceDialogMarkInNarrative(String sentence){

        sentence = sentence.replaceAll("(" + TextModelEnum.DIALOG_CONTINUING_MARK_TO_NARRATOR.get() + ")", "");

        return sentence;
    }
}
