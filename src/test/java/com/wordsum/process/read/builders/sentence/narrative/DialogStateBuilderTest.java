package com.wordsum.process.read.builders.sentence.narrative;

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

public class DialogStateBuilderTest {
/*
    private static String BEGIN_AUDIO = "(,,[A-Za-z].*)|(,,\\.+[A-Za-z].*)|([A-Za-z].*\\s,,[A-Za-z].*)";
    private static String CONTINUE_AUDIO = "(''[A-Za-z].*)|(''\\.+[A-Za-z].*)|([A-Za-z].*\\s''[A-Za-z].*)|([A-Za-z].*\\s''\\.+[A-Za-z].*)";
    private static String END_AUDIO = "(,,[A-Za-z].*'')|(,,\\.+[A-Za-z].*'')|([A-Za-z].*\\s,,[A-Za-z].*'')|(''[A-Za-z].*'')|(''\\.+[A-Za-z].*'')|([A-Za-z].*\\s''[A-Za-z].*'')|([A-Za-z].*,'' [A-Za-z].*)|([A-Za-z].*'')";
    private static String BEGIN_TELEPATHIC = "(>[A-Za-z].*)|(>\\.+[A-Za-z].*)|([A-Za-z].*\\s>[A-Za-z].*)";
    private static String CONTINUE_TELEPATHIC = "(>\\|[A-Za-z].*)|(>\\|\\.+[A-Za-z].*)|([A-Za-z].*\\s>\\|[A-Za-z].*)|([A-Za-z].*\\s>\\|\\.+[A-Za-z].*)";
    private static String END_TELEPATHIC = "(>\\.+[A-Za-z].*,< [A-Za-z].*)|(>\\|\\.+[A-Za-z].*,< [A-Za-z].*)|(>\\|[A-Za-z].*,< [A-Za-z].*)|(>[A-Za-z].*,< [A-Za-z].*)|([A-Za-z].*,< [A-Za-z].*)|(>[A-Za-z].*<)|(>\\.+[A-Za-z].*<)|(>\\|\\.+[A-Za-z].*<)|([A-Za-z].*\\s>[A-Za-z].*<)|(>\\|[A-Za-z].*<)|(>\\|\\.+[A-Za-z].*<)|([A-Za-z].*\\s>\\|[A-Za-z].*<)|([A-Za-z].*\\s>\\|\\.+[A-Za-z].*<)|([A-Za-z].*<)";
    private static String BEGIN_INTERNAL = "(<[A-Za-z].*)|(<\\.+[A-Za-z].*)|([A-Za-z].*\\s<[A-Za-z].*)";
    private static String CONTINUE_INTERNAL = "(<\\|[A-Za-z].*)|(<\\|\\.+[A-Za-z].*)|([A-Za-z].*\\s<\\|[A-Za-z].*)|([A-Za-z].*\\s<\\|\\.+[A-Za-z].*)";
    private static String END_INTERNAL = "(<\\|\\.*[A-Za-z].*,> [A-Za-z].*)|(<\\.*[A-Za-z].*,> [A-Za-z].*)|(<\\|[A-Za-z].*,> [A-Za-z].*)|(<[A-Za-z].*,> [A-Za-z].*)|([A-Za-z].*,> [A-Za-z].*)|(<[A-Za-z].*>)|(<\\.+[A-Za-z].*>)|([A-Za-z].*\\s<[A-Za-z].*>)|(<\\|[A-Za-z].*>)|(<\\|\\.+[A-Za-z].*>)|([A-Za-z].*\\s<\\|[A-Za-z].*>)|([A-Za-z].*\\s<\\|\\.+[A-Za-z].*>)|([A-Za-z].*>)";
    private DialogStateBuilder dialogStateBuilder;
    private DialogState dialogState;

    @BeforeMethod
    public void setup() throws IOException {
        dialogState = new DialogState();
        dialogStateBuilder = new DialogStateBuilder();
        dialogState = dialogStateBuilder.defineDialogStateSyntax(dialogState);

    }

    @Test
    public void testDefineDialogStateSyntax() throws IOException {

        Assert.assertEquals(dialogState.getTelepathicBeginRegex(), BEGIN_TELEPATHIC);
        Assert.assertEquals(dialogState.getTelepathicContinueRegex(), CONTINUE_TELEPATHIC);
        Assert.assertEquals(dialogState.getTelepathicEndRegex(), END_TELEPATHIC);

        Assert.assertEquals(dialogState.getInternalBeginRegex(), BEGIN_INTERNAL);
        Assert.assertEquals(dialogState.getInternalContinueRegex(), CONTINUE_INTERNAL);
        Assert.assertEquals(dialogState.getInternalEndRegex(), END_INTERNAL);

        Assert.assertEquals(dialogState.getAudioBeginRegex(), BEGIN_AUDIO);
        Assert.assertEquals(dialogState.getAudioContinueRegex(), CONTINUE_AUDIO);
        Assert.assertEquals(dialogState.getAudioEndRegex(), END_AUDIO);

    }


    @Test
    public void testIsDialogAudio(){

        String sentence = "I have audio dialog, ,,I talk.''";

        boolean is = dialogStateBuilder.isDialogInString(sentence);

        Assert.assertTrue(is);
    }



    @Test
    public void testIsDialogInternal(){

        String sentence = "I have internal dialog, <I talk.>";

        boolean is = dialogStateBuilder.isDialogInString(sentence);

        Assert.assertTrue(is);
    }



    @Test
    public void testIsDialogTelepathic(){

        String sentence = "I have telepathic dialog, >I talk.<";

        boolean is = dialogStateBuilder.isDialogInString(sentence);

        Assert.assertTrue(is);
    }



    @Test
    public void testIsDialogNo(){

        String sentence = "I have no dialog.";

        boolean is = dialogStateBuilder.isDialogInString(sentence);

        Assert.assertFalse(is);
    }


    @Test
    public void isDialogInStringCompleteAudio(){

        String sentenceBeginEnd = ",,I begin talking on complete sentence.''";
        String sentenceContinueEnd = "''I continue talking on complete sentence.''";


        boolean isBeginEnd = dialogStateBuilder.isDialogInStringComplete(sentenceBeginEnd);
        boolean isContinueEnd = dialogStateBuilder.isDialogInStringComplete(sentenceContinueEnd);

        Assert.assertTrue(isBeginEnd);
        Assert.assertTrue(isContinueEnd);

    }

    @Test
    public void isDialogInStringCompleteInternal(){
        String sentenceBeginEnd = "<I begin talking on complete sentence.>";
        String sentenceContinueEnd = "<|I continue talking on complete sentence.>";


        boolean isBeginEnd = dialogStateBuilder.isDialogInStringComplete(sentenceBeginEnd);
        boolean isContinueEnd = dialogStateBuilder.isDialogInStringComplete(sentenceContinueEnd);

        Assert.assertTrue(isBeginEnd);
        Assert.assertTrue(isContinueEnd);

    }


    @Test
    public void isDialogInStringCompleteTelepathic(){

        String sentenceBeginEnd = ">I begin talking on complete sentence.<";
        String sentenceContinueEnd = ">|I continue talking on complete sentence.<";


        boolean isBeginEnd = dialogStateBuilder.isDialogInStringComplete(sentenceBeginEnd);
        boolean isContinueEnd = dialogStateBuilder.isDialogInStringComplete(sentenceContinueEnd);

        Assert.assertTrue(isBeginEnd);
        Assert.assertTrue(isContinueEnd);

    }



    @Test
    public void isDialogInStringCompleteNo(){

        String sentenceNo = "I begin complete sentence.";
        String sentenceNotBegin = "I think, >|I continue talking on complete sentence.<";
        String sentenceNotEnd = "''I am going to win,'' said Sally.";
        String sentenceBegin = "<|I am right.";

        boolean isNo = dialogStateBuilder.isDialogInStringComplete(sentenceNo);
        boolean isNotBegin = dialogStateBuilder.isDialogInStringComplete(sentenceNotBegin);
        boolean isNotEnd = dialogStateBuilder.isDialogInStringComplete(sentenceNotEnd);
        boolean isBegin = dialogStateBuilder.isDialogInStringComplete(sentenceBegin);

        Assert.assertFalse(isNo);
        Assert.assertFalse(isNotBegin);
        Assert.assertFalse(isNotEnd);
        Assert.assertFalse(isBegin);

    }


    @Test
    public void  testIsDialogEndStringAll(){

        String sentenceBeginEnd = "I begin talking on complete sentence,<";
        String sentenceContinueEnd = "I continue talking on complete sentence,<";


        boolean isBeginEnd = dialogStateBuilder.isDialogEndString(sentenceBeginEnd);
        boolean isContinueEnd = dialogStateBuilder.isDialogEndString(sentenceContinueEnd);

        Assert.assertTrue(isBeginEnd);
        Assert.assertTrue(isContinueEnd);

    }



    @Test
    public void  testIsDialogEndStringNo(){

        String sentenceBeginEnd = "I begin talking on complete sentence,";
        String sentenceContinueEnd = "I continue talking on complete sentence,";


        boolean isBeginEnd = dialogStateBuilder.isDialogEndString(sentenceBeginEnd);
        boolean isContinueEnd = dialogStateBuilder.isDialogEndString(sentenceContinueEnd);

        Assert.assertFalse(isBeginEnd);
        Assert.assertFalse(isContinueEnd);

    }



    @Test
    public void testCheckSentenceForNoDialogMarkOfSentenceOnly() throws Exception {

        dialogState.setSentence("I am not dialog.");

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), null);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertFalse(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkAudioDescriptionThenStartOfSentenceOnly() throws Exception {

        dialogState.setSentence("I say before dialog, ,,I only begin dialog.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());


    }


    @Test
    public void testCheckSentenceForDialogMarkAudioStartOfSentenceOnly() throws Exception {

        dialogState.setSentence(",,I begin dialog.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkAudioStartEndOfSentenceOnly() throws Exception {

        dialogState.setSentence(",,I begin and end the dialog.''");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_AUDIO);
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkAudioEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I didn't start the dialog but this will end the dialog.''");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkAudioContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("''And continued a sentence and will now end it again.''");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_AUDIO);
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDescriptionDialogMarkAudioContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I says before continued dialog, ''And continued dialog and will now end it again.''");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_AUDIO);
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDescriptionDialogMarkAudioContinueEllipsisEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I say before continued dialog, ''...Continued a dialog and will now end it again.''");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_AUDIO);
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDescriptionDialogMarkAudioContinueAndEndAfterDialogEnds() throws Exception {

        dialogState.setSentence("I say before continued dialog, ''Continued a dialog and will now end it again,'' and run.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_AUDIO);
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDescriptionDialogMarkAudioEndAfterDialogEnds() throws Exception {

        dialogState.setSentence("Continued a dialog and will now end it again,'' says John.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_AUDIO);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkTelepathicStartOfSentenceOnly() throws Exception {

        dialogState.setSentence(">I begin dialog.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkTelepathicStartEndOfSentenceOnly() throws Exception {

        dialogState.setSentence(">I begin and end the telepathic dialog.<");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkTelepathicStartEllipsisEndWithMoreAfter() throws Exception {

        dialogState.setSentence(">...I begin and end the telepathic dialog,< says John.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkTelepathicContinueEllipsisEndWithMoreAfter() throws Exception {

        dialogState.setSentence(">|...I begin and end the telepathic dialog,< says John.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkTelepathicStartEndWithMoreAfter() throws Exception {

        dialogState.setSentence(">I begin and end the telepathic dialog,< says John.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkTelepathicEndWithMoreAfter() throws Exception {

        dialogState.setSentence("I end the telepathic dialog,< says John.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkTelepathicEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I didn't start the dialog but this will end the telepathic dialog.<");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkTelepathicContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence(">|And continued a telepathic sentence and will now end it again.<");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDescriptionDialogMarkTelepathicContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I says before continued telepathic dialog, >|And continued dialog and will now end it again.<");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDescriptionDialogMarkTelepathicContinueEllipsisEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I say before continued telepathic dialog, >|...Continued a dialog and will now end it again.<");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_TELEPATHIC);
        dialogMarks.add(END_TELEPATHIC);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalDescriptionThenStartOfSentenceOnly() throws Exception {

        dialogState.setSentence("I say before internal dialog, <I only begin dialog.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());


    }


    @Test
    public void testCheckSentenceForDialogMarkInternalStartOfSentenceOnly() throws Exception {

        dialogState.setSentence("<I begin internal dialog.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertFalse(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkInternalStartEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("<I begin and end the internal dialog.>");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalStartEndWithEndAfter() throws Exception {

        dialogState.setSentence("<I begin and end the internal dialog,> said us.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalContinueEndWithEndAfter() throws Exception {
        dialogState.setSentence("<|I begin and end the internal dialog,> said us.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalEndWithEndAfter() throws Exception {
        dialogState.setSentence("I end the internal dialog,> said us.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalStartEllipsisEndWithEndAfter() throws Exception {

        dialogState.setSentence("<...I begin and end the internal dialog,> said us.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(BEGIN_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertTrue(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalContinueEllipsisEndWithEndAfter() throws Exception {

        dialogState.setSentence("<|...I begin and end the internal dialog,> said us.");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDialogMarkInternalEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I didn't start the internal dialog but this will end the dialog.>");
        List dialogMarks = new ArrayList();
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertFalse(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDialogMarkInternalContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("<|And continued a internal sentence and will now end it again.>");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }

    @Test
    public void testCheckSentenceForDescriptionDialogMarkInternalContinueEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I says before continued internal dialog, <|And continued dialog and will now end it again.>");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testCheckSentenceForDescriptionDialogMarkInternalContinueEllipsisEndOfSentenceOnly() throws Exception {

        dialogState.setSentence("I say before continued telepathic dialog, <|...Continued a dialog and will now end it again.>");
        List dialogMarks = new ArrayList();
        dialogMarks.add(CONTINUE_INTERNAL);
        dialogMarks.add(END_INTERNAL);

        dialogState = dialogStateBuilder.checkSentenceForDialogMark(dialogState);

        Assert.assertEquals(dialogState.getDialogMark(), dialogMarks);
        Assert.assertFalse(dialogState.isDialogBegin());
        Assert.assertTrue(dialogState.isDialogContinue());
        Assert.assertTrue(dialogState.isDialogEnd());
        Assert.assertTrue(dialogState.isDialog());

    }


    @Test
    public void testFindDialogCreator() {

    }
*/
}
