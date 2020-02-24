package com.rakuten;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by piyush_sagar on 11/13/19.
 */
public class Codility03 {
    public static void main(String[] args) {
        int[] A = new int[] {908, 344, 4, 8, 0, 1, 4, 7, 5000, 9001};
        int res = binarian(A);
        System.out.println(res);
    }


    public static int binarian(int[] A) {
        BigInteger binarian = new BigInteger("0");
        BigInteger tmp = new BigInteger("2");
        for (int i = 0; i < A.length; i++) {
            binarian = binarian.add(tmp.pow(A[i]));
        }
        System.out.println(binarian);
        return binarian.bitCount();
    }
}
