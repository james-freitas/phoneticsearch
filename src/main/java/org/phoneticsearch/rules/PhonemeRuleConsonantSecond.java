package org.phoneticsearch.rules;

/**
 * Created by james on 26/06/16.
 */
public class PhonemeRuleConsonantSecond implements PhonemeRule{

    private final String pattern = "[\\{B,b,P,p,V,v,W,w\\}]";

    @Override
    public boolean phonemMatches(String wordToCheck) {

        String partial = wordToCheck.substring(0,1);
        return partial.matches(pattern);
    }
}
