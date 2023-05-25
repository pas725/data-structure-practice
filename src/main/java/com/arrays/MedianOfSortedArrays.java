package com.arrays;

/**
 * Created by psagar on 9/11/2017.
 */
public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int arr2[] = {5,6,7,8};
        System.out.println(findMedianSortedArrays(arr, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int tmpArr[] = new int[len1+len2];

        int i = 0, j=0, k=0;
        while (i<len1 && j<len2) {
            if (nums1[i] < nums2[j]) {
                tmpArr[k++] = nums1[i++];
            } else {
                tmpArr[k++] = nums2[j++];
            }
        }

        while (i<len1) {
            tmpArr[k++] = nums1[i++];
        }

        while (j<len2) {
            tmpArr[k++] = nums2[j++];
        }

        int totalLen = (len1+len2);
        if (totalLen%2 != 0) {
            return tmpArr[totalLen/2];
        }

        int med = totalLen/2;
        return (tmpArr[med-1] + tmpArr[med])/2.0;
    }
}
