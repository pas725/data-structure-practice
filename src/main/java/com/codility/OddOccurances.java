package com.codility;

/**
 * Created by psagar on 1/23/2018.
 */
public class OddOccurances {
    public static void main(String[] args) {
        int arr[] = {9, 3, 9, 3, 7, 8, 8};
        int res = solution(arr);
        //System.out.println(res);
        System.out.println(2 << 10);
    }

    public static void print(int arr[]) {
        for(int el : arr) {
            System.out.print(" " + el);
        }
    }

    public static int solution(int[] A) {
        int res = 0;
        for (int el : A) {
            res = res ^ el;
        }
        return res;
    }
}
