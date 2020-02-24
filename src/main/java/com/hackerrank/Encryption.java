package com.hackerrank;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * Created by piyush_sagar on 10/22/19.
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {
    public static void main(String[] args) {
        String s = "feedthedog";
        String res = encryption(s);
        System.out.println(res);
    }

    static String encryption(String s) {
        if (s == null || s.trim().length() == 0)
            return "";
        String spaces = s.chars().mapToObj(c -> (char) c).filter(i -> i != ' ')
                .collect(Collector.of(
                   StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));
        int L = spaces.length();
        int r = (int) Math.floor(Math.sqrt(L));
        int c = (int) Math.ceil(Math.sqrt(L));
        if ( r*c < L)
            r++;

        int runner = 0;
        char[][] arr = new char[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                //b.append(spaces.charAt(runner++));
                if (runner < spaces.length())
                    arr[i][j] = spaces.charAt(runner++);
            }
        }

        StringBuilder b = new StringBuilder();
        for(int col=0; col<c; col++) {
            for(int row=0; row<r; row++) {
                //b.append(spaces.charAt(runner++));
                char ch = arr[row][col];
                if (ch != 0)
                    b.append(ch);
            }
            b.append(" ");
        }


        return b.toString();
    }
}
