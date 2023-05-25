package com.arrays;

import java.util.Arrays;

/**
 * Created by psagar on 9/12/2017.
 * https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {1,2,0};
        nextPermutation(arr);
        print(arr);
    }

    public static void nextPermutation(int[] nums) {
        int min = nums.length-1;
        for(int i=nums.length-1;i>=0;i--) {
            if(i==0)
                break;

            if (nums[i] > nums[i-1]) {
                int tmp = nums[min];
                nums[min] = nums[i-1];
                nums[i-1] = tmp;
                return;
            } else {
                if(nums[i] < nums[min] ) {
                    min = i;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void print(int arr[]) {
        System.out.println("Array : ");
        for(int val : arr) {
            System.out.print(" "+val);
        }
    }
}
