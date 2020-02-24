package com.geeks.recursive;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by piyush_sagar on 8/7/19.
 */
public class BracketsPermutation {
    public static void main(String[] args) {

        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, 3);
        //printBrackets(3, "", "");
    }



    // Correct SOLUTION
    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            System.out.println(cur);
            //ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    private static void printBrackets(int n, String l, String r) {
        if (n <= 1) {
            System.out.println(l + "()" + r);
            return;
        }

        printBrackets(n-1, "()"+l,r);
        printBrackets(n-1, "("+l,r + ")");
    }
}
