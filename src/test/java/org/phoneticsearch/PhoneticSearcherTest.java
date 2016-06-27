package org.phoneticsearch;

import org.junit.Assert;
import org.junit.Test;
import org.phoneticsearch.analyser.PhonemeAnalyser;
import org.phoneticsearch.sanetize.WordCleaner;

import java.util.List;


/**
 * 1. Todo caracter não alfabético deve ser ignorado
 *
 * 2. Não deve haver diferença entre letras minúsculas e maiúsculas
 *
 * 3. Depois da primeira letra, qualquer uma das seguintes letras devem ser
 descartadas: A, E, I, H, O, U, W, Y.
 *
 * 4. Os seguintes conjuntos de letras são considerados equivalentes:
 {A, E, I, O, U}
 {C, G, J, K, Q, S, X, Y, Z}
 {B, F, P, V, W}
 {D, T}
 {M, N}
 Todas as outras letras não tem equivalente

 5. Quaisquer ocorrências consecutivas de letras equivalentes (depois de descartas as
 letras no passo 3) são consideradas como uma ocorrência única.
 *
 */
public class PhoneticSearcherTest {

    private final String[] dictionary = {
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
            "Tooonnnnyyyy"
    };

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

    @Test
    public void shouldReturnTrueIfTwoWordsArePhoneticallyEquivalent() {
        String sourceWord = "allgood";
        String targetWord = "allcool";

        PhonemeAnalyser analyser = new PhonemeAnalyser();

        Assert.assertTrue(analyser.isPhoneticallyEquivalent(sourceWord, targetWord));
    }

    @Test
    public void shouldReturnTrueIfAWordHasEquivalentsPhoneticallyFromDictionary() {
        String givenWord = "soon";

        PhonemeAnalyser phonemeAnalyser = new PhonemeAnalyser();
        List<String> equivalentWords = phonemeAnalyser.getPhoneticallyEquivalentWordsFromDictionary(givenWord, dictionary);

        Assert.assertTrue(equivalentWords.size() > 0);

    }
}
