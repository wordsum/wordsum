package com.wordsum.process.read.builders.nlp;

import com.wordsum.process.read.models.nlp.NlpState;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.TypedDependency;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

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
 * A class for testing the NLP Builder.
 *
 * @author Kalab J. Oster
 */
public class NlpStateBuilderTest {

    private StanfordCoreNLP stanfordCoreNLP;

    private Collection<TypedDependency> tdl;

    @BeforeTest
    public void setup() {

        stanfordCoreNLP = NlpStateBuilder.loadStanfordCoreNLP();
    }

    @Test
    public void testGetSentenceSemanticGraph() throws IOException {

        NlpState nlpState = NlpStateBuilder.getNLP("I run the hill.", stanfordCoreNLP);

        Assert.assertEquals(nlpState.getSentences().get(0).getSentiment(), "Neutral");

    }
}