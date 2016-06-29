package org.phoneticsearch.sanetize;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordCleanerTest {

    private final WordCleaner wordCleaner = new WordCleaner();

    @Test
    public void shouldRemoveAllNonAcceptedCharactersFromTheWord(){
        String invalidWord = "1don#";
        String cleanWord = wordCleaner.removeNonAlphabeticalCharacters(invalidWord);

        assertThat(cleanWord, is(equalTo("don")));
    }

    @Test
    public void shouldRemoveAllUndesiredCharactersAfterFirstLetter() {
        String wordWithUndesiredLetters = "abaAyy";

        String acceptedWord = wordCleaner.removeUndesiredLettersAfterFirstLetter(wordWithUndesiredLetters);

        assertThat(acceptedWord, is(equalTo("ab")));
    }

    @Test
    public void shouldSanetizeAWord(){
        String invalidWord = "1ton#";

        String accepteWord = wordCleaner.sanetizeWord(invalidWord);

        assertThat(accepteWord, is(equalTo("t")));
    }

}
