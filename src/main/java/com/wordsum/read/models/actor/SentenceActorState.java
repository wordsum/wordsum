package com.wordsum.read.models.actor;

import com.wordsum.read.models.sentence.structure.SimpleStructureState;


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

public class SentenceActorState {

    private String sentence;
    private ConstituencyActorState constituencyActorState;
    private SimpleStructureState simpleStructureState;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public SimpleStructureState getSimpleStructureState() {
        return simpleStructureState;
    }

    public void setSimpleStructureState(SimpleStructureState simpleStructureState) {
        this.simpleStructureState = simpleStructureState;
    }

    public ConstituencyActorState getConstituencyActorState() {
        return constituencyActorState;
    }

    public void setConstituencyActorState(ConstituencyActorState constituencyActorState) {
        this.constituencyActorState = constituencyActorState;
    }


}
