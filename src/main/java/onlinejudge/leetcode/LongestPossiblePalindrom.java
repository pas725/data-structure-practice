package onlinejudge.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 1/30/2018.
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000
 */
// https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPossiblePalindrom {


    public static void main(String[] args) {

        int res = longestPalindromeSubseq("aa");
        System.out.println(res);
    }

    public static int longestPalindromeSubseq(String s) {
        Map<String, Integer> hash = new HashMap<>();
        char[] string = s.toCharArray();
        return lps(string, 0, string.length-1, hash);
    }

    public static int lps(char[] string, int i, int j, Map<String, Integer> hash) {
        String index = i + "-" + j;
        if (hash.get(index) != null) {
            return hash.get(index);
        }
        if (i==j) {
            hash.put(index, 1);
            return 1;
        }

        if (string[i] == string[j] && (i+1) == (j)) {
            hash.put(index, 2);
            return 2;
        }

        if (string[i] == string[j]) {
            int res =  2 + lps(string, i+1, j-1, hash);
            hash.put(index, res);
            return res;
        }

        int res = Math.max(lps(string, i, j-1, hash), lps(string, i+1, j, hash));
        hash.put(index, res);
        return res;
    }
}
