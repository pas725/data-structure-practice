package com.arrays;

/**
 * Created by psagar on 9/6/2017.
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int arr[] = {1,3,1,3,4,2,1,1};
        int k=4;
        System.out.println(subarraySum(arr,k));
    }

    public static int subarraySum(int[] nums, int k) {
        int arrLen = nums.length;
        int count = 0;
        for(int i=0; i<arrLen ; i++) {
            int num = nums[i];
            if (num == k) {
                count++;
            }

            if( i != arrLen-1) {
                int j = i+1;
                int sum = num;
                while( j<arrLen && sum < k) {
                    sum += nums[j++];
                    if (sum == k){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
