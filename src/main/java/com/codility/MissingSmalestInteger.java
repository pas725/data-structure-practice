package com.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 2/2/2018.
 */
public class MissingSmalestInteger {
    public static void main(String[] args) {
        int arr[] = {501, 504};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        boolean hasOneFound = false;
        int smallest = Integer.MAX_VALUE;
        Map<Integer, Boolean> hash = new HashMap<>();
        for (int el : A) {
            hash.put(el, true);
            if (el == 1) {
                hasOneFound = true;
            }
        }

        if (!hasOneFound) {
            return 1;
        }

        for (int el : A) {

            int nextSmallest = el >= 0 ? el + 1 : 1;
            if (hash.get(nextSmallest) == null && nextSmallest < smallest) {
                    smallest = nextSmallest;
            }
        }

        return smallest;
    }
}
