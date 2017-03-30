package com.wordsum.read.builders.nlp;


import com.wordsum.read.models.communication.DialogStateEnum;
import com.wordsum.read.models.nlp.NlpState;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
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
 * A class to build a nlp model.
 *
 * This uses Stanford NLP to create the dependency models and the constituency model.
 *
 * I couldn't find any JSON or XML output types using 3.5ish, so I wrote this and adapted my
 * own model and abstracting away from the nlp model output.
 *
 * Now that 3.7.0 of Core NLP has more exposed and demonstrated json outputes for the trees,
 * all this code should be replaced and all methods using this changed.
 *
 * This was also written because at some point during time I thought of abstracting away the code,
 * but that may not be good.
 *
 * TLDR: I wrote this because I couldn't find how to get some object from  older version of Stanford Core NLP.
 *
 * @author Kalab J. Oster
 */
public class NlpStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(NlpStateBuilder.class);

    private NlpStateBuilder() {

    }

    public static StanfordCoreNLP loadStanfordCoreNLP() {
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
        props.put("tokenize.options", "ptb3Escaping=false");
        props.put("ssplit.isOneSentence", "true");
        props.put("parse.maxlen", "10000");
        props.put("parse.model", "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        props.put("ner.corenlp.model", "edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz");
        props.put("parse.flags", "-retainTmpSubcategories");

        StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(props);

        return stanfordCoreNLP;

    }


    public static StanfordCoreNLP loadStanfordCoreNLP(String regexnerMappingFile) {
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,regexner");
        props.put("tokenize.options", "ptb3Escaping=false");
        props.put("ssplit.isOneSentence", "true");
        props.put("parse.maxlen", "10000");
        props.put("parse.model", "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        props.put("ner.corenlp.model", "edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz");
        props.put("parse.flags", "-retainTmpSubcategories");
        props.put("regexner.mapping", regexnerMappingFile);

        StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(props);

        return stanfordCoreNLP;

    }

    public static LexicalizedParser loadLexicalParser() {

        LexicalizedParser lp = LexicalizedParser.loadModel(
                "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz",
                "-maxLength", "1000", "-retainTmpSubcategories");

        return lp;
    }

    public static NlpState defineStanfordNlpState(String sentence, StanfordCoreNLP stanfordCoreNLP, LexicalizedParser lexicalizedParser) throws InterruptedException {

        if (stanfordCoreNLP == null || sentence == null || lexicalizedParser == null) {
            throw new NullPointerException();
        }

        sentence = removeCommunicationMark(sentence);

        NlpState stanfordNlpState = new NlpState();
        stanfordNlpState.setSentence(sentence);

        SemanticGraph semanticGraph = getSentenceSemanticGraph(sentence, stanfordCoreNLP);
        stanfordNlpState.setTypedDependency(getTypedDependencies(semanticGraph.typedDependencies()));

        stanfordNlpState.setCoreAnnotations(getSentenceCoreAnnotations(sentence, stanfordCoreNLP));

        stanfordNlpState.setPennTreebankState(PennTreebankStateBuilder.createPennTreebankState(getPennTreebank(stanfordNlpState.getCoreAnnotations(), lexicalizedParser)));

        return stanfordNlpState;

    }

    public static String removeCommunicationMark(String sentence){

        sentence = sentence.replaceAll(DialogStateEnum.Nlp.Marks.get(), "");

        return sentence;
    }

    public static SemanticGraph getSentenceSemanticGraph(String sentence, StanfordCoreNLP stanfordCoreNLP) throws InterruptedException {

        if (stanfordCoreNLP == null || sentence == null) {
            throw new NullPointerException();
        }

        SemanticGraph semanticGraph = new SemanticGraph();

        Annotation sentenceAnnotation = new Annotation(sentence);

        stanfordCoreNLP.annotate(sentenceAnnotation);

        List<CoreMap> coreMaps = sentenceAnnotation.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap coreMap : coreMaps) {

            semanticGraph = coreMap.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);

            logger.debug("semanticGraph: " + semanticGraph.typedDependencies().toString());

        }

        return semanticGraph;


    }

    public static List<HashMap<String, HashMap<String, String>>> getTypedDependencies(Collection<TypedDependency> typedDependencies) {

        if (typedDependencies == null) {
            throw new NullPointerException();
        }

        List<HashMap<String, HashMap<String, String>>> listHashMapTypedDependencies = new ArrayList<HashMap<String, HashMap<String, String>>>();


        for (TypedDependency typedDependency : typedDependencies) {

            HashMap<String, HashMap<String, String>> hashMapTypedDependency = new HashMap<String, HashMap<String, String>>();

            HashMap<String, String> hashMapReln = new HashMap<String, String>();
            logger.debug("TypedDependency:");
            logger.debug("TypedDependency to String: " + typedDependency.toString());
            logger.debug("TypedDependency to String: " + typedDependency.reln().toString());
            logger.debug("TypedDependency to String: " + typedDependency.reln().getParent());
            logger.debug("TypedDependency to String: " + typedDependency.reln().getLongName());
            hashMapReln.put("tag", typedDependency.reln().toString());
            hashMapReln.put("string", typedDependency.toString());
            hashMapReln.put("name", typedDependency.reln().getLongName());
            if (typedDependency.reln().getParent() == null) {
                hashMapReln.put("parent", null);
            } else {
                hashMapReln.put("parent", typedDependency.reln().getParent().toString());
            }
            //Put it all in another hashmap..
            hashMapTypedDependency.put("reln", hashMapReln);

            HashMap<String, String> hashMapGov = new HashMap<String, String>();
            logger.debug("TypedDependency gov:");
            logger.debug("TypedDependency to String: " + typedDependency.gov().word());
            logger.debug("TypedDependency to String: " + new Integer(typedDependency.gov().index()).toString());
            logger.debug("TypedDependency to String: " + typedDependency.gov().tag());
            logger.debug("TypedDependency to String: " + typedDependency.gov().lemma());
            logger.debug("TypedDependency to String: " + typedDependency.gov().ner());
            hashMapGov.put("tag", typedDependency.gov().tag());
            hashMapGov.put("word", typedDependency.gov().word());
            hashMapGov.put("index", new Integer(typedDependency.gov().index()).toString());
            hashMapGov.put("lemma", typedDependency.gov().lemma());
            hashMapGov.put("ner", typedDependency.gov().ner());
            //Put in a another hashmap.
            hashMapTypedDependency.put("gov", hashMapGov);

            HashMap<String, String> hashMapDep = new HashMap<String, String>();
            logger.debug("TypedDependency dep:");
            logger.debug("TypedDependency to String: " + typedDependency.dep().word());
            logger.debug("TypedDependency to String: " + typedDependency.dep().index());
            logger.debug("TypedDependency to String: " + typedDependency.dep().tag());
            logger.debug("TypedDependency to String: " + typedDependency.dep().lemma());
            logger.debug("TypedDependency to String: " + typedDependency.dep().ner());
            hashMapDep.put("tag", typedDependency.dep().tag());
            hashMapDep.put("word", typedDependency.dep().word());
            hashMapDep.put("index", new Integer(typedDependency.dep().index()).toString());
            hashMapDep.put("lemma", typedDependency.dep().lemma());
            hashMapDep.put("ner", typedDependency.dep().ner());
            //Put in a another hashmap.
            hashMapTypedDependency.put("dep", hashMapDep);

            listHashMapTypedDependencies.add(hashMapTypedDependency);
        }

        return listHashMapTypedDependencies;
    }

    public static List<HashMap<String, String>> getSentenceCoreAnnotations(String sentence, StanfordCoreNLP stanfordCoreNLP) throws InterruptedException {

        if (stanfordCoreNLP == null || sentence == null) {
            throw new NullPointerException();
        }

        List<HashMap<String, String>> listMappedParts = new ArrayList<HashMap<String, String>>();

        Annotation sentenceAnnotation = new Annotation(sentence);

        stanfordCoreNLP.annotate(sentenceAnnotation);

        List<CoreMap> coreMaps = sentenceAnnotation.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap coreMap : coreMaps) {

            for (CoreLabel coreLabel : coreMap.get(CoreAnnotations.TokensAnnotation.class)) {

                HashMap<String, String> hashMappedParts = new HashMap<String, String>();

                hashMappedParts.put("text", coreLabel.get(CoreAnnotations.TextAnnotation.class));
                hashMappedParts.put("pos", coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class));
                hashMappedParts.put("net", coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class));

                logger.debug("\nNew CoreLabel:");
                logger.debug("CoreLabel text: " + coreLabel.get(CoreAnnotations.TextAnnotation.class));
                logger.debug("CoreLabel pos: " + coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class));
                logger.debug("CoreLabel net: " + coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class));

                listMappedParts.add(hashMappedParts);


            }

        }

        return listMappedParts;

    }


    // public static
    public static String getPennTreebank(List<HashMap<String, String>> coreAnnotationsListOfHashMaps, LexicalizedParser lexicalizedParser) {

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (HashMap coreAnnotationsListOfHashMap : coreAnnotationsListOfHashMaps) {
            stringArrayList.add(coreAnnotationsListOfHashMap.get("text").toString());
        }

        String[] strings = stringArrayList.toArray(new String[stringArrayList.size()]);
        String jsonString = getPennTreebankJsonObject(strings, lexicalizedParser);

        return jsonString;

    }


    public static String getPennTreebankJsonObject(String[] sentence, LexicalizedParser lexicalizedParser) {

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        Tree tree = lexicalizedParser.apply(Sentence.toWordList(sentence));
        tree.indentedXMLPrint(writer, false);

        String treeString = stringWriter.toString();
        ;
        JSONObject treeJson = XML.toJSONObject(treeString);

        return treeJson.toString();

    }

}
