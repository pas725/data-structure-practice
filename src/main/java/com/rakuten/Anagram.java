package com.rakuten;

import java.util.*;

/*
 * Created by piyush_sagar on 10/13/19.
 */
public class Anagram {

    public static void main(String[] args) {
        String s = "ABCECA";
        int res = solution(s);
        System.out.println(res);

        System.out.println("Efficent solution :" + solutionEfficient(s));
    }

    static long fact(int n) {
        if (n <= 1)
            return 1;
        int fact = 1;
        for (int i=1; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int solutionEfficient(String S) {
        int c[] = new int[26];
        int v[] = new int[26];
        int cLen = 0, vLen = 0;
        int len = S.length();
        for (int i=0; i<len; i++) {
            char ch = S.charAt(i);
            int  index = ch - 'A';
            if (isVowel(ch)) {
                v[index] += 1;
                vLen++;
            } else {
                c[index] += 1;
                cLen++;
            }
        }

        return (int) ( (fact(cLen)/uniqueFact(c)) * (fact(vLen)/uniqueFact(v)) ) % 1000000007;
    }

    private static long uniqueFact(int[] c) {
        int fact = 1;
        for(int i=0; i<26; i++) {
            fact *= fact(c[i]);
        }
        return fact;
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        StringBuilder consonants = new StringBuilder();
        StringBuilder vowels = new StringBuilder();
        int len = S.length();
        for (int i=0; i<len; i++) {
            char c = S.charAt(i);
            if (isVowel(c))
                vowels.append(c);
            else
                consonants.append(c);
        }

        if (consonants.length() == vowels.length() || consonants.length() == vowels.length() +1) {
            Set<String> set = new HashSet<>();
            permute("", consonants.toString(), vowels.toString(), set);
            return  set.size() % 1000000007;
        }
        return 0;
    }

    private static void permute(String res, String consonants, String vowels, Set<String> set) {
        if (consonants.length() == 0 || vowels.length() == 0) {
            set.add(res);
            return;
        }
        for (int i=0; i<consonants.length(); i++) {
            char c = consonants.charAt(i);
            String rC = consonants.substring(0, i) + consonants.substring(i + 1);
            for (int j=0; j<vowels.length(); j++) {
                char v = vowels.charAt(j);
                String rV = vowels.substring(0, j) + vowels.substring(j + 1);
                permute(res + c + v, rC, rV, set);
            }
        }
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E'
                || c == 'I' || c == 'O' || c == 'U';
    }
}
