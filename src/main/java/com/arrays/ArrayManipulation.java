package com.arrays;

import java.util.*;


/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long arr[] = new long[n];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            performAction(arr, a, b, k);
        }
        in.close();
        //print(arr);
        System.out.println(findMax(arr));
    }

    public static void performAction(long[] arr,int from, int to, int val) {
        for(int i=(from-1) ; i<to ;i++) {
            arr[i] += val;
        }
    }

    public static long findMax(long arr[]) {
        long max = 0;
        for(long i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void print(int[] arr) {
        System.out.println("Array : ");
        for(int i : arr) {
            System.out.print(" "+i);
        }
    }
}

