package com.arrays.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by psagar on 9/13/2017.
 */
public class MinimumCoinSum {


    public static void main(String[] args) {
        int coins[] = {1,3,5};
        int sum = 14;

        System.out.println(findMinimumCoin( coins, sum));
    }

    public static int findMinimumCoin(int coins[], int sum) {
        int db[] = new int[sum+1];
        Arrays.fill(db, -1);
        db[0] = 0;
        return getMinimumCoins(sum, db, coins);
    }

    public static int getMinimumCoins(int sum, int db[], int coins[])  {

        if (db[sum] != -1)
            return db[sum];

        int min = Integer.MAX_VALUE;
        for(int coin:coins) {
            if (coin <= sum)
                min = Math.min(min, 1 + getMinimumCoins(sum-coin, db, coins));
        }

        db[sum] = min;
        return min;
    }
}
