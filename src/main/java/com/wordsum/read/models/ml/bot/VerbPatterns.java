package com.wordsum.read.models.ml.bot;



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
 * A class of enums to generate verbs for bot questions and commands.
 */
public class VerbPatterns {


    public enum BeVerb {

        Apostrophe_S("'s"),
        Apostrophe_RE("'re"),
        Is("is"),
        Be("be"),
        Has("has"),
        Are("are");


        String variation;


        BeVerb(String variation) {
            this.variation = variation;
        }

        public String getVariation(){
            return this.variation;
        }



    }

    public enum DoVerb {

        Do("do"),
        Done("done"),
        Did("did");


        String variation;


        DoVerb(String variation) {
            this.variation = variation;
        }

        public String getVariation(){
            return this.variation;
        }



    }



    public enum CapabilityVerb {

        Can("can"),
        Will("will"),
        Could("could"),
        Might("might");


        String variation;


        CapabilityVerb(String variation) {
            this.variation = variation;
        }

        public String getVariation(){
            return this.variation;
        }



    }


    public enum GetVerb {

        Get("get"),
        Give("give"),
        Find("find"),
        Has("has");


        String variation;


        GetVerb(String variation) {
            this.variation = variation;
        }

        public String getVariation(){
            return this.variation;
        }



    }




}
