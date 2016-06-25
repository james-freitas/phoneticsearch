package org.phoneticsearch;

import java.util.stream.IntStream;

/**
 * Created by james on 22/06/16.
 */
public class PhoneticSearcher {

    public static void main(String[] args) {

        String s = "abcd";

        char[] chars1 = s.toCharArray();


        IntStream chars = s.chars();


        String t = "aabb123cc";
        //String result = t.replaceAll("[^a-zA-Z]+", "");

        //t.replaceAll("[^a-zA-Z]+", "").equals("aabbcc");

        System.out.println(t.replaceAll("[^a-zA-Z]+", "").equals("aabbcc"));

    }
}
