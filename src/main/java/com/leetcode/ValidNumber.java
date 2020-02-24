package com.leetcode;

/*
 * Created by piyush_sagar on 11/18/19.
 */
public class ValidNumber {
    public static void main(String[] args) {

        String in = "1 ";
        System.out.println(isNumber(in));
    }

    static public boolean isNumber(String s) {
        String arr[] = s.split("e");
        if (arr.length > 2 || (s.indexOf('e') != -1 && arr.length == 1) || arr.length <= 0)
            return false;
        for (String part: arr) {
            if (!isValid(part))
                return false;
        }
        return true;
    }

    static boolean isValid(String s) {
        if (s.length() > 0) {
            if (s.charAt(0) == '-')
                s = s.substring(1);
            String arr[] = s.split("\\.");
            if (arr.length == 0)
                return false;
            for (String part: arr) {
                int len = part.length();
                for (int i=0; i<len;  i++) {
                    if (part.charAt(i) < '0' || part.charAt(i) > '9') {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
