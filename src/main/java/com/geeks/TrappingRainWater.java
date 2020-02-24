package com.geeks;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 3/27/19.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = {1};
        int res = trap(arr);
        System.out.println(res);
    }

    public static int trap(int[] height) {

        int len = height.length;
        int l2r[] = new int[len];
        int r2l[] = new int[len];

        int max = 0;
        for (int i=0; i<len; i++) {
            if (height[i] > max)
                max = height[i];
            l2r[i] = max;
        }

        max = 0;
        for (int i=len-1; i>=0; i--) {
            if (height[i] > max)
                max = height[i];
            r2l[i] = max;
        }

        int sum = 0;
        for (int i=0; i<len; i++) {
            sum += Math.min(l2r[i], r2l[i]) - height[i];
        }
        //Arrays.so
        return sum;
    }
}
