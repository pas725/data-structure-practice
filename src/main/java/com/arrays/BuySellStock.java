package com.arrays;

/**
 * Created by psagar on 9/7/2017.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BuySellStock {
    public static void main(String[] args) {
        int arr[] = {8,3,4,7,3};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;

        if(len == 0){
            return  0;
        }

        int min = 0;
        int maxDistance = Integer.MIN_VALUE;

        for(int i=1;i<len;i++) {
            if (prices[i] - prices[min] > maxDistance) {
                maxDistance = prices[i] - prices[min];
            }
            if (prices[i] < prices[min]) {
                min = i;
            }
        }

        return maxDistance;
    }
}
