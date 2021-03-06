package org.phoneticsearch.rules;

/**
 * Created by james on 26/06/16.
 */
public class PhonemeRuleConsonantFourth implements PhonemeRule {


    private final String pattern = "[\\{M,m,N,n\\}]";

    @Override
    public boolean phonemMatches(String wordToCheck) {

        String partial = wordToCheck.substring(0,1);
        return partial.matches(pattern);
    }
}
