package com.geeks.strings;

/*
 * Created by piyush_sagar on 8/9/19.
 */
public class MaxPossiblePalindrom {
    public static void main(String[] args) {
        String str = "a???n";
        int res = maxPossiblePalindrom(str);
        System.out.println(res);
    }

    private static int maxPossiblePalindrom(String str) {
        int len = str.length();
        int i=0, j=len-1;

        int res = 1;
        while (i<=j) {

            if ((str.charAt(i) == '?' && str.charAt(j) == '?')) {
                res *= 26;
            } else if (str.charAt(i) != str.charAt(j) && str.charAt(i) != '?' && str.charAt(j) != '?') {
                return -1;
            }

            i++;
            j--;
        }
        return res;
    }
}
