package com.sort;

/*
 * Created by piyush_sagar on 3/25/19.
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {5, 8, 6, 1, 4, 3, 0, 9, 2, 7};

        heapSort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        System.out.println("");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        int length = arr.length;
        for (int i= (length/2); i>=0; i--) {
            heapify(arr, i, length-1);
        }

        for (int i=length-1; i>=0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int length) {
        int node = i;
        int left = node * 2 + 1;
        int right = left + 1;

        int max = i;
        if (left < length && arr[max] < arr[left]) {
            max = left;
        }

        if (right < length && arr[max] < arr[right]) {
            max = right;
        }

        if (max != i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            heapify(arr, max, length);
        }

    }
}
