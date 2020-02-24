package com.sort;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 9/18/19.
 */
public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {3,4,2,5,6,1,7,8,9,5,6,8,3,2,1,0,9};
        int res[] = countingSort(arr);

        Arrays.stream(res).forEach(e -> System.out.print(" " + e));
    }

    private static int[] countingSort(int[] arr) {
        int cnt[] = new int[10];

        for (int e : arr) {
            cnt[e] += 1;
        }

        for (int i=1; i<10; i++)
            cnt[i] += cnt[i-1];

        int out[] = new int[arr.length];
        for (int el : arr) {
            int index = cnt[el];
            cnt[el] -= 1;

            out[index-1] = el;
        }
        return out;
    }
}
