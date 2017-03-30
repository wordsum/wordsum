package com.wordsum.read.builders.punctuation;

import com.wordsum.read.models.punctuation.PeriodState;
import com.wordsum.read.models.punctuation.PeriodStates;
import com.wordsum.publish.utils.FileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;

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

public class PeriodStateBuilderTest {

    PeriodState periodState;

    @BeforeMethod
    public void setupTest() throws Exception {
        periodState = new PeriodState();
    }

    @Test
    public void testCreatePeriodState(){

        String testSentence = "A sentence called the initials I.E. with an AntiPattern of .He with an Ellipsis...THEN a period.";

        periodState = new PeriodState();
        periodState = PeriodStateBuilder.createPeriodState(testSentence);

        Assert.assertEquals(periodState.patterns.get(PeriodStates.ELLIPSIS.name()).get(0),"Ellipsis...THEN");
        Assert.assertEquals(periodState.patterns.get(PeriodStates.INITIAL.name()).get(0),"I.E.");
        Assert.assertEquals(periodState.patterns.get(PeriodStates.PERIOD.name()).get(0),"period.");
        Assert.assertEquals(periodState.patterns.get(PeriodStates.ANTI.name()).get(0),".He");
        Assert.assertEquals(periodState.getPeriodStates().toString(),"{INITIAL=([A-Z]\\.)+[\\.]{0,1}, ELLIPSIS=([A-Za-z]*\\.\\.\\.[A-Za-z]*)+[\\\\.|\\\\!|\\\\?]{0,1}, ANTI=null, MARK=., PERIOD=[a-zA-Z0-9]+\\.$}");


    }

    @Test
    public void testTrueIsSentenceWithPeriod() throws Exception {

        boolean is = PeriodStateBuilder.isTextWithPeriod("There is a period.");

        Assert.assertTrue(is);

    }


    @Test
    public void testFalseIsSentenceWithPeriod() throws Exception {

        boolean is = PeriodStateBuilder.isTextWithPeriod("There is no period");

        Assert.assertFalse(is);

    }

