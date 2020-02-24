package com.sort;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 9/18/19.
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {44,54,33,12,67,89,709,312,55,4321,98,87,8,900};
        radixSort(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(" " + e));
    }

    private static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int base =1; max/base > 0; base = base * 10) {
            countSort(arr, base);
        }
    }

    private static void countSort(int[] arr, int base) {
        int out[] = new int[arr.length];

        int cnt[] = new int[10];

        for (int el: arr)
            cnt[(el/base)%10] += 1;

        for (int i=1; i<10; i++)
            cnt[i] += cnt[i-1];

       for (int i= arr.length-1; i>=0 ;i--) {
           int el = arr[i];
           int index = cnt[(el/base)%10];
           cnt[(el/base)%10] -= 1;
           out[index-1] = el;
       }

       for (int i=0; i<arr.length; i++)
           arr[i] = out[i];
    }
}
