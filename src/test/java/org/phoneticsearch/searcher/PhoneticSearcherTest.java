package org.phoneticsearch.searcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneticSearcherTest {


    private PhoneticSearcher phoneticSearcher;

    @Before
    public void setUp() {

        List<String> inputWords = new ArrayList<>();
        inputWords.add("1ton#");
        inputWords.add("brief");
        inputWords.add("soon");

        ClassLoader loader = getClass().getClassLoader();
        File dictionary = new File(loader.getResource("word_dict.txt").getFile());

        phoneticSearcher = new PhoneticSearcher(inputWords, dictionary);
    }


    @Test
    public void shouldGetEquivalentWordsFromDictionary() {
        Map<String, List<String>> equivalentWords = phoneticSearcher.getPhoneticallyEquivalentWords();

        System.out.println(equivalentWords);

        phoneticSearcher.printAllPhoneticallyEquivalentWords();

        Assert.assertTrue(equivalentWords.size() > 0);

    }
}
