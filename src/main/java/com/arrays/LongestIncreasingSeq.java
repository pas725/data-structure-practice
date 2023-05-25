package com.arrays;

/**
 * Created by psagar on 9/16/2017.
 * https://leetcode.com/contest/leetcode-weekly-contest-49/problems/longest-continuous-increasing-subsequence/
 */
public class LongestIncreasingSeq {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7};
        System.out.println(findLengthOfLCIS(arr));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int count = 0;
        int len = nums.length;
        int tmpCount = 0;
        for(int i=0;i<len;i++) {
            if (i<len-1) {
                if (nums[i] < nums[i+1]) {
                    tmpCount++;
                } else {
                    tmpCount++;
                    count = Math.max(count, tmpCount);
                    tmpCount = 0;
                }
            } else {
                tmpCount++;
            }
        }
        return count = Math.max(count, tmpCount);
    }
}
