package org.phoneticsearch.searcher;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Map<String, List<String>> equivalentWordsMap = phoneticSearcher.getPhoneticallyEquivalentWords();
        assertThat(equivalentWordsMap.size(), is(equalTo(3)));

        List<String> equivalentWordsList = equivalentWordsMap.get("1ton#");
        assertThat(equivalentWordsList.size(), is(equalTo(3)));
        assertThat(equivalentWordsList, hasItems("Don", "Tom", "Tooonnnnyyyy"));

        equivalentWordsList = equivalentWordsMap.get("brief");
        assertThat(equivalentWordsList.size(), is(equalTo(2)));
        assertThat(equivalentWordsList, hasItems("brave", "Braev"));

        equivalentWordsList = equivalentWordsMap.get("soon");
        assertThat(equivalentWordsList.size(), is(equalTo(4)));
        assertThat(equivalentWordsList, hasItems("son", "sunny", "go", "goal"));

    }
}
