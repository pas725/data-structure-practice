package com.arrays;

/**
 * Created by psagar on 9/7/2017.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDupFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,4,4,4,4,5};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int elementCount= 0;
        for (int i=0; i< nums.length ; i++) {
            int num = nums[i];
            int j= i+1;
            while (j < nums.length && num == nums[j]) {
                i=j;
                j++;
            }
            nums[elementCount] = num;
            elementCount++;
        }
        return elementCount;
    }

    public static int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for(int i=0; i<nums.length;i++) {
            if (nums[i] != val) {
                nums[currentIndex++] = nums[i];
            }
        }
        return currentIndex;
    }

    public static void moveZeroes(int[] nums) {
        int currentIndex = 0;
        int highIndex = nums.length -1;
        for(int i=0; i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[currentIndex++] = nums[i];
            }
        }

        while (currentIndex < nums.length) {
            nums[currentIndex++] = 0;
        }
    }
}
