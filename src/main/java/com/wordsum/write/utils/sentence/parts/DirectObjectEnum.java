package com.wordsum.write.utils.sentence.parts;

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

public enum DirectObjectEnum {


    NOUN_PERSON_PRO_SINGULAR_1("it"),
    NOUN_PERSON_PRO_SINGULAR_2("it and he"),
    NOUN_PERSON_PRO_SINGULAR_3("it, she and he"),
    NOUN_PERSON_PRO_SINGULAR_SERIALCOMMA_3("it, she, and he"),
    NOUN_PERSON_PRO_PLURAL_1("they"),
    NOUN_PERSON_PRO_PLURAL_2("they and those"),
    NOUN_PERSON_PRO_PLURAL_3("they, them and those"),
    NOUN_PERSON_PRO_PLURAL_SERIALCOMMA_3("they, them, and those"),
    NOUN_PERSON_PROPER_SINGULAR_1("Fred"),
    NOUN_PERSON_PROPER_SINGULAR_2("Fred and Jan"),
    NOUN_PERSON_PROPER_SINGULAR_3("Fred, Jan and Sara"),
    NOUN_PERSON_PROPER_SINGULAR_SERIALCOMMA_3("Fred, Jan, and Sara"),
    NOUN_PERSON_PROPER_SINGULAR_ARTICLE_1("Fred"),
    NOUN_PERSON_PROPER_SINGULAR_ARTICLE_2("The Fred and that Jan"),
    NOUN_PERSON_PROPER_SINGULAR_ARTICLE_3("This Fred, a Jan and the Dilbert"),
    NOUN_PERSON_PROPER_SINGULAR_ARTICLE_SERIALCOMMA_3("This Fred, a Jan, and the Dilbert"),
    NOUN_PERSON_PROPER_SINGULAR_ADJECTIVE_1("Tall Jill"),
    NOUN_PERSON_PROPER_SINGULAR_ADJECTIVE_2("Fast Jill and slow Jack"),
    NOUN_PERSON_PROPER_SINGULAR_ADJECTIVE_3("Tall Jill, short Jaci and fat Steve"),
    NOUN_PERSON_PROPER_SINGULAR_ADJECTIVE_SERIALCOMMA_3("Tall Jill, short Jaci, and fat Steve"),
    NOUN_PERSON_PROPER_PLURAL_1("Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_2("Democrats and Republicans"),
    NOUN_PERSON_PROPER_PLURAL_3("Democrats, Republicans and Communists"),
    NOUN_PERSON_PROPER_PLURAL_SERIALCOMMA_3("Democrats, Republicans and Communists"),
    NOUN_PERSON_PROPER_PLURAL_ARTICLE_1("The Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_ARTICLE_2("The Democrats and the Republicans"),
    NOUN_PERSON_PROPER_PLURAL_ARTICLE_3("The Democrats, these Republicans and those Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_ARTICLE_SERIALCOMMA_3("The Democrats, these Republicans, and those Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_ADJECTIVE_1("Secret Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_ADJECTIVE_2("Losing Democrats and winning Republicans"),
    NOUN_PERSON_PROPER_PLURAL_ADJECTIVE_3("Big Democrats, quick Republicans and slow Illuminati"),
    NOUN_PERSON_PROPER_PLURAL_ADJECTIVE_SERIALCOMMA_3("Big Democrats, quick Republicans, and slow Illuminati"),
    //PLACES
    NOUN_PLACE_SINGULAR_1("farm"),
    NOUN_PLACE_SINGULAR_2("farm and home"),
    NOUN_PLACE_SINGULAR_3("farm, home and field"),
    NOUN_PLACE_SINGULAR_SERIALCOMMA_3("farm, home, and field"),
    NOUN_PLACE_SINGULAR_ARTICLE_1("the farm"),
    NOUN_PLACE_SINGULAR_ARTICLE_2("the palace and the home"),
    NOUN_PLACE_SINGULAR_ARTICLE_3("the farm, the palace and the river"),
    NOUN_PLACE_SINGULAR_ARTICLE_SERIALCOMMA_3("the farm, the palace, and the river"),
    NOUN_PLACE_SINGULAR_ADJECTIVE_1("big farm"),
    NOUN_PLACE_SINGULAR_ADJECTIVE_2("large palace and dirty home"),
    NOUN_PLACE_SINGULAR_ADJECTIVE_3("dirty farm, pretty palace and big river"),
    NOUN_PLACE_SINGULAR_ADJECTIVE_SERIALCOMMA_3("large farm, small palace, and narrow river"),
    NOUN_PLACE_SINGULAR_MIXED_2("large palace and a home"),
    NOUN_PLACE_SINGULAR_MIXED_3("dirty farm, the palace and a river"),
    NOUN_PLACE_SINGULAR_MIXED_SERIALCOMMA_3("large farm, the palace, and a river"),
    NOUN_PLACE_PLURAL_1("farms"),
    NOUN_PLACE_PLURAL_2("farms and homes"),
    NOUN_PLACE_PLURAL_3("farms, homes and fields"),
    NOUN_PLACE_PLURAL_SERIALCOMMA_3("farms, homes, and fields"),
    NOUN_PLACE_PLURAL_ARTICLE_1("the farms"),
    NOUN_PLACE_PLURAL_ARTICLE_2("the palaces and the homes"),
    NOUN_PLACE_PLURAL_ARTICLE_3("the farms, the palaces and the rivers"),
    NOUN_PLACE_PLURAL_ARTICLE_SERIALCOMMA_3("the farms, the palaces, and the rivers"),
    NOUN_PLACE_PLURAL_ADJECTIVE_1("big farms"),
    NOUN_PLACE_PLURAL_ADJECTIVE_2("large palaces and dirty homes"),
    NOUN_PLACE_PLURAL_ADJECTIVE_3("dirty farms, pretty palaces and big rivers"),
    NOUN_PLACE_PLURAL_ADJECTIVE_SERIALCOMMA_3("large farms, small palaces, and narrow rivers"),
    NOUN_PLACE_PLURAL_MIXED_2("large palaces and small homes"),
    NOUN_PLACE_PLURAL_MIXED_3("dirty farms, the palaces and the rivers"),
    NOUN_PLACE_PLURAL_MIXED_SERIALCOMMA_3("large farms, the palaces, and the rivers"),
    //THINGS
    NOUN_THING_SINGULAR_1("book"),
    NOUN_THING_SINGULAR_2("book and poem"),
    NOUN_THING_SINGULAR_3("book, poem and story"),
    NOUN_THING_SINGULAR_SERIALCOMMA_3("book, poem, and story"),
    NOUN_THING_SINGULAR_ARTICLE_1("the book"),
    NOUN_THING_SINGULAR_ARTICLE_2("the book and the poem"),
    NOUN_THING_SINGULAR_ARTICLE_3("a book, the poem and this story"),
    NOUN_THING_SINGULAR_ARTICLE_SERIALCOMMA_3("a book, the poem, and the story"),
    NOUN_THING_SINGULAR_ADJECTIVE_1("short book"),
    NOUN_THING_SINGULAR_ADJECTIVE_2("dense book and dumb story"),
    NOUN_THING_SINGULAR_ADJECTIVE_3("new book, used poem and big story"),
    NOUN_THING_SINGULAR_ADJECTIVE_SERIALCOMMA_3("new book, used poem and big story"),
    NOUN_THING_PLURAL_1("books"),
    NOUN_THING_PLURAL_2("books and poems"),
    NOUN_THING_PLURAL_3("books, poems and stories"),
    NOUN_THING_PLURAL_SERIALCOMMA_3("books, poems, and stories"),
    NOUN_THING_PLURAL_ARTICLE_1("the books"),
    NOUN_THING_PLURAL_ARTICLE_2("the books and the poems"),
    NOUN_THING_PLURAL_ARTICLE_3("those books, those poems and these stories"),
    NOUN_THING_PLURAL_ARTICLE_SERIALCOMMA_3("these books, the poems, and the storys"),
    NOUN_THING_PLURAL_ADJECTIVE_1("short books"),
    NOUN_THING_PLURAL_ADJECTIVE_2("dense books and dumb stories"),
    NOUN_THING_PLURAL_ADJECTIVE_3("new book, used poem and big stories"),
    NOUN_THING_PLURAL_ADJECTIVE_SERIALCOMMA_3("new book, used poem and big stories");


    String object;
    ArrayList<String> objects = new ArrayList<>();


    DirectObjectEnum(String object) {
        this.object = object;
        this.objects.add(0, this.object);
    }

    public String getObject() {
        return object;
    }

    public ArrayList<String> getObjects() {
        return this.objects;
    }

}
