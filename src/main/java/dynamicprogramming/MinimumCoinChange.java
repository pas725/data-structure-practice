package dynamicprogramming;

/*
 * Created by piyush_sagar on 1/22/19.
 */
public class MinimumCoinChange {
    public static void main(String[] args) {
        int coins[] = {1, 5, 6, 9};
        int change = 11;
        int res = minimumCoins(coins, change);
        System.out.println(res);
    }

    private static int minimumCoins(int[] coins, int change) {
        int dp[] = new int[change+1];
        dp[0] = 0;
        for (int i=1; i<= change; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<= change; j++) {
                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }
        return dp[change];
    }
}
