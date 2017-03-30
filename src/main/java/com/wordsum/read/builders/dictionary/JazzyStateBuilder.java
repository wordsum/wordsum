package com.wordsum.read.builders.dictionary;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;
import com.wordsum.read.models.dictionary.JazzyState;
import com.wordsum.publish.utils.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


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
 * Shoutout: This http://moderntone.blogspot.com/2013/02/tutorial-on-jazzy-spell-checker.html by Tom helped me code
 * jazzy.
 *
 * I want to make this static methods like other builders.
 *
 */

public class JazzyStateBuilder implements SpellCheckListener {

    private static Logger logger = LoggerFactory.getLogger(JazzyStateBuilder.class);
    private SpellChecker spellChecker;
    private List<String> dictionary;
    private SpellDictionaryHashMap spellDictionaryHashMap;

    public JazzyStateBuilder() throws Exception {
        dictionary = new ArrayList<String>();
        spellDictionaryHashMap = new SpellDictionaryHashMap(FileReader.readResourceFile("/dict/english.0"));
        spellChecker = new SpellChecker(spellDictionaryHashMap);
        spellChecker.addSpellCheckListener(this);
    }


    public JazzyState toJazzyState(String text) throws Exception {

        JazzyState jazzyState = new JazzyState();

        jazzyState.setText(text);

        jazzyState = map(jazzyState);

        return jazzyState;
    }

    public JazzyState map(JazzyState jazzyState) throws Exception {

        if (jazzyState.getText() == null || jazzyState.getText().isEmpty()) {
            throw new NullPointerException("JazzyStateBuilder map missing text.");
        }

        HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();

        List<String> misspelledWords = check(jazzyState.getText());

        for (String misspelledWord : misspelledWords) {

            List<String> suggestedWords = suggest(misspelledWord, 1);

            dictionary.put(misspelledWord.toString(), suggestedWords);

        }

        jazzyState.setMisspelledWords(dictionary);

        return jazzyState;
    }

    public List<String> check(String text) throws Exception {

        if (text == null) {
            logger.error("Jazzy Check needs a String that's not Null and needing one word or more than one word.");
            throw new NullPointerException("Jazzy Check needs a String that's not Null and needing one word or more than one word.");
        }

        if (text.isEmpty()) {
            logger.error("Jazzy Check needs a String that's not empty of one word or more than one word.");
            throw new IllegalArgumentException("Jazzy Check needs a String that's not empty of one word or more than one word.");
        }

        StringWordTokenizer texTok = new StringWordTokenizer(text);
        spellChecker.checkSpelling(texTok);

        return dictionary;
    }

    public void spellingError(SpellCheckEvent event) {
        event.ignoreWord(true);
        dictionary.add(event.getInvalidWord());
    }

    public List<String> suggest(String word, int threshold) {

        List<String> suggestions = new ArrayList<String>();

        spellChecker.getSuggestions(word, threshold);

        // We do this to make a a string object and not Word object.
        Iterator loop = spellChecker.getSuggestions(word, threshold).iterator();
        while (loop.hasNext()) {
            String element = loop.next().toString();
            suggestions.add(element);
        }

        return suggestions;

    }

}
