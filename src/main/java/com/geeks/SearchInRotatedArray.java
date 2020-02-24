package com.geeks;

/*
 * Created by piyush_sagar on 3/31/19.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {7,8,9,0,1,2,3,4,5,6};
        int itemToSearch = 3;
        int res = searchInRotated(arr, 0, arr.length-1, itemToSearch);
        //int res = findPivot(arr, 0, arr.length-1);
        System.out.println(res);
    }

    private static int searchInRotated(int[] arr, int i, int j, int itemToSearch) {
        int pivot = findPivot(arr, 0, arr.length-1);

        if (pivot < 0)
            return binarySearch(arr,0, arr.length-1, itemToSearch);

        if (itemToSearch >= arr[0])
            return binarySearch(arr, 0, pivot, itemToSearch);

        return binarySearch(arr, pivot+1, j, itemToSearch);

    }

    static int binarySearch(int arr[],int low, int high, int item) {
        while (low<=high) {
            int mid = (low+high)/2;
            if (arr[mid] == item)
                return mid;

            if (item < arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    static int findPivot(int arr[], int start, int end) {


        if (start > end)
            return -1;

        int mid = (start+end)/2;

        if (start<mid && arr[mid] < arr[mid-1])
            return mid-1;

        if (mid<end && arr[mid] > arr[mid+1])
            return mid;

        if (arr[start] > arr[mid])
            return findPivot(arr, start, mid-1);

        return findPivot(arr, mid+1, end);
    }


}
