package org.phoneticsearch.analyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PhonemeAnalyserTest {

    private final Set<String> dictionary = new HashSet<>();

    @Before
    public void setUp() {
        dictionary.addAll( Arrays.asList(
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
                "Tooonnnnyyyy") );
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
        List<String> equivalentWords = phonemeAnalyser.getEquivalentWordsFromDictionary(givenWord, dictionary);

        Assert.assertTrue(equivalentWords.size() > 0);
    }
}
