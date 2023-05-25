package com.arrays;

/**
 * Created by psagar on 9/3/2017.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int nums[] = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i=0;i<k;i++) {
            sum += nums[i];
        }
        double iterationSum = sum;
        for(int j=k, i=0; j<nums.length; j++,i++) {
            iterationSum -= nums[i];
            iterationSum += nums[j];
            if( iterationSum > sum) {
                sum = iterationSum;
            }
        }
        double ans = sum / k;
        return ans;
    }
}

 class Xyz {

}