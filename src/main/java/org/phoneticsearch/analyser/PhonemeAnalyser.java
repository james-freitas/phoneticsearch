package org.phoneticsearch.analyser;


import org.phoneticsearch.rules.PhonemeRule;
import org.phoneticsearch.rules.PhonemeRuleCatalog;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhonemeAnalyser {


    public List<String> getPhoneticallyEquivalentWordsFromDictionary(String wordToCheck, Set<String> dictionary) {

        //List<String> matchingWords = new ArrayList<>();

        List<String> matchingWords = dictionary.stream()
                .filter(dictionaryWord -> isPhoneticallyEquivalent(wordToCheck, dictionaryWord))
                .collect(Collectors.toList());

        /*for (String dictionaryWord : dictionary ) {
            if (isPhoneticallyEquivalent(wordToCheck, dictionaryWord)) {
                matchingWords.add(dictionaryWord);
            }
        }*/
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
