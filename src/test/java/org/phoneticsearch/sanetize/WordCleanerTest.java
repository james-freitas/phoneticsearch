package org.phoneticsearch.sanetize;


import org.junit.Assert;
import org.junit.Test;

public class WordCleanerTest {



    @Test
    public void shouldReturnTrueIfAllNonAcceptedCharactersWereRemoved(){
        String invalidWord = "1ton#";

        WordCleaner wordCleaner = new WordCleaner();
        String validWord = wordCleaner.removeNonAlphabeticalCharacters(invalidWord);

        Assert.assertEquals(validWord, "ton");
    }

    @Test
    public void shouldReturnTrueIfUndesiredCharactersAfterFirstLetterWereRemoved() {
        String wordWithUndesiredLetters = "abaAyy";

        WordCleaner wordCleaner = new WordCleaner();
        String acceptedWord = wordCleaner.removeUndesiredLettersAfterFirstLetter(wordWithUndesiredLetters);

        Assert.assertEquals(acceptedWord,"ab");
    }

}
