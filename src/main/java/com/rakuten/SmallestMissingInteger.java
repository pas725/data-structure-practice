package com.rakuten;

/*
 * Created by piyush_sagar on 9/4/19.
 */
public class SmallestMissingInteger {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        boolean b[] = new boolean[len];

        for (int a : A) {
            if (a <= 0)
                continue;

            b[a-1] = true;
        }

        for (int i=0 ;i<b.length; i++) {
            if (b[i] == false)
                return i+1;
        }
        return len+1;

    }
}
