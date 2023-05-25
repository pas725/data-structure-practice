package com.arrays.sorting;

/**
 * Created by psagar on 1/27/2018.
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {0, 4,7,2,3,9,1,8};
        heapSort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for(int el : arr) {
            System.out.print(" " + el);
        }
    }

    public static void maxHeapify(int[] arr, int loc, int length) {
        int left = loc * 2;
        int right = left + 1;
        int i = loc;
        if (left <= length && arr[left] > arr[i]) {
            i = left;
        }

        if (right <= length && arr[right] > arr[i]) {
            i = right;
        }

        if (i != loc) {
            int tmp = arr[i];
            arr[i] = arr[loc];
            arr[loc] = tmp;
            maxHeapify(arr, i, length);
        }
    }

    public static void heapSort(int[] arr) {
        int len = arr.length-1;
        buildMaxHeap(arr, len);
        for (int i=len; i>=1 ; i--) {
            int tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;
            buildMaxHeap(arr, i-1);
        }
    }

    public static void buildMaxHeap(int[] arr, int length) {
        int len = length;
        for(int i=len/2; i>=1; i--) {
            maxHeapify(arr, i, len);
        }
    }
}
