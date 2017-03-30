package com.wordsum.read.models.sentence;

import java.util.ArrayList;
import java.util.EnumMap;
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

public class SentenceNlpDependencyEnumMap {
    enum Root {
        reln,
        dep;
    }

    enum NonRoot {
        reln,
        dep,
        gov;
    }

    static final ArrayList<String> relnKeys = new ArrayList<String>() {{
        add("tag");
    }};

    static final ArrayList<String> depKeys = new ArrayList<String>() {{
        add("lemma");
        add("tag");
        add("word");
    }};

    static final ArrayList<String> govKeys = new ArrayList<String>() {{
        add("lemma");
        add("tag");
        add("word");
    }};

    public static EnumMap<Root, ArrayList<String>> getRoot() {

        EnumMap<Root, ArrayList<String>> root = new EnumMap<>(Root.class);
        root.put(Root.reln, relnKeys );
        root.put(Root.dep, depKeys);

        return root;

    }

    public static EnumMap<NonRoot, ArrayList<String>> getNonRoot() {

        EnumMap<NonRoot, ArrayList<String>> nonRoot = new EnumMap<>(NonRoot.class);
        nonRoot.put(NonRoot.reln, relnKeys );
        nonRoot.put(NonRoot.dep, depKeys);
        nonRoot.put(NonRoot.gov, govKeys);
        return nonRoot;

    }

}
