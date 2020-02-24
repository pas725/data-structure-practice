package com.leetcode;

/*
 * Created by piyush_sagar on 11/14/19.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int nums[] = {1000,-1};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    static int firstMissingPositive(int nums[]) {
        if (nums.length == 0)
            return 1;

        int negativeNums = shiftNegativeNumsToRight(nums);
        int len = nums.length - negativeNums;
        if (len == 0 || nums[0] <= 0)
            return 1;
        for (int i=0; i<len; i++) {
            int n = Math.abs(nums[i])-1;
            if (n < len && n>= 0 && nums[n] > 0) {
                nums[n] = -nums[n];
            }
        }

        for (int i=0; i<len; i++) {
            int n = nums[i];
            if (n >= 0) {
                return i+1;
            }
        }
        return len+1;
    }

    static int shiftNegativeNumsToRight(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        int cnt = 0;
        while (i<=j) {
            int num = nums[i];
            if (num <= 0 || num > nums.length) {
                int tmp = nums[j];
                nums[j] = num;
                nums[i] = tmp;
                j--;
                cnt++;
            } else {
                i++;
            }
        }
        return cnt;
    }
}
