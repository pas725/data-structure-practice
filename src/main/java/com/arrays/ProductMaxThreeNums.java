package com.arrays;

/**
 * Created by psagar on 9/3/2017.
 */
public class ProductMaxThreeNums {
    public static void main(String[] args) {
        int arr[] = {-4,-3,-2,-1,60};
        System.out.println(maximumProduct(arr));
    }

    public static int maximumProduct(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = first;
        int third = first;

        for(int i=0;i<nums.length;i++) {
            int tmpNum = Math.abs(nums[i]);
            tmpNum = nums[i];
            if(tmpNum > first){
                third = second;
                second = first;
                first = tmpNum;
            } else if (tmpNum > second) {
                third = second;
                second = tmpNum;
            } else if(tmpNum> third){
                third = tmpNum;
            }
        }

        return (first* (second*third));
    }
}
