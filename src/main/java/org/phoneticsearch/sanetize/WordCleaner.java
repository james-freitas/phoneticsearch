package org.phoneticsearch.sanetize;


import java.util.List;
import java.util.stream.Collectors;

public class WordCleaner {

    private static final String nonAcceptedPattern = "[^a-zA-Z]";
    private static final String nonAcceptedPatternAfterFirstLetter = "[aAeEiIoOuUhHwWyY]+";

    public String removeNonAlphabeticalCharacters(String invalidWord) {
        return invalidWord.replaceAll(nonAcceptedPattern, "");
    }

    public String removeUndesiredLettersAfterFirstLetter(String wordWithUndesiredLetters) {
        StringBuilder result = new StringBuilder();
        result.append( wordWithUndesiredLetters.charAt(0) );

        String wordToClean = wordWithUndesiredLetters.substring(1, wordWithUndesiredLetters.length()-1);
        wordToClean = wordToClean.replaceAll(nonAcceptedPatternAfterFirstLetter, "");

        return result.append(wordToClean).toString();
    }

    public String sanetizeWord(String rawWord){
        rawWord = removeNonAlphabeticalCharacters(rawWord);
        rawWord = removeUndesiredLettersAfterFirstLetter(rawWord);
        return rawWord;
    }

    public List<String> sanetizeWordList(List<String> wordList){
        return wordList
                .stream()
                .map(s -> sanetizeWord(s))
                .collect(Collectors.toList());
    }
}
