package com.wordsum.process.read.builders.text;

import com.wordsum.process.read.builders.nlp.NlpStateBuilder;
import com.wordsum.process.read.builders.sentence.SentenceUtil;
import com.wordsum.process.read.models.text.ParagraphState;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public final class ParagraphStateBuilderTest {

    @Test
    public void testAddStringText() throws IOException {

        ParagraphState paragraphState = new ParagraphState();
        String testParagraph = "John is going to test a paragraph. " +
                "He ran along the path. " +
                "He looked to the sky and saw. " +
                "He stands and looks at Sue. " +
                "John smiles and runs from Sue, says, " +
                "\"We need to move! We need to run. We run to the hill.\" " +
                "John laughed loud.";

        ParagraphStateBuilder.addStringText(paragraphState, testParagraph);
        SentenceUtil.tagParagraph(paragraphState);

        Assert.assertEquals(paragraphState.getSentenceStates().get(0).getFragments().get(0).getText(), "John is going to test a paragraph. ");
    }

}
