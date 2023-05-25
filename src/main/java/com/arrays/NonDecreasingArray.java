package com.arrays;

/**
 * Created by psagar on 9/3/2017.
 * https://leetcode.com/problems/non-decreasing-array/description/
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int arr[] = {3,4,2,3};
        boolean res = isNonDecreasingArray(arr);
        System.out.println(res);
    }

    public static boolean isNonDecreasingArray(int nums[]) {
        int numNeedToModify = 0;
        int len = nums.length;
        for(int i=0; i<len; i++) {
            if (i<len-1) {
                if( nums[i] > nums[i+1]){
                    numNeedToModify++;
                }
            }
        }
        return numNeedToModify < 2;
    }
}
