package com.wordsum.process.read.builders.sentence;

import com.wordsum.process.read.models.text.Fragment;
import com.wordsum.process.read.models.text.ParagraphState;
import com.wordsum.process.read.models.text.SentenceState;
import com.wordsum.process.read.models.text.TextModelEnum;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class SentenceUtil {

    public final static Predicate<Fragment> MATCH_DIALOG = n -> n.getType().equals(Fragment.Type.DIALOG);
    public final static String REGEX_PARAGRAPH  = TextModelEnum.NARRATOR_ENDING_MARK.get() + "|" +
            TextModelEnum.DIALOG_ENDING_MARK.get();
    public final static String REGEX_FRAGMENT = TextModelEnum.NARRATOR_CONTINUING_MARK_TO_DIALOG.get()  + "|" +
            TextModelEnum.DIALOG_CONTINUING_MARK_TO_NARRATOR.get();
    public final static String LABEL_SPACER = "_";

    private SentenceUtil(){}

    public static List<String> parseParagraphToSentences(@NotNull String regex, @NotNull String paragraph){

        return Pattern.compile("(?<=" + regex + ")").splitAsStream(paragraph).collect(Collectors.toList());
    }

    public static List<Fragment> parseSentence(@NotNull String regex, @NotNull String sentence){

        List<Fragment> fragments = new LinkedList<>();

        int order = 0;

        for(String text: Pattern.compile("(?="+ regex + ")").splitAsStream(sentence).collect(Collectors.toList())){
            ++order;
            Fragment fragment = new Fragment();
            fragment.setOrder(order);
            fragment.setType(Fragment.Type.NONE);
            fragment.setText(text);
            fragments.add(fragment);
        }

        return fragments;
    }

    public static List<List<Fragment>> tagSentences(List<String> paragraph){

        List<List<Fragment>> allFragments = new ArrayList<List<Fragment>>();
        Fragment.Type defaultEnum = Fragment.Type.NONE;

        for(String sentence: paragraph){
            List<Fragment> fragments = SentenceUtil.parseSentence(SentenceUtil.REGEX_FRAGMENT, sentence);
            Map<Fragment.Type,List<Fragment>> fragmentMap = SentenceUtil.tagSentence(defaultEnum, fragments);
            defaultEnum = fragmentMap.keySet().iterator().next();
            allFragments.add(fragments);
        }

        return allFragments;
    }

    public static void tagParagraph(@NotNull ParagraphState paragraphState){

        Fragment.Type defaultEnum = Fragment.Type.NARRATIVE;

        for(SentenceState sentenceState: paragraphState.getSentenceStates()){
            Map<Fragment.Type,List<Fragment>> fragmentMap = SentenceUtil.tagSentence(defaultEnum, sentenceState.getFragments());
            defaultEnum = fragmentMap.keySet().iterator().next();
        }

    }

    public static Map<Fragment.Type,List<Fragment>> tagSentence(@NotNull Fragment.Type fragment, @NotNull List<Fragment> sentences){

        Fragment.Type defaultType = fragment;

        for(Fragment sentence: sentences) {

            Fragment.Type type = Fragment.Type.NONE;

            //check arrav position one for beginning dialog.
            if (sentence.getText().matches("(" + TextModelEnum.NARRATOR_CONTINUING_MARK_TO_DIALOG.get() + "|" + TextModelEnum.DIALOG_MARK_BEGIN.get() + ")" + TextModelEnum.NARRATIVE_SENTENCE.get())){
                type = Fragment.Type.DIALOG;
                defaultType = Fragment.Type.DIALOG;
            }

            //check array position one for end dialog.
            if (sentence.getText().matches(TextModelEnum.NARRATIVE_SENTENCE.get() + "(" + TextModelEnum.DIALOG_MARK_END.get() + "|" + TextModelEnum.DIALOG_ENDING_MARK.get() + ")")){
                type = Fragment.Type.DIALOG;
                defaultType = Fragment.Type.NARRATIVE;
            }

            //check array position one for begin and end dialog.
            if (sentence.getText().matches("(" + TextModelEnum.NARRATOR_CONTINUING_MARK_TO_DIALOG.get() + "|" + TextModelEnum.DIALOG_MARK_BEGIN.get() + ")" + TextModelEnum.NARRATIVE_SENTENCE.get() + "(" + TextModelEnum.DIALOG_MARK_END.get() + "|" + TextModelEnum.DIALOG_ENDING_MARK.get() + ")")){
                type = Fragment.Type.DIALOG;
                defaultType = Fragment.Type.NARRATIVE;
            }

            //check if just a sentence.
            if (sentence.getText().matches("(" + TextModelEnum.DIALOG_CONTINUING_MARK_TO_NARRATOR.get()  + ")" + TextModelEnum.NARRATIVE_SENTENCE.get())){
                type = Fragment.Type.NARRATIVE;
                defaultType = Fragment.Type.NARRATIVE;
            }

            //check if just a sentence as some dialog in regex
            if (sentence.getText().matches(TextModelEnum.NARRATIVE_SENTENCE.get())){
                type = defaultType;
            }

            sentence.setType(type);
        }

        Map<Fragment.Type, List<Fragment>> map = new LinkedHashMap<Fragment.Type, List<Fragment>>();
        map.put(defaultType, sentences);

        return map;
    }

    public static Long getWordCount(@NotNull String sentence) {

        return Arrays.stream(sentence.split("\\s")).count();
    }

    //TODO Kalab: Remove the perionds, commas and quotes.
    public static Double getAverageWordLength(String sentence) {

        return Arrays.stream(sentence.split("\\s")).mapToInt(String::length).average().getAsDouble();
    }

}
