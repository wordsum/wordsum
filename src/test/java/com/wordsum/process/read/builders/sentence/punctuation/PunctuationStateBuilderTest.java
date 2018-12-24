package com.wordsum.process.read.builders.sentence.punctuation;

import com.wordsum.process.read.models.sentence.punctuation.PeriodStates;
import com.wordsum.process.read.models.sentence.punctuation.PunctuationState;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

public class PunctuationStateBuilderTest {

    private PunctuationState punctuationState;

    @BeforeTest
    public void setupTest() throws Exception {
        punctuationState = new PunctuationState();
    }


    @Test
    public void testIsSentenceWithPeriodPermutations() throws Exception {

        String testSentence = "A sentence called the initials I.E. with an AntiPattern of .He with an Ellispsis...THEN a period.";

        punctuationState = new PunctuationState();

        punctuationState = PunctuationStateBuilder.createPunctuationState(testSentence);

        Assert.assertEquals(punctuationState.periodState.patterns.get(PeriodStates.ELLIPSIS.name()).get(0),"Ellispsis...THEN");
        Assert.assertEquals(punctuationState.periodState.patterns.get(PeriodStates.INITIAL.name()).get(0),"I.E.");
        Assert.assertEquals(punctuationState.periodState.patterns.get(PeriodStates.PERIOD.name()).get(0),"period.");
        Assert.assertEquals(punctuationState.periodState.patterns.get(PeriodStates.ANTI.name()).get(0),".He");


    }
}
