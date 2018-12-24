package com.wordsum.process.read.models.text;

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
 * And enum for a place to begin to define enums used by the builders to text.
 * <p/>
 * This will likely change but for now I don't want to think about the right place
 * for these.
 *
 * @author Kalab J. Oster
 */
public enum TextModelEnum {

    NARRATIVE_SENTENCE("(?!(.\\s+)''|'')([\\w*\\s\\.'!?,_-]*)(?<!'')"),

    DIALOG_CONTINUING_MARK_TO_NARRATOR(",\"\\s|,''\\s|,>\\s|,<\\s"),
    DIALOG_MARK_BEGIN("^''|^\"|^,,|^<|^>"),
    DIALOG_MARK_END("!''$|!\"$|!<$|!>$|\\?''$|\\?\"$|\\?<$|\\?>$|\\.''$|\\.\"$|\\.<$|\\.>$"),

    DIALOG_ENDING_MARK("\\?''\\s|\\.''\\s|!''\\s|\\.>\\s|\\?>\\s|!>\\s|\\.<\\s|\\?<\\s|!<\\s|!\"\\s|\\.\"\\s|\\?\"\\s"),
    DIALOG_BEGINNING_MARK("\\s,,|\\s''|(\\s<\\||\\s<)|\\s\"|(\\s>\\||\\s>)"),

    NARRATOR_CONTINUING_MARK_TO_DIALOG(",\\s>|,\\s<|,\\s>|,\\s<|,\\s''|,\\s,,|,\\s\""),
    NARRATOR_ENDING_MARK("!\\s|\\.\\s|\\?\\s|\\.$|!$|\\?$"),

    END("(" + DIALOG_MARK_END + "|" + NARRATOR_ENDING_MARK + "|" + DIALOG_ENDING_MARK + ")");

    String mark;

    TextModelEnum(String mark) {
        this.mark = mark;

    }

    public String get() {
        return mark;
    }

}