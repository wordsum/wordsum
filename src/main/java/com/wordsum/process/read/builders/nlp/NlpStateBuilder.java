package com.wordsum.process.read.builders.nlp;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.process.read.models.nlp.NlpState;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.IOException;
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
public class NlpStateBuilder {

    private static Logger logger = LoggerFactory.getLogger(NlpStateBuilder.class);

    private NlpStateBuilder() {

    }

    public static StanfordCoreNLP loadStanfordCoreNLP() {
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment");
        props.put("outputFormat", "json");
        props.put("tokenize.options", "ptb3Escaping=false");
        props.put("ssplit.isOneSentence", "true");
        props.put("parse.maxlen", "10000");
        props.put("parse.model", "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        props.put("ner.corenlp.model", "edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz");
        props.put("parse.flags", "-retainTmpSubcategories");

        StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(props);

        return stanfordCoreNLP;

    }

    public static LexicalizedParser loadLexicalParser() {

        LexicalizedParser lp = LexicalizedParser.loadModel(
                "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz",
                "-maxLength", "1000", "-retainTmpSubcategories");

        return lp;
    }

    public static NlpState getNLP(@NotNull String text, @NotNull StanfordCoreNLP pipeline) throws IOException {

        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        StringWriter output = new StringWriter();

        PrintWriter out = new PrintWriter(output);

        pipeline.jsonPrint(annotation, out);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(output.toString(), NlpState.class);
    }

}
