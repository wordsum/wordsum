package com.wordsum.process.read.builders.dictionary;

import com.wordsum.process.read.models.dictionary.DictionaryState;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

public class DictionaryStateBuilderTest {

    JazzyStateBuilder jazzyStateBuilder;

    @BeforeTest
    public void steuUp() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
    }

    @Test
    public void testSentenceWithOneMisspelled() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List<String> misspelledWords = jazzyStateBuilder.check("I stood on the top of the mountian. No. Wait. I stod on the mountain.");
        Assert.assertEquals("mountian", misspelledWords.get(0));
        Assert.assertEquals("stod", misspelledWords.get(1));
    }


    @Test
    public void testSentenceWithNoMisspelled() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List<String> misspelledWords = jazzyStateBuilder.check("I stood on the top of the mountain. No. Wait. I stood on the mountain.");
        Assert.assertTrue(misspelledWords.isEmpty());

    }


    @Test
    public void testWithNull() {

        try {
            jazzyStateBuilder = new JazzyStateBuilder();
            jazzyStateBuilder.check(null);
            Assert.fail();
        } catch (Exception e) {

        }

    }


    @Test
    public void testWithOneMisspelled() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List<String> misspelledWords = jazzyStateBuilder.check("mountian");
        Assert.assertEquals(misspelledWords.get(0), "mountian");
    }

    @Test
    public void testWithOneSpelled() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List<String> misspelledWords = jazzyStateBuilder.check("mountain");
        Assert.assertTrue(misspelledWords.isEmpty());
    }

    @Test
    public void testGetSuggestionsMoreThanOne() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List suggestedWords = jazzyStateBuilder.suggest("mountin", 1);
        Assert.assertEquals(suggestedWords.get(0), "mountain".trim());
        Assert.assertEquals(suggestedWords.get(1), "mounting".trim());
        Assert.assertEquals(suggestedWords.size(), 2);
    }

    @Test
    public void testWithSpelledCongov() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List misspelledWords = jazzyStateBuilder.check("congov");
        Assert.assertTrue(misspelledWords.isEmpty());
    }

    @Test
    public void testGetMisSpelledCongov() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List suggestedWords = jazzyStateBuilder.suggest("congv", 1);
        Assert.assertEquals(suggestedWords.get(0), "congov".trim());
        Assert.assertEquals(suggestedWords.size(), 1);
    }

    @Test
    public void testSuggestedWordsWithOneMisspelledWord() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List suggestedWords = jazzyStateBuilder.suggest("mountin", 1);

        Assert.assertEquals(suggestedWords.get(0), "mountain".trim());
        Assert.assertEquals(suggestedWords.get(1), "mounting".trim());
        Assert.assertEquals(suggestedWords.size(), 2);
    }

    @Test
    public void testMisspelledWordsWithOneMisspelledWord() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();
        List<String> misspelledWords = jazzyStateBuilder.check("mountin");

        Assert.assertEquals(misspelledWords.size(), 1);
        Assert.assertEquals(misspelledWords.get(0), "mountin");
    }


    @Test
    public void testToJazzyState() throws Exception {
        jazzyStateBuilder = new JazzyStateBuilder();

        DictionaryState dictionaryState;

        dictionaryState = jazzyStateBuilder.toJazzyState("mountin");
        Assert.assertEquals(dictionaryState.getText(), "mountin");
        Assert.assertTrue(dictionaryState.getMisspelledWords().containsKey("mountin"));
        Assert.assertEquals(dictionaryState.getMisspelledWords().get("mountin").toString(), "[mountain, mounting]");
    }


}
