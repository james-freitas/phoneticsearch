package org.phoneticsearch.searcher;

import org.phoneticsearch.analyser.PhonemeAnalyser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class PhoneticSearcher {

    private Set<String> inputWords = new HashSet<>();
    private Set<String> wordsFromDictionary = new HashSet<>();
    private Map<String, List<String>> inputWordsAndMatchesFromDictionary = new HashMap<>();
    private File dictionary;

    private static final Logger logger = Logger.getLogger( PhoneticSearcher.class.getName() );
    private static final PhonemeAnalyser phonemeAnalyser = new PhonemeAnalyser();


    public PhoneticSearcher(List<String> inputWords, File dictionary) {
        this.inputWords = inputWords.stream().collect(Collectors.toSet());
        this.dictionary = dictionary;
    }

    public Map<String,List<String>> getPhoneticallyEquivalentWords() {

        Set<String> dictionaryWords = getDictionaryWordsFromFile(dictionary);

        executePhoneticSearch(dictionaryWords, inputWords);

        return inputWordsAndMatchesFromDictionary;
    }

    private void executePhoneticSearch(Set<String> dictionaryWords, Set<String> words) {

        List<String> wordMatches = new ArrayList<>();
        for (String word : words) {
            wordMatches.clear();
            wordMatches = phonemeAnalyser.getEquivalentWordsFromDictionary(word, dictionaryWords);
            inputWordsAndMatchesFromDictionary.put(word, new ArrayList<>(wordMatches));
        }
    }


    public Set<String> getDictionaryWordsFromFile(File file) {
        try {
            Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8)
                 .forEach(wordsFromDictionary::add);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File path not found." );
        }
        return wordsFromDictionary;
    }

    public void printAllPhoneticallyEquivalentWords() {
        inputWordsAndMatchesFromDictionary.forEach((k,v) ->
                System.out.println(k + ": " + v.toString().replaceAll("[\\[\\]]+","")));
    }
}
