package com.hackerrank;

/*
 * Created by piyush_sagar on 11/3/19.
 * Given two strings s1, s2. output all the ways in which these two strings can be merged while keeping the order of character same as they were in s1, s2. Design a recursive algorithm.

Example : s1 : ab , s2: cd

Output :

abcd

acbd
 */
public class StringPermute {
    public static void main(String[] args) {

        String  a = "ab";
        String  b = "cd";
        permute("", a, b);

    }

    static void permute(String res, String a, String b) {
        if( a.length() == 0 &&  b.length() == 0) {
            System.out.println(res);
            return;
        }

        for (int i=0; i<a.length(); i++) {
            String tmp = a.substring(0, i+1);
            permute(res + tmp, a.substring(i+1), b);
        }

        for (int i=0; i<b.length(); i++) {
            String tmp = b.substring(0, i+1);
            permute(res + tmp, a, b.substring(i+1));
        }

    }
}
