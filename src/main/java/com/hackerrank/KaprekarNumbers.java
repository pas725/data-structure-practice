package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Created by piyush_sagar on 10/22/19.
 */
public class KaprekarNumbers {


    public static List<Integer> kaprekarNumbers(int p, int q) {
        List<Integer> result = new ArrayList<>();
        for (int i=p; i<=q; i++) {
            // System.out.println("Processing : " + i);
            String input = String.valueOf(i);
            int d = input.length();

            String square = String.valueOf((long) Math.pow(i, 2));
            String left = square.substring(0, square.length() - d);
            String right = square.substring(square.length() - d);
            if (left.trim().length() == 0)
                left = "0";
            int res = Integer.parseInt(left) + Integer.parseInt(right);
            if (i == res) {
                result.add(i);

            }
        }
        if (result.size() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            result.forEach(i -> {
                System.out.println(i + " ");
            });
        }

        return result;
    }
}
