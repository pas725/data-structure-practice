package com.arrays;

/**
 * Created by psagar on 9/11/2017.
 */
public class CheckPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    public static boolean isPerfectSquare(int num) {
        if (num<1) {
            return false;
        }

        if(num == 1)
            return true;

        int sum = 0;
        for(int i=1; i<=num/2; i=i+2) {
            sum += i;
            if(sum==num) {
                return true;
            }

            if(sum > num)
                break;
        }
        return false;
    }
}