    @Test
    public void testSortPatternsEllipsis() throws Exception {

        periodState = new PeriodState();

        PeriodStateBuilder.sortPatterns(periodState, "Hello...", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello....", true);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO...", true);
        PeriodStateBuilder.sortPatterns(periodState, "hello...", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello...", false);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO...", false);
        PeriodStateBuilder.sortPatterns(periodState, "hello...", false);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO...AGAIN...Again...AGAIN!", true);
        PeriodStateBuilder.sortPatterns(periodState, "...Hello?", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello...AGAIN", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello...Again.", true);
        PeriodStateBuilder.sortPatterns(periodState, "...There", false);
        PeriodStateBuilder.sortPatterns(periodState, "...There...", false);
        PeriodStateBuilder.sortPatterns(periodState, "...There.", true);
        PeriodStateBuilder.sortPatterns(periodState, "...THERE", false);
        PeriodStateBuilder.sortPatterns(periodState, "...THERE.", true);
        PeriodStateBuilder.sortPatterns(periodState, "...there", false);

        Assert.assertEquals(periodState.getPatterns().toString(),"{ELLIPSIS=[Hello..., Hello...., HELLO..., hello..., Hello..., HELLO..., hello..., HELLO...AGAIN...Again...AGAIN!, ...Hello?, Hello...AGAIN, Hello...Again., ...There, ...There..., ...There., ...THERE, ...THERE., ...there]}");
        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()).size(),17);

    }

    @Test
    public void testSortAntiPatternsEllipsis() throws Exception {

        periodState = new PeriodState();

        PeriodStateBuilder.sortPatterns(periodState, ".Hello...", true);
        PeriodStateBuilder.sortPatterns(periodState, "..Hello...", true);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO.....", true);
        PeriodStateBuilder.sortPatterns(periodState, "hello..", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello..", false);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO..", false);
        PeriodStateBuilder.sortPatterns(periodState, "hello..", false);
        PeriodStateBuilder.sortPatterns(periodState, "HELLO...AGAIN...Again....AGAIN!", true);
        PeriodStateBuilder.sortPatterns(periodState, "....Hello?", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello....AGAIN", true);
        PeriodStateBuilder.sortPatterns(periodState, "Hello....Again.", true);
        PeriodStateBuilder.sortPatterns(periodState, "....There", false);
        PeriodStateBuilder.sortPatterns(periodState, "....There.", true);
        PeriodStateBuilder.sortPatterns(periodState, "....THERE", false);
        PeriodStateBuilder.sortPatterns(periodState, "....THERE.", true);
        PeriodStateBuilder.sortPatterns(periodState, "....there", false);

        Assert.assertEquals(periodState.getPatterns().toString(), "{ANTI=[.Hello..., ..Hello..., HELLO....., hello.., Hello.., HELLO.., hello.., HELLO...AGAIN...Again....AGAIN!, ....Hello?, Hello....AGAIN, Hello....Again., ....There, ....There., ....THERE, ....THERE., ....there]}");
        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ANTI.name()).size(),16);
    }

    @Test
    public void testAddPatternWithAntiPattern(){

        periodState = new PeriodState();

        periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ANTI.name(), "The.BAD");

        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ANTI.name()).get(0), "The.BAD");


    }

    @Test
    public void testAddPatternWithPeriodStateAndPattern(){

        periodState = new PeriodState();

        periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ELLIPSIS.name(), "The...");

        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()).get(0), "The...");


    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPatternWithPeriodStateNullAndPattern(){

        periodState = null;

        periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ELLIPSIS.name(), "The...");


    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPatternWithPeriodStateAndPatternEmpty(){

        periodState = new PeriodState();

        periodState = PeriodStateBuilder.addPattern(periodState, PeriodStates.ELLIPSIS.name(), "");


    }

    @Test
    public void testAntiPeriod() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/period/PeriodStatesAnti.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        PeriodState periodState = new PeriodState();

        for(int i = 0; i < patternArray.length; i++ ){

            periodState = PeriodStateBuilder.checkTextPeriodState(periodState, patternArray[i]);

        }

        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ANTI.name()).size(),16);
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.PERIOD.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.INITIAL.name()));
    }


    @Test
    public void testEllipsisPeriod() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/period/PeriodStatesEllipsis.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        PeriodState periodState = new PeriodState();

        for(int i = 0; i < patternArray.length; i++ ){

            periodState = PeriodStateBuilder.checkTextPeriodState(periodState, patternArray[i]);

        }

        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ANTI.name()));
        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()).size(), 17);
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.PERIOD.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.INITIAL.name()));
    }



    @Test
    public void testEndPeriod() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/period/PeriodStatesEndPeriod.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        PeriodState periodState = new PeriodState();

        for(int i = 0; i < patternArray.length; i++ ){

            periodState = PeriodStateBuilder.checkTextPeriodState(periodState, patternArray[i]);

        }

        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ANTI.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()));
        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.PERIOD.name()).size(), 4);
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.INITIAL.name()));
    }


    @Test
    public void testInitialPeriod() throws Exception {

        File testFile = FileReader.readResourceFile("/punctuationmodel/period/PeriodStatesInitials.txt");
        String pattern = FileReader.readResourceToString(testFile);

        String[] patternArray = pattern.split("\\n");

        PeriodState periodState = new PeriodState();

        for(int i = 0; i < patternArray.length; i++ ){

            periodState = PeriodStateBuilder.checkTextPeriodState(periodState, patternArray[i]);

        }

        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ANTI.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.ELLIPSIS.name()));
        Assert.assertNull(periodState.getPatterns().get(PeriodStates.PERIOD.name()));
        Assert.assertEquals(periodState.getPatterns().get(PeriodStates.INITIAL.name()).size(),3);
    }

}