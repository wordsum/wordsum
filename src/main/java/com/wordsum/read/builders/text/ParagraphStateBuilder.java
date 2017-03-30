package com.wordsum.read.builders.text;

import com.wordsum.read.builders.communication.DialogStateBuilder;
import com.wordsum.read.models.communication.DialogState;
import com.wordsum.read.models.text.ParagraphState;
import com.wordsum.read.models.text.SentenceState;
import com.wordsum.read.models.text.TextModelEnum;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
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


/**
 * A static function class that builds an paragraph object from a string.
 *
 * @author Kalab J. Oster
 */
public class ParagraphStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(ParagraphStateBuilder.class);
    private static boolean dialogged = false;

    protected ParagraphStateBuilder() {
    }


    /**
     * The method to call with all the methods to parse.
     *
     * @param paragraph         The string of text to be parsed as it is a whole in this state.
     * @param paragraphOrder    The order of the paragraph if there are other paragraphs.
     * @param stanfordCoreNLP   The core parser for NLP.
     * @param lexicalizedParser The lexical parser used for NLP.
     * @return ParagraphState   The new paragraph state.
     * @throws Exception Throw everything right now.
     */
    public static ParagraphState toParagraphState(String paragraph, Integer paragraphOrder, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws Exception {

        ParagraphState paragraphState = new ParagraphState();

        // Set known values.
        paragraphState.setParagraph(paragraph);
        paragraphState.setOrder(paragraphOrder);

        // Parse paragraph and sentences.
        parseParagraph(paragraphState);
        parseSentences(paragraphState, stanfordCoreNLP, lexicalizedParser);

        // Define other states.
        defineParagraphDialogStates(paragraphState);
        defineParagraphWordCount(paragraphState);

        return paragraphState;
    }

    /**
     * This method is to parse sentences and tokenize dialog of a paragraph.
     * <p/>
     * The method creates sentence states for sentences with dialog and without dialog.
     * Sentences with dialog will require special parsing as the continuous nature of it
     * of a character that may or may not be continuous.
     *
     * @param paragraphState The model to build with this tool.
     * @return ParagraphState   The new paragraph state.
     * @throws Exception Throw everything right now.
     */
    public static ParagraphState parseParagraph(ParagraphState paragraphState) throws Exception {

        //Define the list of sentences objects to fill with words.
        paragraphState.setSentenceStates(new ArrayList<SentenceState>());
        paragraphState.setSentenceCount(0);

        //Boolean to allow dialog mark follows
        dialogged = false;

        // Parse paragraph by known sentence endings.
        // This will help by to split, tokenize and order the sentence that have dialog.
        // By parsing known endings we can a narrative with dialog intact for further parsing while
        // Allowing non dialog sentence to be passed and counted.
        for (String sentence : paragraphState.getParagraph().split(TextModelEnum.SentenceEnd.END.get())) {

            paragraphState = defineSentence(paragraphState, sentence);

        }

        return paragraphState;
    }


    /**
     * A method parse and tokenize dialog in a sentence making it a paragraph like object.
     *
     * @param paragraphState The paragraph object that that will contain the sentence being defined.
     * @param sentence       The sentence to be used for the sentence state once we determine the type of sentence.
     * @return ParagraphState with the new sentence state.
     * @throws IOException
     */
    public static ParagraphState defineSentence(ParagraphState paragraphState, String sentence) throws Exception {

        //Initialize if null
        if (paragraphState.getSentenceStates() == null) {
            paragraphState.setSentenceStates(new ArrayList<SentenceState>());
            paragraphState.setSentenceCount(0);
        }

        //TODO: Make this a static method and functions.
        DialogStateBuilder dialogStateBuilder = new DialogStateBuilder();

        //If dialog in sentence  and only dialog then we only need one.sentence.
        if (sentence.matches(TextModelEnum.Dialog.Only.get())) {

            paragraphState = createDialogSentenceState(paragraphState, sentence, null);

            // If dialog and narrative in sentence then parse and tokenize.
        } else if (dialogStateBuilder.isDialogInString(sentence)) {

            paragraphState = parseTokenizeDialogSentence(paragraphState, sentence);

            // Else just a sentence and read on.
        } else {

            paragraphState = createNarratorSentenceState(paragraphState, sentence);

        }

        return paragraphState;
    }

    /**
     * A method to parse strings with dialog. It attempts to create a better pattern that represents it.
     *
     * @param paragraphState The paragraph state that will contain the sentence state of the sentence string.
     * @param sentence       A string of the sentence parsed and thought to be dialog needing to be tokenized.
     * @return ParagraphState is returned.
     * @throws Exception
     */
    public static ParagraphState parseTokenizeDialogSentence(ParagraphState paragraphState, String sentence) throws Exception {


        //Initialize if null
        if (paragraphState.getSentenceStates() == null) {
            paragraphState.setSentenceStates(new ArrayList<SentenceState>());
            paragraphState.setSentenceCount(0);
        }

        // This is not static, so we need to initialize to use methods
        DialogStateBuilder dialogStateBuilder = new DialogStateBuilder();

        // The creation of the dialog flag and strings that will be used to help token dialog.
        dialogged = false;
        String narrator = "";
        String dialogMarkCache = "";
        List<String> dialog = new ArrayList<>();

        // Parse sentence with dialog with these patterns and loop to begin to token and defined.
        for (String fragment : sentence.split(TextModelEnum.SentenceEnd.DialogContinueNarrator.get()
                        + TextModelEnum.SentenceEnd.RexExMerge.get()
                        + TextModelEnum.SentenceEnd.NarratorContinueDialog.get()
        )) {


            //Check for continue dialog
            if((fragment.contains(TextModelEnum.DialogEnd.EndAudioComma.get()) ||
                    fragment.contains(TextModelEnum.DialogEnd.EndInternalComma.get()) ||
                    fragment.contains(TextModelEnum.DialogEnd.EndTelepathicComma.get()) ||
                    fragment.contains(TextModelEnum.DialogEnd.EndAudioEllipsis.get()) ||
                    fragment.contains(TextModelEnum.DialogEnd.EndTelepathicEllipsis.get()) ||
                    fragment.contains(TextModelEnum.DialogEnd.EndInternalEllipsis.get()) &&
                            fragment.matches("^[a-zA-Z0-9]*"))  &&
                    dialogMarkCache.isEmpty()){

                //Add to the dialog list to later make own sentences.
                dialog.add(fragment);
                //Add Token
                narrator = narrator.concat(" " + TextModelEnum.Token.DialogObject.get() + "_" + dialog.size());

                dialogged = true;

            //Check for beginning dialog as this is a special case.
            } else if (dialogStateBuilder.isDialogBeginString(fragment)) {
                //Add to the dialog list to later make own sentences.
                dialog.add(fragment);
                //Add Token
                narrator = narrator.concat(TextModelEnum.Token.DialogObject.get() + "_" + dialog.size());

                dialogged = true;

                //If the beginning for dialog then sanitized and classify.
            } else if (fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogAudioBegin.getFind()) ||
                    fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogAudioContinue.getFind()) ||
                    fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogInternalBegin.getFind()) ||
                    fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogInternalContinue.getFind()) ||
                    fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogExternalBegin.getFind()) ||
                    fragment.contains(TextModelEnum.SanitizeDialogMarkPatterns.CommaDialogExternalContinue.getFind())) {

                // There is probably a better way to do this, but for now we loop through and break to sort and find.
                for (TextModelEnum.SanitizeDialogMarkPatterns sanitizeDialogMarkPattern : TextModelEnum.SanitizeDialogMarkPatterns.values()) {

                    if (fragment.contains(sanitizeDialogMarkPattern.getFind())) {
                        fragment = fragment.replace(sanitizeDialogMarkPattern.getFind(), sanitizeDialogMarkPattern.getReplace());
                        String space = "";
                        if (dialogged) {
                            space = ", ";
                            dialogged = false;
                        }

                        narrator = narrator.concat(space + fragment);
                        dialogMarkCache = sanitizeDialogMarkPattern.getConcat();
                        break;
                    }

                }

                // If dialog mark cache then we can assume that we need to prepend dialog mark to fragment.
            } else if (!dialogMarkCache.isEmpty()) {
                dialog.add(dialogMarkCache + fragment);
                //Clear cache
                dialogMarkCache = "";
                narrator = narrator.concat(" " + TextModelEnum.Token.DialogObject.get() + "_" + dialog.size());
                dialogged = true;

                // Else just assume it's the end dialog.
            } else {

                String space = "";
                if (dialogged) {
                    space = ", ";
                    dialogged = false;
                }

                narrator = narrator.concat(space + fragment);

            }

        }

        paragraphState = loadNarrativeParseDialogIntoSentenceStateArray(paragraphState, dialog, narrator);

        return paragraphState;
    }


    /**
     * This method takes narrator with dialog and creates sentence states for it.
     * <p/>
     * It sues the paragraphs sentence position token to link them by giving all the dialog parts the same token of sentence.
     *
     * @param paragraphState The state we are creating and changing with the narrator and dialogs.
     * @param dialogs        A list of all the dialogs parsed from the sentence and given tokens.
     * @param narrator       The tokenized string from the narrator without dialog.
     * @return ParagraphState   The new paragraph state.
     * @throws Exception Throw everything right now.
     */
    public static ParagraphState loadNarrativeParseDialogIntoSentenceStateArray(ParagraphState paragraphState, List<String> dialogs, String narrator) throws Exception {

        //Initialize if null
        if (paragraphState.getSentenceStates() == null) {
            paragraphState.setSentenceStates(new ArrayList<SentenceState>());
            paragraphState.setSentenceCount(0);
        }

        // Create sentence state with dialog tokens.
        paragraphState = createNarratorSentenceState(paragraphState, narrator);

        // Loop through list and create sentencestates with dialog
        for (String dialog : dialogs) {
            paragraphState = createDialogSentenceState(paragraphState, dialog, paragraphState.getSentenceCount());
        }

        return paragraphState;
    }


    /**
     * This method will create a SentenceState for the sentence that is not dialog.
     *
     * @param paragraphState The state we are adding the sentence.
     * @param sentence       The string that has been determined as this type of sentencee to be added to paragraph state.
     * @return ParagraphState   The new paragraph state.
     */
    public static ParagraphState createNarratorSentenceState(ParagraphState paragraphState, String sentence) {

        //Initialize if null
        if (paragraphState.getSentenceStates() == null) {
            paragraphState.setSentenceStates(new ArrayList<SentenceState>());
            paragraphState.setSentenceCount(0);
        }

        //Increment count.
        paragraphState.setSentenceCount(paragraphState.getSentenceCount() + 1);

        //Create the sentence state.
        SentenceState sentenceState = new SentenceState();

        // A null dialog state because there is no dialog.
        sentenceState.setDialogState(null);

        //We want to order the order plus one for we don't want to start at 0.
        sentenceState.setOrderParagraph(paragraphState.getSentenceCount());

        //Add the sentence to the sentence state.
        sentenceState.setSentence(sentence.trim());

        // Add to the list of the setence array and return.
        paragraphState.getSentenceStates().add(sentenceState);


        return paragraphState;
    }

    /**
     * @param paragraphState The state we are adding the sentence.
     * @param sentence       The string that has been determined as this type of sentencee to be added to paragraph state.
     * @param narratorToken  The token indicating this is part of a narrative sentence, and the value of the narrator sentence
     *                       linking the two.
     * @return ParagraphState   The new paragraph state.
     */
    public static ParagraphState createDialogSentenceState(ParagraphState paragraphState, String sentence, Integer narratorToken) throws Exception {


        //Initialize if null
        if (paragraphState.getSentenceStates() == null) {
            paragraphState.setSentenceStates(new ArrayList<SentenceState>());
            paragraphState.setSentenceCount(0);
        }

        //Until this is some state builder class, I need to create this object.
        DialogStateBuilder dialogStateBuilder = new DialogStateBuilder();

        // If the token is null then assume that the dialog is not part of another sentence.
        if (narratorToken == null) {
            narratorToken = paragraphState.getSentenceCount() + 1;
        }

        // CREATE DIALOGSTATE

        // We are creating a dialog object, so we also need to create it to put into the dialogstate.
        DialogState dialogState = new DialogState();

        dialogState.setSentence(sentence.trim());

        //Because this dialog is seen as complete it is it's own token.
        dialogState.setOriginOfDialogFromOrderParagraph(narratorToken);

        //This builds the syntax and defines it in the DataState object.
        dialogState = dialogStateBuilder.defineDialogStateSyntax(dialogState);

        //This will be the check that defines dialog mark type.
        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        // CREATE SENTENCESTATE

        // Create the sentencestate object we are going to define.
        SentenceState sentenceState = new SentenceState();

        //Define the dialog state.
        sentenceState.setDialogState(dialogState);

        //Add the sentence to the dialog state, so we can add the last information to collect the data.
        sentenceState.setSentence(sentence.trim());

        //Write the order of the sentence.
        sentenceState.setOrderParagraph(narratorToken);

        //Update Counter
        paragraphState.setSentenceCount(narratorToken);

        //Add sentence to list and return.
        paragraphState.getSentenceStates().add(sentenceState);

        return paragraphState;
    }


    /**
     * This method takes all the sentence states created and parses them with nlp.
     *
     * @param paragraphState    The ParagraphState will all the SentenceState to be parsed with nlp.
     * @param stanfordCoreNLP   The NLP engine.
     * @param lexicalizedParser The lexical parser to be used.
     * @return ParagraphState   The new paragraph state.
     * @throws Exception Throw everything right now.
     */
    public static ParagraphState parseSentences(ParagraphState paragraphState, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws Exception {

        for (SentenceState sentenceState : paragraphState.getSentenceStates()) {

            SentenceStateBuilder.toSentenceState(sentenceState, stanfordCoreNLP, lexicalizedParser);

        }

        return paragraphState;
    }


    /**
     * This will define dialogstates of sentences in a paragraph or many sentenced dialog that hasn't been identified
     * because it didn't have dialog in the sentence.
     *
     * @param paragraphState The paragraph object with sentence and dialog defined enough to define the other sentences.
     * @return ParagraphState   The new paragraph state.
     * @throws Exception Throw everything right now.
     */
    public static ParagraphState defineParagraphDialogStates(ParagraphState paragraphState) throws Exception {

        boolean is = false;
        boolean dialog = false;

        List<SentenceState> sentenceStates = paragraphState.getSentenceStates();

        for (int i = 0; i < sentenceStates.size(); i++) {

            SentenceState sentenceState = sentenceStates.get(i);
            DialogState dialogState = sentenceState.getDialogState();

            if (dialogState.isDialogBegin()) {
                dialog = true;
                is = true;
            }

            if (dialogState.isDialogContinue()) {
                dialog = true;
                is = true;
            }

            dialogState.setIsDialog(dialog);
            sentenceState.setDialogState(dialogState);
            sentenceStates.set(i, sentenceState);

            if (dialogState.isDialogEnd()) {
                dialog = false;
            }

        }

        paragraphState.setDialog(is);
        paragraphState.setSentenceStates(sentenceStates);

        return paragraphState;
    }

    /**
     * The method to define the pargraph count.
     * <p/>
     * This methe may be refactored for there may be a better way.
     *
     * @param paragraphState The paragraph state with the word count to collect.
     * @return ParagraphState The object with paragraph states defined with word count.
     */
    public static ParagraphState defineParagraphWordCount(ParagraphState paragraphState) {

        int paragraphWordCount = 0;

        if (paragraphState.getSentenceStates() == null || paragraphState.getSentenceStates().isEmpty()) {

            logger.debug("paragraphState.getSentenceStates() is null or Empty", paragraphState);

        } else {

            for (SentenceState sentenceState : paragraphState.getSentenceStates()) {

                paragraphWordCount += sentenceState.getWordCount();

            }
        }

        paragraphState.setWordCount(paragraphWordCount);

        return paragraphState;
    }

}
