package com.cleo.revision.effectiveJava.item4;

public class SpellChecker {

    private Dictionary dictionary;

    public void spellCheckingInHindi(){
        dictionary = new HindiDictionary();

    }

    public void spellCheckingInEnglish(){
        dictionary = new EnglishDictionary();
    }
}
