package org.phoneticsearch;

import org.junit.Assert;
import org.junit.Test;
import org.phoneticsearch.sanetize.WordCleaner;


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

    private final char[] firstEquivalentPhonemes = {'A','E','I','O','U'};
    private final char[] secondEquivalentPhonemes = {'C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Y', 'Z'};
    private final char[] thirdEquivalentPhonemes = {'B', 'F', 'P', 'V', 'W'};
    private final char[] fourthEquivalentPhonemes = {'D','T'};
    private final char[] fifthEquivalentPhonemes = {'M', 'N'};

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
        String invalidWord = "aabb999ccc";

        WordCleaner wordCleaner = new WordCleaner();
        String validWord = wordCleaner.removeNonAlphabeticalCharacters(invalidWord);

        Assert.assertEquals(validWord, "aabbccc");
    }

    @Test
    public void shouldReturnTrueIfUndesiredCharactersAfterFirstLetterWereRemoved() throws Exception {
        String wordWithUndesiredLetters = "abaAyy";

        WordCleaner wordCleaner = new WordCleaner();
        String acceptedWord = wordCleaner.removeUndesiredLettersAfterFirstLetter(wordWithUndesiredLetters);

        Assert.assertEquals(acceptedWord,"ab");
    }



}
