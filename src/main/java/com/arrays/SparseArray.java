package com.arrays;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 */
public class SparseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0 ;i<n ;i++){
            String str = in.next();
            Integer cnt = null;
            if ( (cnt = map.get(str)) != null) {
                cnt++;
                map.put(str,cnt);
            } else {
                map.put(str, 1);
            }
        }
        int q = in.nextInt();
        int res[] = new int[q];
        for (int i=0; i<q ;i++) {
            String query = in.next();
            Integer val;
            if ((val = map.get(query)) != null) {
                res[i] = val;
            } else {
                res[i] = 0;
            }
        }
        in.close();
        print(res);
    }

    public static void print(int arr[]) {
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
