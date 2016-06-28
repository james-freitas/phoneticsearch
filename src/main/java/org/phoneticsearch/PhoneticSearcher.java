package org.phoneticsearch;

import org.phoneticsearch.analyser.PhonemeAnalyser;
import org.phoneticsearch.sanetize.WordCleaner;

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
        PhonemeAnalyser analyser = new PhonemeAnalyser();

        List<String> wordMatches = new ArrayList<>();
        for (String word : words) {
            wordMatches.clear();
            wordMatches = analyser.getEquivalentWordsFromDictionary(word, dictionaryWords);
            inputWordsAndMatchesFromDictionary.put(word, new ArrayList<>(wordMatches));
        }
    }

   /* private List<String> prepareWords() {
        WordCleaner cleaner = new WordCleaner();
        return cleaner.sanetizeWordList(inputWords.stream().collect(Collectors.toList()));
    }*/

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
