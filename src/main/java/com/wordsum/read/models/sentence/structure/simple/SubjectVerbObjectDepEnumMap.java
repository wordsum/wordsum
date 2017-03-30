package com.wordsum.read.models.sentence.structure.simple;

import java.util.ArrayList;

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
 * This class is an EnumMap of a Subject Verb Object sentence
 * using wordprostitute mlp state.
 * <p>
 * <p>
 * <p>
 * *****************
 * Subject Verb  Object v1: What seems like the basic sentence.
 * *****************
 * "reln" {"tag"} = "root"
 * "dep" {"tag"} = "VBP" "VBD"
 * <p>
 * "reln" {"tag"} = "nsubj"
 * "dep" {"tag"} = "PRP"
 * <p>
 * "reln": {"tag"} = "dobj"
 * "dep": {tag"} = "NNS" "NN"
 * or
 * <p>
 * "reln" {"tag"} = "nmod:*
 * "dep" {"tag"} = "NN",
 * <p>
 * *****************
 * Subject Verb  Object v2: If root is not marked as a verb
 * *****************
 * (If root is not a verb)
 * "reln": {"tag"} = "root"
 * "dep": {"tag"} = "NNS"
 * and
 * "reln" {"tag"} = "compound"
 * "dep": {"tag"} = "NNP",
 * then Subject is
 * "dep" {"word"}
 */
public class SubjectVerbObjectDepEnumMap {

    public enum SubjectVerbObject_1 {
        Subject("reln","nsubj","dep","PRP"),
        Verb("reln","root","dep","VBD"),
        Object("reln","dobj","dep","NN");

        String reln;
        String relnTag;
        String dep;
        String depTag;
        ArrayList<String> array = new ArrayList<>();


        SubjectVerbObject_1(String reln, String relnTag, String dep, String depTag) {
            this.reln = reln;
            this.relnTag = relnTag;
            this.dep = dep;
            this.depTag = depTag;
            this.array.add(0, this.reln);
            this.array.add(1, this.relnTag);
            this.array.add(2, this.dep);
            this.array.add(3, this.depTag);
        }

        public String getReln(){
            return this.reln;
        }


        public String getRelnTag(){
            return this.relnTag;
        }

        public String getDep(){
            return this.dep;
        }

        public String getDepTag(){
            return this.depTag;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }



    public enum SubjectVerbObject_2 {
        Subject("reln","nsubj","dep","PRP"),
        Verb("reln","root","dep","VBP"),
        Object("reln","dobj","dep","NN");

        String reln;
        String relnTag;
        String dep;
        String depTag;
        ArrayList<String> array = new ArrayList<>();


        SubjectVerbObject_2(String reln, String relnTag, String dep, String depTag) {
            this.reln = reln;
            this.relnTag = relnTag;
            this.dep = dep;
            this.depTag = depTag;
            this.array.add(0, this.reln);
            this.array.add(1, this.relnTag);
            this.array.add(2, this.dep);
            this.array.add(3, this.depTag);
        }

        public String getReln(){
            return this.reln;
        }


        public String getRelnTag(){
            return this.relnTag;
        }

        public String getDep(){
            return this.dep;
        }

        public String getDepTag(){
            return this.depTag;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

    public enum SubjectVerbObject_3 {
        Subject("reln","nsubj","dep","NNP"),
        Verb("reln","root","dep","VBZ"),
        Object("reln","dobj","dep","NN");

        String reln;
        String relnTag;
        String dep;
        String depTag;
        ArrayList<String> array = new ArrayList<>();


        SubjectVerbObject_3(String reln, String relnTag, String dep, String depTag) {
            this.reln = reln;
            this.relnTag = relnTag;
            this.dep = dep;
            this.depTag = depTag;
            this.array.add(0, this.reln);
            this.array.add(1, this.relnTag);
            this.array.add(2, this.dep);
            this.array.add(3, this.depTag);
        }

        public String getReln(){
            return this.reln;
        }


        public String getRelnTag(){
            return this.relnTag;
        }

        public String getDep(){
            return this.dep;
        }

        public String getDepTag(){
            return this.depTag;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }



    public enum SubjectVerbObject_4 {
        Subject("reln","nsubj","dep","NNP"),
        Verb("reln","root","dep","VBD"),
        Object("reln","dobj","dep","NN");

        String reln;
        String relnTag;
        String dep;
        String depTag;
        ArrayList<String> array = new ArrayList<>();


        SubjectVerbObject_4(String reln, String relnTag, String dep, String depTag) {
            this.reln = reln;
            this.relnTag = relnTag;
            this.dep = dep;
            this.depTag = depTag;
            this.array.add(0, this.reln);
            this.array.add(1, this.relnTag);
            this.array.add(2, this.dep);
            this.array.add(3, this.depTag);
        }

        public String getReln(){
            return this.reln;
        }


        public String getRelnTag(){
            return this.relnTag;
        }

        public String getDep(){
            return this.dep;
        }

        public String getDepTag(){
            return this.depTag;
        }

        public ArrayList<String> getArray(){
            return this.array;
        }

    }

}
