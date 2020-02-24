package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by piyush_sagar on 11/9/19.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String in = "tmmzuxt";
        int res = lengthOfLongestSubstring(in);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0; int start = 0;
        int n = s.length(); int runner = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && runner < n) {
            char c = s.charAt(runner);
            if (set.contains(c)) {
                while (start != runner ) {
                    char t = s.charAt(start++);
                    set.remove(t);
                    if (t == c)
                        break;
                }
            }
            set.add(c);
            runner++;
            int cLen = runner - start ;
            if ( cLen > max)
                max = cLen;
        }
        return max;
    }
}
