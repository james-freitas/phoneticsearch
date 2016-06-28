package org.phoneticsearch.analyser;


import org.phoneticsearch.rules.PhonemeRule;
import org.phoneticsearch.rules.PhonemeRuleCatalog;
import org.phoneticsearch.sanetize.WordCleaner;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhonemeAnalyser {

    private static final WordCleaner wordCleaner = new WordCleaner();


    public List<String> getEquivalentWordsFromDictionary(String wordToCheck, Set<String> dictionary) {

        //List<String> matchingWords = new ArrayList<>();


        String cleanedWord = wordCleaner.sanetizeWord(wordToCheck);

        List<String> matchingWords = dictionary.stream()
                .filter(dictionaryWord -> isPhoneticallyEquivalent(cleanedWord, dictionaryWord))
                .collect(Collectors.toList());

        if(matchingWords.isEmpty()) {
            return Collections.emptyList();
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
