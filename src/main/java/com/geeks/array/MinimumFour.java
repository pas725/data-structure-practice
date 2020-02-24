package com.geeks.array;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 8/9/19.
 */
public class MinimumFour {
    public static void main(String[] args) {
        int arr[] = {5,3,8,2,9,1,2,0,11,55,33};
        int res[] = minFour(arr);

        System.out.println("Min elements : ");
        Arrays.stream(res).forEach(e -> System.out.print(" " + e));
    }

    private static int[] minFour(int[] arr) {
        int len = arr.length;
        if (len < 4)
            return new int[]{};

        int min1 = Integer.MAX_VALUE;
        int min2 = min1, min3 =min1, min4 = min1;

        for (int e : arr) {
            if (e < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = e;
            } else if (e < min2) {
                min4 = min3;
                min3 = min2;
                min2 = e;
            } else if (e < min3) {
                min4 = min3;
                min3 = e;
            } else if (e < min4) {
                min4 = e;
            }
        }
        return new int[]{min1, min2, min3, min4};
    }
}
