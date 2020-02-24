package com.hackerrank;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 10/22/19.
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
public class BiggerIsGreater {

    public static void main(String[] args) {
        String s = "zzyyxxxxxwwwwwvvvvutttttsssssrrrrqqqppponnnnmmmmllkkjjjjiiggffffffeedddddbbbbbba"; // hcdk
        String res = biggerIsGreater(s);
        System.out.println(res);
    }

    static String biggerIsGreater(String w) {
        if (w == null || w.trim().length() == 0)
            return "no answer";

        int len = w.length();
        char[] arr = w.toCharArray();
        int i = len-1;
        while (i > 0 && arr[i] <= arr[i-1])
            i--;

        if (i <= 0)
            return "no answer";

        int j = len-1;
        while (arr[j] <= arr[i-1])
            j--;

        char tmp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = tmp;

        Arrays.sort(arr, i, arr.length);
        return String.valueOf(arr);
    }

    static String biggerIsGreater2(String w) {
        if (w == null || w.trim().length() == 0)
            return "no answer";

        int len = w.length();
        char[] arr = w.toCharArray();
        int i = len-1;
        for (; i>0; i--) {
            if (arr[i] > arr[i-1])
                break;
        }

        int greatest = i;
        if (i+1 < arr.length) {
            greatest = findGreatest(arr, i + 1, arr[i-1]);
            if (arr[greatest] == arr[i])
                return "no answer";
        }

        if (i <= 0)
            return "no answer";

        char tmp = arr[greatest];
        arr[greatest] = arr[i-1];
        arr[i-1] = tmp;

        Arrays.sort(arr, i, arr.length);
        return String.valueOf(arr);
    }

    private static int findGreatest(char[] arr, int start, char c) {
        int len = arr.length;
        int min = start;
        for (int i=start; i<len; i++) {
            if (arr[i] < arr[min] && arr[i] > c)
                min = i;
        }
        return min;
    }
}
