package com.arrays.sorting;

/**
 * Created by psagar on 9/10/2017.
 */
public class Quicksort {
    public static void main(String[] args) {
        int arr[] = {3,5,1,9,6,7,2,8};
        qSort(arr, 0, arr.length-1);
        print(arr);
    }

    public static void print(int arr[]) {
        System.out.println("Array :");
        for (int i : arr) {
            System.out.print(" "+i);
        }
    }

    public static void qSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot-1);
            qSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = (low+high)/2;
        while (low < high) {
            while (arr[low] < arr[pivot] && low < pivot) {
                low++;
            }
            if (low < pivot) {
                int tmp = arr[pivot];
                arr[pivot] = arr[low];
                arr[low] = tmp;
                pivot = low;
            }

            while (arr[high] > arr[pivot] && high > pivot ) {
                high--;
            }

            if (high > pivot) {
                int tmp = arr[pivot];
                arr[pivot] = arr[high];
                arr[high] = tmp;
                pivot = high;
            }

        }
        return pivot;

    }
}
