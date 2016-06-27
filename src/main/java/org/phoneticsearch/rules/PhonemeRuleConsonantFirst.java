package org.phoneticsearch.rules;

/**
 * Created by james on 26/06/16.
 */
public class PhonemeRuleConsonantFirst implements PhonemeRule{

    private final String pattern = "[\\{C,c,G,g,J,j,K,k,Q,q,S,s,X,x,Y,y,Z,z\\}]";

    @Override
    public boolean phonemMatches(String wordToCheck) {

        String partial = wordToCheck.substring(0,1);
        return partial.matches(pattern);
    }
}
