package com.wordsum.read.builders.nlp;

import com.google.gson.JsonElement;
import com.wordsum.publish.utils.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
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


/**
 * Created by kalab on 4/2/16.
 */
public class PennTreebankStateBuilderTest {


    @Test
    public void testRecursiveNodesSimple() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        Map<String, Map<String, String>> pennTreebank = new HashMap<>();
        //Create the base version and get root sentence.
        JsonElement jsonElementBase = PennTreebankStateBuilder.getRootSentenceArray(jsonElement);
        pennTreebank = PennTreebankStateBuilder.recursiveNodes(jsonElementBase, pennTreebank, "s");

        Assert.assertFalse(pennTreebank.isEmpty());
        Assert.assertEquals(pennTreebank.toString(), "{s_node_0_leaf={phrase=NP}, s_node_1_node_1_node={NNP=Rind}, s_node_2_node={PERIOD=.}, s_node_0_node={PRP=She}, s_node_1_node_0_node={VBZ=follows}, s_node_1_node_1_leaf={phrase=NP}, s_node_1_leaf={phrase=VP}}");
    }


    @Test
    public void testRecursiveNodesComplex() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        Map<String, Map<String, String>> pennTreebank = new HashMap<>();
        //Create the base version and get root sentence.
        JsonElement jsonElementBase = PennTreebankStateBuilder.getRootSentenceArray(jsonElement);
        pennTreebank = PennTreebankStateBuilder.recursiveNodes(jsonElementBase, pennTreebank, "s");

        Assert.assertFalse(pennTreebank.isEmpty());
        Assert.assertEquals(pennTreebank.toString(), "{s_node_1_node_4_leaf={phrase=VP}, s_node_1_node_0_node_2_node_1_node_0_node_0_node={NNP=Rind}, s_node_1_node_0_node_2_node_1_node_0_leaf={phrase=NP}, s_node_1_node_0_node_2_node_1_node_1_node_0_node={JJ=moldy}, s_node_1_node_2_node_2_node_0_node={IN=from}, s_node_1_node_2_node_1_node_3_node={NN=rope}, s_node_1_node_2_node_1_node_0_node={DT=a}, s_node_1_leaf={phrase=VP}, s_node_1_node_0_node_2_node_0_node={IN=from}, s_node_1_node_2_node_2_node_1_node_1_node={NN=potato}, s_node_1_node_2_leaf={phrase=VP}, s_node_1_node_2_node_2_leaf={phrase=PP}, s_node_1_node_6_node={VBZ=says}, s_node_1_node_0_node_0_node={VBZ=grabs}, s_node_1_node_2_node_1_node_1_node={JJ=white}, s_node_0_node_0_node_0_node={NNP=Rind}, s_node_1_node_4_node_1_leaf={phrase=NP}, s_node_1_node_0_node_1_node_1_node={JJ=dirty}, s_node_1_node_3_node={COMMA=,}, s_node_1_node_0_node_2_leaf={phrase=PP}, s_node_1_node_2_node_0_node={VBZ=pulls}, s_node_1_node_4_node_0_node={VBZ=nudges}, s_node_0_leaf={phrase=NP}, s_node_0_node_0_leaf={phrase=NP}, s_node_1_node_0_node_1_node_2_node={NN=wool}, s_node_1_node_0_node_2_node_1_node_0_node_1_node={POS='s}, s_node_1_node_1_node={CC=and}, s_node_1_node_2_node_1_node_2_node={NN=silk}, s_node_1_node_2_node_2_node_1_node_2_node={NN=sack}, s_node_2_node={COMMA=,}, s_node_0_node_1_node={NN=orc}, s_node_1_node_6_leaf={phrase=VP}, s_node_1_node_2_node_1_leaf={phrase=NP}, s_node_1_node_0_node_1_node_0_node={DT=the}, s_node_0_node_0_node_1_node={POS='s}, s_node_1_node_0_node_1_node_3_node={NN=blanket}, s_node_1_node_0_node_1_leaf={phrase=NP}, s_node_1_node_2_node_2_node_1_leaf={phrase=NP}, s_node_1_node_0_node_2_node_1_node_1_leaf={phrase=ADJP}, s_node_0_node_2_node={NN=mom}, s_node_1_node_5_node={COMMA=,}, s_node_1_node_4_node_1_node={NNP=Rind}, s_node_1_node_0_leaf={phrase=VP}, s_node_1_node_0_node_2_node_1_leaf={phrase=NP}, s_node_1_node_0_node_2_node_1_node_2_node={NN=bed}, s_node_1_node_0_node_2_node_1_node_1_node_1_node={JJ=straw}, s_node_1_node_2_node_2_node_1_node_0_node={PRP$=her}}");
    }

    @Test
    public void testConvertStringToJsonElement() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        Assert.assertNotNull(jsonElement);
        Assert.assertNotNull(jsonElement.getAsJsonObject().get("node"));

    }

    @Test
    public void testIsJsonArrayTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isJsonArray(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertTrue(node);

    }

    @Test
    public void testIsJsonArrayFalseJsonObject() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isJsonArray(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertFalse(node);

    }



    @Test
    public void testIsJsonArrayFalseZeroSize() throws Exception {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("array",jsonArray);
        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(jsonObject.toString());

        boolean node = PennTreebankStateBuilder.isJsonArray(jsonElement.getAsJsonObject().get("array"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsJsonObjectTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isJsonObject(jsonElement, "node");

        Assert.assertTrue(node);

    }

    @Test
    public void testIsJsonObjectFalseNotJsonObjectButIsString() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isJsonObject(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("value"), "node");

        Assert.assertFalse(node);

    }

    @Test
    public void testIsJsonArrayFalseJsonArray() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isJsonObject(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node"), "node");

        Assert.assertFalse(node);

    }

    @Test
    public void testGetRootNodeArrayTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        JsonElement jsonElementNode = PennTreebankStateBuilder.getRootSentenceArray(jsonElement);

        Assert.assertTrue(jsonElementNode.isJsonArray());

    }

    @Test
    public void testFetRootNodeNotRoot() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        JsonElement jsonElementNode = PennTreebankStateBuilder.getRootSentenceArray(jsonElement.getAsJsonObject());

        Assert.assertFalse(jsonElementNode.isJsonObject());

    }


    @Test
    public void testMapNode(){

    }


    @Test
    public void testIsNodeTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isNode(jsonElement);

        Assert.assertTrue(node);

    }

    @Test
    public void testIsNodeFalseNotJsonObjectButIsString() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isNode(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("value"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsNodeFalseJsonArray() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isNode(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsValueTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isValue(jsonElement.getAsJsonObject().get("node"));

        Assert.assertTrue(node);

    }

    @Test
    public void testIsValueFalseNotJsonObjectButIsString() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isValue(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("value"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsValueFalseJsonArray() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isValue(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsLeafTrue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isLeaf(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonArray().get(2));

        Assert.assertTrue(node);

    }

    @Test
    public void testIsLeafFalseNotJsonObjectButIsString() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isLeaf(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("value"));

        Assert.assertFalse(node);

    }

    @Test
    public void testIsLeafFalseJsonArray() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        boolean node = PennTreebankStateBuilder.isLeaf(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertFalse(node);

    }



    @Test
    public void testGetNode() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/simplePennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        JsonElement jsonElementNode = PennTreebankStateBuilder.getNode(jsonElement);

        Assert.assertEquals(jsonElementNode.getAsJsonObject().toString(),"{\"node\":{\"node\":[{\"node\":{\"leaf\":" +
                "{\"value\":\"She\"},\"value\":\"PRP\"},\"value\":\"NP\"},{\"node\":[{\"leaf\":{\"value\":\"follows\"}," +
                "\"value\":\"VBZ\"},{\"node\":{\"leaf\":{\"value\":\"Rind\"},\"value\":\"NNP\"},\"value\":\"NP\"}]," +
                "\"value\":\"VP\"},{\"leaf\":{\"value\":\".\"},\"value\":\".\"}],\"value\":\"S\"},\"value\":\"ROOT\"}");

    }

    @Test
    public void testGetNodeNull() throws Exception {

        try {

            PennTreebankStateBuilder.getNode(null);

            Assert.fail();

        } catch (Exception e) {
            //Catch and move on as we expect an exception.
        }

    }

    @Test
    public void testGetValue() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        JsonElement jsonElementNode = PennTreebankStateBuilder.getValue(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node"));

        Assert.assertEquals(jsonElementNode.getAsString(),"S");

    }

    @Test
    public void testGetValueNull() throws Exception {

        try {

            PennTreebankStateBuilder.getValue(null);

            Assert.fail();

        } catch (Exception e) {
            //Catch and move on as we expect an exception.
        }

    }


    @Test
    public void testGetLeaf() throws Exception {

        String json = FileReader.readResourceToString(FileReader.readResourceFile("/complexPennTree.json"));

        JsonElement jsonElement = PennTreebankStateBuilder.convertStringToJsonElement(json.trim());

        JsonElement jsonElementNode = PennTreebankStateBuilder.getLeaf(jsonElement.getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonObject().get("node").getAsJsonArray().get(2));

        Assert.assertEquals(jsonElementNode.getAsJsonObject().toString(),"{\"value\":\",\"}");

    }

    @Test
    public void testGetLeafNull() throws Exception {

        try {

            PennTreebankStateBuilder.getLeaf(null);

            Assert.fail();

        } catch (Exception e) {
            //Catch and move on as we expect an exception.
        }

    }


    @Test
    public void testIncrementStringVersionIncrementTwoPartString(){

        String testString = PennTreebankStateBuilder.incrementStringVersion("1_2");

        Assert.assertEquals(testString,"1_3");


    }

    @Test
    public void testIncrementStringVersionIncrementFivePartString(){

        String testString = PennTreebankStateBuilder.incrementStringVersion("1_3_4_1_2");

        Assert.assertEquals(testString,"1_3_4_1_3");


    }


    @Test
    public void testAppendVersion(){

        String version = PennTreebankStateBuilder.appendVersion("1_1", 3);

        Assert.assertEquals(version, "1_1_3");

    }

    @Test
    public void testAppendVersionNull(){

        String version = PennTreebankStateBuilder.appendVersion(null, null);
        Assert.assertEquals(version, "1");

    }

    @Test
    public void testIncrementVersion() throws Exception {

        Integer integer = PennTreebankStateBuilder.incrementVersion(1);

        Assert.assertNotNull(integer,"2");

    }

    @Test
    public void testIncrementVersionNull() throws Exception {

        try {
            PennTreebankStateBuilder.incrementVersion(null);

            Assert.fail();
        }catch (Exception e) {
            //No nothing because was null like we want.
        }

    }

}
