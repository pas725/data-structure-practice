package com.geeks.stack;

import java.util.Stack;

/*
 * Created by piyush_sagar on 8/2/19.
 */
public class MaxRectHistogram {
    public static void main(String[] args) {
        int[] hist = {1,2,3,1,1,1};
        int res = largestRectanglularAreaInHistogram(hist);

        System.out.println("Result :" + res);
    }

    public static int largestRectanglularAreaInHistogram(int[] hist) {
        final Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int tp;
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                int w = s.empty() ? i : i - s.peek() - 1;
                areaWithTop = hist[tp] * w;

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            int w = s.empty() ? i : i - s.peek() - 1;
            areaWithTop = hist[tp] * w;

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }
}
