package com.leetcode;

/*
 * Created by piyush_sagar on 9/19/19.
 */
public class StringPatternMatch {
    public static void main(String[] args) {
        String s = "adcebj";
        String p = "*a*b";

        System.out.println(isMatch(s, p));

        System.out.println("Recursive : " + isMatch(s, p, 0, 0));
    }

    public static boolean isMatch(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length())
            return true;

        if (i >= s.length())
            return false;

        if (j >= p.length())
            return false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return isMatch(s, p, i+1, j+1);
        else if (p.charAt(j) == '*')
            return isMatch(s, p, i+1, j) || isMatch(s, p, i, j+1);

        return false;
    }

    public static boolean isMatch(String s, String p) {

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int col=1; col<= p.length(); col++) {
            if (p.charAt(col-1) == '*') {
                dp[0][col] = dp[0][col-1];
            }
        }

        for (int row=1; row<= s.length(); row++) {
            for (int col=1; col<= p.length(); col++) {

                char s1 = s.charAt(row-1);
                char p1 = p.charAt(col-1);

                if (s1 == p1 || p1 == '?') {
                    dp[row][col] = dp[row-1][col-1];
                } else if (p1 == '*') {
                    dp[row][col] =  dp[row-1][col] || dp[row][col-1];
                } else {
                    dp[row][col] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
