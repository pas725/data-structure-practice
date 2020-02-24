package com.google;

import java.util.List;

/*
 * Created by piyush_sagar on 9/18/19.
 */
public class RandomListIncreasing {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int length = arr.length;
        int k = 2;

        String res = generateRandom(arr, 0, length, k);
        System.out.println(res);
    }

    private static String generateRandom(int[] arr, int start, int end, int k) {
        if (k <= 0 || end <= 0 || k > end || start >= end)
            return "";

        int index =  start + (int) (Math.random() * (end - k - start));
        return "" + arr[index] + generateRandom(arr, index+1, end, k-1);
    }
}
