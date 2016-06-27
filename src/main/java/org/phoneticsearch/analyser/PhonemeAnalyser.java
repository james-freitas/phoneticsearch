package org.phoneticsearch.analyser;


import org.phoneticsearch.rules.PhonemeRule;
import org.phoneticsearch.rules.PhonemeRuleCatalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhonemeAnalyser {

    private final List<String> dictionary = Arrays.asList(
            "angel",
            "brave",
            "Braev",
            "Don",
            "Engel",
            "go",
            "goal",
            "son",
            "sunny",
            "Tom",
            "Tooonnnnyyyy");


    public List<String> getPhoneticallyEquivalentWordsFromDictionary(String wordToCheck, String[] dictionary) {

        List<String> matchingWords = new ArrayList<>();

        for (String dictionaryWord : dictionary ) {
            if (isPhoneticallyEquivalent(wordToCheck, dictionaryWord)) {
                matchingWords.add(dictionaryWord);
            }
        }
        return matchingWords;
    }

    public boolean isPhoneticallyEquivalent(String sourceWord, String otherWord) {

        PhonemeRuleCatalog ruleCatalog = new PhonemeRuleCatalog();

        for(PhonemeRule rule : ruleCatalog.getAllPhonemeRules() ){
            if(rule.phonemMatches(sourceWord) && rule.phonemMatches(otherWord)) {
                return true;
            }
        }
        return false;
    }



}
