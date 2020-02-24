package com.sort;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 9/5/19.
 */
public class StringSort {
    public static void main(String[] args) {
        String arr[] = {"9", "93", "24", "6"};

        Arrays.sort(arr, (s1, s2) -> {
            String xy = s1 + s2;
            String yx = s2 + s1;
            return yx.compareTo(xy);
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
