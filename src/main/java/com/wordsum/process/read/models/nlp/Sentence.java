
package com.wordsum.process.read.models.nlp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sentence {

    private Integer index;
    private String parse;
    private List<BasicDependency> basicDependencies = null;
    private List<EnhancedDependency> enhancedDependencies = null;
    private List<EnhancedPlusPlusDependency> enhancedPlusPlusDependencies = null;
    private String sentimentValue;
    private String sentiment;
    private List<Double> sentimentDistribution = null;
    private String sentimentTree;
    private List<Object> entitymentions = null;
    private List<Token> tokens = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }

    public List<BasicDependency> getBasicDependencies() {
        return basicDependencies;
    }

    public void setBasicDependencies(List<BasicDependency> basicDependencies) {
        this.basicDependencies = basicDependencies;
    }

    public List<EnhancedDependency> getEnhancedDependencies() {
        return enhancedDependencies;
    }

    public void setEnhancedDependencies(List<EnhancedDependency> enhancedDependencies) {
        this.enhancedDependencies = enhancedDependencies;
    }

    public List<EnhancedPlusPlusDependency> getEnhancedPlusPlusDependencies() {
        return enhancedPlusPlusDependencies;
    }

    public void setEnhancedPlusPlusDependencies(List<EnhancedPlusPlusDependency> enhancedPlusPlusDependencies) {
        this.enhancedPlusPlusDependencies = enhancedPlusPlusDependencies;
    }

    public String getSentimentValue() {
        return sentimentValue;
    }

    public void setSentimentValue(String sentimentValue) {
        this.sentimentValue = sentimentValue;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public List<Double> getSentimentDistribution() {
        return sentimentDistribution;
    }

    public void setSentimentDistribution(List<Double> sentimentDistribution) {
        this.sentimentDistribution = sentimentDistribution;
    }

    public String getSentimentTree() {
        return sentimentTree;
    }

    public void setSentimentTree(String sentimentTree) {
        this.sentimentTree = sentimentTree;
    }

    public List<Object> getEntitymentions() {
        return entitymentions;
    }

    public void setEntitymentions(List<Object> entitymentions) {
        this.entitymentions = entitymentions;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
