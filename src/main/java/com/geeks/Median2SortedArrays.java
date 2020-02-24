package com.geeks;

/*
 * Created by piyush_sagar on 11/5/19.
 */
public class Median2SortedArrays {
    public static void main(String[] args) {
        int a[] = {1, 3, 5};
        int b[] = {2,8,9};
        double res =  median(a, b);

        System.out.println(res);
    }

    private static double median(int[] a, int[] b) {

        int i=0;
        int j=0;

        int count = 0;
        int med = -1;
        int med2 = -1;
        if ((a.length + b.length) % 2 == 1){
            while (count <= (a.length + b.length) / 2) {
                if (i < a.length && j < b.length) {
                    med = (a[i] < b[j]) ? a[i++] : b[j++];
                } else if (i < a.length) {
                    med = a[i++];
                } else {
                    med = b[j++];
                }
                count++;
            }
            return med;
        } else {

            while (count <= (a.length + b.length) / 2) {
                med2 = med;
                if (i < a.length && j < b.length) {
                    med = (a[i] < b[j]) ? a[i++] : b[j++];
                } else if (i < a.length) {
                    med = a[i++];
                } else {
                    med = b[j++];
                }
                count++;
            }
            return (med + med2) / 2 ;
        }
    }
}
