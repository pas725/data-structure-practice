package com.geeks.recursive;

/*
 * Created by piyush_sagar on 11/4/19.
 */
public class NumberToExcelColumnHeader {
    public static void main(String[] args) {
        int num = 53;
        printHeader(num);
    }

    private static void printHeader(int num) {
        char arr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (num>0) {
            int index = num % 26;
            System.out.print(arr[index-1]);
            printHeader(num/26);
        }
    }
}
