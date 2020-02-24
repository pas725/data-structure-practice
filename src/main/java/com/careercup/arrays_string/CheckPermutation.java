package com.careercup.arrays_string;

/*
 * Created by piyush_sagar on 3/15/19.
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        String s1  = "abcdef";
        String s2  = "aefdbc";

        boolean isPermuted = checkPermutation(s1.toCharArray(), s2.toCharArray());
        System.out.println(isPermuted);
    }

    private static boolean checkPermutation(char[] c1, char[] c2) {
        if (c1.length != c2.length)
            return false;

        int[] cnt = new int[26];
        for(char c: c1) {
            cnt[c-'a']++;
        }

        for (char d: c2) {
            cnt[d-'a']--;
            if (cnt[d-'a'] < 0)
                return false;
        }
        return true;
    }


}
