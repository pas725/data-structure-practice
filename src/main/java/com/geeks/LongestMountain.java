package com.geeks;

/*
 * Created by piyush_sagar on 3/28/19.
 */
public class LongestMountain {
    public static void main(String[] args) {
        int[] arr = {0,2,0,2,1,2,2,0,0,1};
        int res = longestMountain(arr);

        System.out.println(res);
    }

    public static int longestMountain(int[] arr) {
        int max = 0;
        boolean hasFound = false;
        int l = 0;
        int r = 0;
        int len = arr.length;
        for (int i=0; i<len; i++) {
            if (!hasFound) {
                if (i+1 < len && arr[i] < arr[i+1]) {
                    l++;
                } else if (i+1 < len && arr[i] > arr[i+1]) {
                    if (l > 0) {
                        l++;
                        hasFound = true;
                    }
                } else {
                    l = 0;
                    hasFound = false;
                }
            } else {
                if (arr[i] < arr[i-1]) {
                    r++;
                    if (i == len-1 ) {
                        max = (l+r) > max ? (l+r) : max;
                    }
                } else {
                    if (l > 0 && r > 0 ) {
                        if ((l+r) > max)
                            max = (l+r);
                        l = 0;
                        r = 0;
                        hasFound= false;
                        i = i-2;
                    }
                }
            }
        }
        return max;
    }
}
