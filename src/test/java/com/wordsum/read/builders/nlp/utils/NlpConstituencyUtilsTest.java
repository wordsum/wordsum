package com.wordsum.read.builders.nlp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.publish.utils.FileReader;
import com.wordsum.read.models.nlp.NlpState;
import com.wordsum.read.models.text.FileState;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

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

public class NlpConstituencyUtilsTest {

    @Test
    public void testHasConstituencyTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.hasConstituency(nlpState);

        Assert.assertEquals(state, true);


    }

    @Test
    public void testHasConstituencyFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyFalse.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        nlpState.setPennTreebankState(null);

        boolean state = NlpConstituencyUtils.hasConstituency(nlpState);

        Assert.assertEquals(state,false);

    }

    @Test
    public void testIsLeafPhaseTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isLeaf(nlpState, "s_node_0_leaf");

        Assert.assertEquals(state, true);

    }


    @Test
    public void testIsLeafPhaseNotLeafKey() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isLeaf(nlpState, "s_node_0_node");

        Assert.assertEquals(state, false);

    }

    @Test
    public void testIsLeafPhaseFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isLeaf(nlpState, "s_node_2_leaf");

        Assert.assertEquals(state, false);

    }


    @Test
    public void testIsNodePhaseTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isNode(nlpState, "s_node_0_node");

        Assert.assertEquals(state, true);

    }


    @Test
    public void testIsNodePhaseNotNodeKey() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isNode(nlpState, "s_node_0_leaf");

        Assert.assertEquals(state, false);

    }

    @Test
    public void testIsNodePhaseFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        boolean state = NlpConstituencyUtils.isNode(nlpState, "s_node_3_node");

        Assert.assertEquals(state, false);

    }


    @Test
    public void testGetLeafsKeysTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        ArrayList<String> leafsKeys = NlpConstituencyUtils.getLeafsKeys(nlpState);

        Assert.assertEquals(leafsKeys.toString(), "[s_node_0_leaf, s_node_1_node_1_leaf, s_node_1_leaf]");

    }


    @Test
    public void testGetPhraseTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        String phrase = NlpConstituencyUtils.getPhrase(nlpState, "s_node_0_leaf");

        Assert.assertEquals(phrase, "NP");

    }


    @Test
    public void testGetPhraseFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        String phrase = NlpConstituencyUtils.getPhrase(nlpState, "s_node_0_node");

        Assert.assertEquals(phrase, null);

    }


    @Test
    public void testGetNodeKeyValueTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Map<String, String> nodeKeyValue = NlpConstituencyUtils.getNodeKeyValue(nlpState, "s_node_0_node");

        Assert.assertEquals(nodeKeyValue.toString(), "{PRP=I}");

    }

    @Test
    public void testGetNodeKeyValueFalse() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Map<String, String> nodeKeyValue = NlpConstituencyUtils.getNodeKeyValue(nlpState, "s_node_0_leaf");

        Assert.assertEquals(nodeKeyValue, null);

    }


    @Test
    public void testGetLeafNodesTrue() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Map<String, Map<String, String>> leafNodes = NlpConstituencyUtils.getLeafNodes(nlpState, "s_node_1_leaf");

        Assert.assertEquals(leafNodes.toString(), "{s_node_1_node_1_node_1_node={NN=road}, s_node_1_node_0_node={VBD=ran}, s_node_1_node_1_node_0_node={DT=the}, s_node_1_node_1_leaf={phrase=NP}, s_node_1_leaf={phrase=VP}}");

    }


    @Test
    public void testGetLeafNodesNull() throws Exception {

        File subjectVerbObjectFile = FileReader.readResourceFile("/read/builders/sentence/utils/nlpconstituency/HasConstituencyTrue.json");
        ObjectMapper simpleMapper = new ObjectMapper();
        FileState subjectVerbObjectState = simpleMapper.readValue(subjectVerbObjectFile, FileState.class);
        NlpState nlpState =  subjectVerbObjectState.getParagraphStates().get(0).getSentenceStates().get(0).getNlpState();

        Map<String, Map<String, String>> leafNodes = NlpConstituencyUtils.getLeafNodes(nlpState, "s_node_1_none");

        Assert.assertEquals(leafNodes.toString(),"{}");

    }

}
