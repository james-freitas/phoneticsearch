package org.phoneticsearch.rules;


import java.util.Arrays;
import java.util.List;

public class PhonemeRuleCatalog {

    private static List<PhonemeRule> rules;

    static {
        rules = Arrays.asList(
            new PhonemeRuleVowels(),
            new PhonemeRuleConsonantFirst(),
            new PhonemeRuleConsonantSecond(),
            new PhonemeRuleConsonantThird(),
            new PhonemeRuleConsonantFourth()
        );
    }

    public List<PhonemeRule> getAllPhonemeRules() {
        return rules;
    }

}
