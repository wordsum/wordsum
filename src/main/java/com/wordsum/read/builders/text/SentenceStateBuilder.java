package com.wordsum.read.builders.text;

import com.wordsum.read.models.communication.DialogState;
import com.wordsum.read.builders.communication.DialogStateBuilder;
import com.wordsum.read.models.dictionary.JazzyState;
import com.wordsum.read.builders.dictionary.JazzyStateBuilder;
import com.wordsum.read.builders.nlp.NlpStateBuilder;
import com.wordsum.read.models.punctuation.PunctuationState;
import com.wordsum.read.builders.punctuation.PunctuationStateBuilder;
import com.wordsum.read.models.text.SentenceState;
import com.wordsum.read.models.text.TextModelEnum;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
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


/**
 * A class to build a sentence object.
 *
 * @author Kalab J. Oster
 */
public class SentenceStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(SentenceStateBuilder.class);

    protected SentenceStateBuilder() {
    }

    /**
     * Method with signature of no pre existing SentenceState.
     *
     * @param sentence          The string that is assumed a sentence.
     * @param sentenceOrder     The order of the sentence relative to a paragraph or list.
     * @param stanfordCoreNLP   The CoreNLP engine.
     * @param lexicalizedParser The lexical parser engine.
     * @return SentenceState defined.
     * @throws Exception
     */
    public static SentenceState toSentenceState(String sentence, Integer sentenceOrder, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws Exception {
        SentenceState sentenceState = new SentenceState();

        sentenceState.setSentence(sentence.trim());
        sentenceState.setOrderParagraph(sentenceOrder);

        sentenceState = defineDialogState(sentenceState);
        sentenceState = defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        sentenceState = defineJazzyState(sentenceState);
        sentenceState = defineDialogStateNull(sentenceState); //I can't remember this purpose.
        sentenceState = defineWordCount(sentenceState);
        sentenceState = definePunctuationState(sentenceState);
        sentenceState = defineTense(sentenceState);

        return sentenceState;

    }


    /**
     * Method to call all other methods and build the sentence state.
     *
     * @param sentenceState     The SentenceState to create.
     * @param stanfordCoreNLP   The CoreNLP engine.
     * @param lexicalizedParser The lexical parser engine.
     * @return sentenceState with definitions.
     */
    public static SentenceState toSentenceState(SentenceState sentenceState, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws Exception {

        sentenceState = defineDialogState(sentenceState);
        sentenceState = defineStanfordNlpState(sentenceState, stanfordCoreNLP, lexicalizedParser);
        sentenceState = defineJazzyState(sentenceState);
        sentenceState = defineDialogStateNull(sentenceState); //I can't remember this purpose.
        sentenceState = defineWordCount(sentenceState);
        sentenceState = definePunctuationState(sentenceState);
        sentenceState = defineTense(sentenceState);

        return sentenceState;

    }

    /*
    * Method to define dialog state of a sentence given known inputs.
    * If no state already exists from the paragraph state then this
    * will create the dialogstate and pass it to the dialog state creator.
    *
    * @param  sentenceState The SentenceState to define DialogState if not defined.
    * @return SentenceState with defined dialogstate.
    */
    public static SentenceState defineDialogState(SentenceState sentenceState) throws Exception {

        // The paragraph state creator could have created dialog state as some of its state
        // can be defined in the paragraph.
        // This null check
        if (sentenceState.getDialogState() == null) {
            sentenceState.setDialogState(new DialogState());
        }


        //I still have some builder object and not a static class for one reason or another.
        DialogStateBuilder dialogStateBuilder = new DialogStateBuilder();

        //This may  be a bit of a mind fuck, but oh well. It needs be for now because I may not create the dialogstate
        //object in this method.

        //This builds the syntax and defines it in the DataState object.
        sentenceState.setDialogState(dialogStateBuilder.defineDialogStateSyntax(sentenceState.getDialogState()));
        //Add the sentence to the dialog state, so we can add the last information to collect the data.
        sentenceState.getDialogState().setSentence(sentenceState.getSentence());
        //Check and define if dialog state.
        sentenceState.setDialogState(dialogStateBuilder.checkSentenceForDialogMark(sentenceState.getDialogState()));

        return sentenceState;
    }


    /**
     * Defines the NLP with NlpState.
     *
     * @param sentenceState     The SentenceState to have NLP added to it.
     * @param stanfordCoreNLP   The CoreNLP engine.
     * @param lexicalizedParser The lexical parser engine.
     * @return SentenceState The altered state with NLP.
     * @throws InterruptedException
     */
    public static SentenceState defineStanfordNlpState(SentenceState sentenceState, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws InterruptedException {

        String sentence = defineSentenceWithNPLDialogMark(sentenceState);

        sentenceState.setNlpState(NlpStateBuilder.defineStanfordNlpState(sentence, stanfordCoreNLP, lexicalizedParser));

        return sentenceState;
    }

    /**
     * This method uses Jazzy to to a spell check on the sentence.
     *
     * @param sentenceState The SentenceState with the sentence to spell check.
     * @return SentenceState with the spell check JazzyState object.
     * @throws Exception
     */
    public static SentenceState defineJazzyState(SentenceState sentenceState) throws Exception {

        JazzyStateBuilder jazzyStateBuilder = new JazzyStateBuilder();

        JazzyState jazzyState = jazzyStateBuilder.toJazzyState(sentenceState.getSentence());

        sentenceState.setJazzyState(jazzyState);

        return sentenceState;
    }

    /**
     * This is to check patters of the sentence and add the check and object.
     *
     * @param sentenceState The state to check punctuation and create a PunctuationStateObject
     * @return SentenceState with the new PunctuationState object
     */
    public static SentenceState definePunctuationState(SentenceState sentenceState) {

        PunctuationState punctuationState = PunctuationStateBuilder.createPunctuationState(sentenceState.getSentence());

        sentenceState.setPunctuationState(punctuationState);

        return sentenceState;
    }


    /**
     * The method ensures some dialog state created for consistent existence in future processing.
     * <p/>
     * Depending on the preprocessing like being created from ParagraphStateBuilder, this may not
     * be needed.
     * <p/>
     * This assumes this SentenceState is alone.
     *
     * @param sentenceState The state to further define.
     * @return SentenceState with the Dialog state not null.
     */
    public static SentenceState defineDialogStateNull(SentenceState sentenceState) {

        DialogState dialogState = sentenceState.getDialogState();

        if (!dialogState.isDialog()) {
            sentenceState.setDialogState(new DialogState());
        }

        return sentenceState;

    }

    /**
     * If putting dialog mark, any dialog mark, through the NPL processor then to get consistent
     * results without needing to add mark or definition, which I will do eventually, just use their existing token.
     * Plus, my using of two lower case commas may be hard to program for dialog mark.
     *
     * @param sentenceState The state to change.
     * @return String with the tokens.
     */
    public static String defineSentenceWithNPLDialogMark(SentenceState sentenceState) {

        DialogState dialogState = sentenceState.getDialogState();
        String sentence = sentenceState.getSentence();

        sentence = sentence.replace(dialogState.getAudioBeginMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getAudioContinueMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getAudioEndMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getInternalContinueMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getTelepathicContinueMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getInternalBeginMark(), dialogState.getDialogNplToken());
        sentence = sentence.replace(dialogState.getInternalEndMark(), dialogState.getDialogNplToken());

        return sentence;
    }

    /**
     * This method may be done better but this counts the words the way
     * I want it done.
     * <p/>
     * If there is found to be a better way with a a better library then I will
     * use it.
     *
     * @param sentenceState The sentence with the sentence string to count.
     * @return SentenceState with the string wc count.
     */
    public static SentenceState defineWordCount(SentenceState sentenceState) {

        int wc = 0;

        if (sentenceState.getSentence() == null || sentenceState.getSentence().isEmpty()) {

            sentenceState.setWordCount(wc);

        } else {

            for (String word : sentenceState.getSentence().split("\\s+")) {
                if (!word.contains(TextModelEnum.Token.DialogObject.get())) {
                    wc++;
                }
            }

            sentenceState.setWordCount(wc);

        }
        return sentenceState;
    }

    /**
     * A method to use enum and the POS tags with the dependency, constituency and lexical NLP
     * maps to determine what types of verbs are inside and if a past or present sentence.
     *
     * @param sentenceState The SentenceState with the nlp parsed model defined inside.
     * @return SentenceState with tense defined.
     */
    public static SentenceState defineTense(SentenceState sentenceState) {

        List<String> tense = new ArrayList<String>();

        if(sentenceState.getNlpState() == null){
           sentenceState.setTense(tense);
        } else {
            for(HashMap<String, String> wordMap: sentenceState.getNlpState().getCoreAnnotations()){
                for(TextModelEnum.PennTreeTensePast value: TextModelEnum.PennTreeTensePast.values()){
                    if(value.toString().contains(wordMap.get("pos"))){
                        tense.add(value.get());
                    }
                }
                for(TextModelEnum.PennTreeTensePresent value: TextModelEnum.PennTreeTensePresent.values()){
                    if(value.toString().contains(wordMap.get("pos"))){
                        tense.add(value.get());
                    }
                }
            }

            sentenceState.setTense(tense);
        }

        return sentenceState;
    }

}
