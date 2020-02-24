package com.google;

/*
 * Created by piyush_sagar on 9/2/19.
 */
public class StringPermutation {
    public static void main(String[] args) {
        String s = "???";
        permute("", s, 0, s.length());
    }

    private static void permute(String out, String in, int i, int n) {
        if (i >= n) {
            System.out.println(out);
            return;
        }

        char c = in.charAt(i);
        if (c == '?') {
            permute(out + '0', in, i+1, n);
            permute(out + '1', in, i+1, n);
        } else {
            permute(out + c, in, i+1, n);
        }
    }
}
