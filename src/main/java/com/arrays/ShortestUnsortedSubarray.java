package com.arrays;

/**
 * Created by psagar on 9/5/2017.
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class ShortestUnsortedSubarray {
    public static void main(String[] args) {
        int arr[] = {1,3,5,3,3,3};
        System.out.println(findUnsortedSubarray(arr));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high && nums[low] <= nums[low+1]){
            low++;
        }

        if (low == high) {
            return 0;
        }

        while (high > 0 && nums[high] > nums[high-1]) {
            high--;
        }

        int tmpHigh = high;
        int tmpHighNum = nums[tmpHigh];
        while(tmpHighNum == nums[tmpHigh]) {
            tmpHigh--;
        }

        if(nums[tmpHigh] < tmpHighNum) {
            high = tmpHigh;
        }

        return (high-low) +1;
    }
}
