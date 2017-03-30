package com.wordsum.read.models.story.character;

import com.wordsum.read.models.story.character.indicator.Actor;
import com.wordsum.read.models.story.character.indicator.Act;
import com.wordsum.read.models.story.character.indicator.Object;

/**
 * This is an instance of a character in a sentence found.
 *
 * This instance may be found in another character indicator of another
 * character is mentioned as either another object or another subject or the of either.
 *
 * This name is liable to change.
 */
public class CharacterIndicator {

    Integer id;
    Integer order;
    Integer narrator;
    String characterRole;

    Actor actor;
    Act act;
    com.wordsum.read.models.story.character.indicator.Object object;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getNarrator() {
        return narrator;
    }

    public void setNarrator(Integer narrator) {
        this.narrator = narrator;
    }

    public String getCharacterRole() {
        return characterRole;
    }

    public void setCharacterRole(String characterRole) {
        this.characterRole = characterRole;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
