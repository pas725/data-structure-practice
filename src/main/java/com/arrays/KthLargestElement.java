package com.arrays;

import java.util.PriorityQueue;

/**
 * Created by psagar on 9/11/2017.
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {5,7,3,2,4,9,1};
        System.out.println(findKthLargest(3, arr));
    }

    public static int findKthLargest(int k, int arr[]) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for(int val : arr) {
            q.offer(val);

            if(q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
