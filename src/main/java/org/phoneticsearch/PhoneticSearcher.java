package org.phoneticsearch;

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
    private Map<String, List<String>> inputWordsAndTheirPhoneticallyEquivalentFromDictionary = new HashMap<>();
    private File dictionary;

    private static final Logger logger = Logger.getLogger( PhoneticSearcher.class.getName() );

    public PhoneticSearcher(List<String> inputWords, File dictionary) {
        this.inputWords = inputWords.stream().collect(Collectors.toSet());
        this.dictionary = dictionary;
    }

    public Map<String,List<String>> getPhoneticallyEquivalentWords() {

        Set<String> dictionaryWords = getDictionaryWordsFromFile(dictionary);
        List<String> wordMatches = new ArrayList<>();

        PhonemeAnalyser analyser = new PhonemeAnalyser();


        for (String word : inputWords) {
            wordMatches.clear();
            wordMatches = analyser.getPhoneticallyEquivalentWordsFromDictionary(word, dictionaryWords);
            if (wordMatches.isEmpty()) {
                inputWordsAndTheirPhoneticallyEquivalentFromDictionary.put(word, new ArrayList<>());
            } else {
                inputWordsAndTheirPhoneticallyEquivalentFromDictionary.put(word, new ArrayList<>(wordMatches));
            }
        }

        return inputWordsAndTheirPhoneticallyEquivalentFromDictionary;
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
}
