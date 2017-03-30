package com.wordsum.read.models.story.character.indicator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * The model to hold the acts within the character indicator.
 *
 * This model will hold multiple acts
 */
public class Act {

    boolean exists;
    BigDecimal probability;
    List<String> entities;
    List<String> descriptors;
    HashMap<String, HashMap<String, String>> rootTypedDependency;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    public List<String> getEntities() {
        return entities;
    }

    public void setEntities(List<String> entities) {
        this.entities = entities;
    }

    public void addEntity(String entity) {
        entities.add(entity);
    }

    public String getEntity(Integer index){
        return entities.get(index);
    }

    public List<String> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<String> descriptors) {
        this.descriptors = descriptors;
    }

    public String getDescriptor(Integer index) {
        return descriptors.get(index);
    }

    public void addDescriptors(String descriptor) {
        this.descriptors.add(descriptor);
    }

    public HashMap<String, HashMap<String, String>> getRootTypedDependency() {
        return rootTypedDependency;
    }

    public void setRootTypedDependency(HashMap<String, HashMap<String, String>> rootTypedDependency) {
        this.rootTypedDependency = rootTypedDependency;
    }
}
