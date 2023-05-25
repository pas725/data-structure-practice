package com.arrays;

/**
 * Created by psagar on 9/2/2017.
 */
public class FindMissing2 {
    public static void main(String[] args) {

        int arr[] = {1, 2};
        System.out.print("Array : ");
        print(arr);

        System.out.println("");

        System.out.print("Missing Element :");
        long missing[] = findMissing2(arr);
        print(missing);

    }

    public static long[] findMissing2(int arr[]) {
        long sum = 0;
        for(int num : arr){
            sum += num;
        }

        int arrLength = arr.length;
        int totalLength = arrLength + 2;
        long totalSum = ((arrLength + 2) * (arrLength + 3))/2;
        long avg =  (totalSum - sum) / 2;
        long avgLessSum = 0;
        long avgGreaterSum = 0;

        for(int num : arr){
            if (num <= avg) {
                avgLessSum += num;
            } else {
                avgGreaterSum += num;
            }
        }



        long _4thNum = (avg * (avg+1))/2 - avgLessSum;
        long _5thNum = ((totalLength * (totalLength+1))/2 - (avg * (avg+1))/2) - avgGreaterSum;

        long res[] = new long[2];
        res[0] = _4thNum;
        res[1] = _5thNum;

        return res;
    }

    public static void print(int arr[]){
        for(int num : arr) {
            System.out.print(" "+num);
        }
    }

    public static void print(long arr[]){
        for(long num : arr) {
            System.out.print(" "+num);
        }
    }
}
