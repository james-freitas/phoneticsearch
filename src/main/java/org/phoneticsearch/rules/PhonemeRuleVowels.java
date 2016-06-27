package org.phoneticsearch.rules;


public class PhonemeRuleVowels implements PhonemeRule{

    private final String pattern = "[\\{A,a,E,e,I,i,O,o,U,u\\}]";

    @Override
    public boolean phonemMatches(String wordToCheck) {

        String partial = wordToCheck.substring(0,1);
        return partial.matches(pattern);
    }
}
