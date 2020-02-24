package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by piyush_sagar on 11/9/19.
 */
public class RomanToInt {
    public static void main(String[] args) {
        String roman = "LVIII";
        int res = romanToInt(roman);
        System.out.println(res);

        char arr[] = roman.toCharArray();
        res = permute(arr, 0, arr.length);
        System.out.println(res);
    }

    static Map<String, Integer> m = new HashMap<>();

    static {
        m.put("IV", 4);
        m.put("IX", 9);
        m.put("XC", 90);
        m.put("CD", 400);
        m.put("CM", 900);
        m.put("XL", 40);
        m.put("I", 1);
        m.put("V", 5);
        m.put("X", 10);
        m.put("L", 50);
        m.put("C", 100);
        m.put("D", 500);
        m.put("M", 1000);
    }

    private static int romanToInt(String in) {


        int i = 0;
        int len = in.length();
        int sum = 0;
        while (i<len) {
            String s;
            boolean found = false;
            if (i + 1 < len) {
                s = in.substring(i, i+2);
                Integer t = m.get(s);
                if (t != null) {
                    sum += t;
                    found = true;
                    i++;
                }
            }

            if (!found) {
                s = in.substring(i, i+1);
                sum += m.get(s);
            }
            i++;
        }
        return sum;
    }

    static int permute(char[] arr, int i, int n) {
        if (i<n) {
            String s;
            if (i + 1 < n) {
                s = String.valueOf(arr[i] + arr[i + 1]);
                if (m.containsKey(s)) {
                    return m.get(s) + permute(arr, i + 2, n);
                }
            }
            s = String.valueOf(arr[i]);
            return m.get(s) + permute(arr, i + 1, n);
        }
        return 0;
    }
}
