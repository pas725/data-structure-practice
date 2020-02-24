package com.geeks;

/*
 * Created by piyush_sagar on 3/27/19.
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        int res = maxArea2(arr);
        System.out.println(res);
    }

    public static int maxArea2(int[] arr) {
        int max = 0;
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            int con = (j-i) * (arr[i] < arr[j] ? arr[i] : arr[j]);
            if (con > max)
                max = con;

            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static int maxArea(int[] arr) {

        int len = arr.length;

        int max = 0;
        for (int i=0; i<len; i++) {
            for (int j=len-1; j>=i; j--) {
                if (arr[j] >= arr[i]) {
                    int con = (j-i) * Math.min(arr[i], arr[j]);
                    if (con > max)
                        max = con;
                    break;
                } else {
                    int con = (j-i) * Math.min(arr[i], arr[j]);
                    if (con > max)
                        max = con;
                }
            }
        }


        return max;
    }
}
