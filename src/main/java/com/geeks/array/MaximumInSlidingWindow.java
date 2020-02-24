package com.geeks.array;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Created by piyush_sagar on 8/23/19.
 *
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
public class MaximumInSlidingWindow {
    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        maximumSlidingWindow(arr, k);
    }

    private static void maximumSlidingWindow(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<>();

        int i = 0;
        for (i=0; i<k; ++i) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }

        for (; i<arr.length; ++i) {
            System.out.println(arr[q.peekFirst()]);

            while (!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();

            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }

        System.out.print(arr[q.peek()]);
    }
}
