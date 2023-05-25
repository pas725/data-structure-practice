package com.codility;

/**
 * Created by psagar on 1/23/2018.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] = {5, -1000};
        int res[] = solution(arr, 1);
        print(res);
    }

    public static void print(int arr[]) {
        for(int el : arr) {
            System.out.print(" " + el);
        }
    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        int res[] = new int[length];
        if (K == length) {
            return A;
        }

        int runner = 0;
        int loc = K-1;
        while (runner < length) {
            res[runner] = A[loc%length];
            loc++;
            runner++;
        }
        return res;
    }
}
