package com.arrays;

import java.util.HashMap;

/**
 * Created by psagar on 8/30/2017.
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int res[] = twoSum(arr, 6);
        System.out.println("["+res[0]+", "+res[1]+"]");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];
        for(int i=0;i<nums.length ;i++) {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++) {
            int currentVal = nums[i];
            int expectedNum = target - currentVal;
            if(map.containsKey(expectedNum)) {
                int index = map.get(expectedNum);
                if (index != i) {
                    res[0] = i;
                    res[1] = index;
                    return res;
                }
            }
        }
        res[0] = res[1] = 0;
        return res;
    }
}
