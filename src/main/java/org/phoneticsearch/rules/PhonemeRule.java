package org.phoneticsearch.rules;


public interface PhonemeRule {

    boolean phonemMatches(String wordToCheck);

}
