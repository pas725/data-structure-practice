package dynamicprogramming;

/*
 * Created by piyush_sagar on 1/22/19.
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class RodCutting {
    public static void main(String[] args) {
        int prices[] = {1 ,5 ,8 ,9, 10 ,17 ,17 ,20};
        int length = 8;

        int res = getMaxValueByRodCut(prices, length);
        System.out.println(res);
    }

    private static int getMaxValueByRodCut(int[] prices, int length) {
        int dp[] = new int[length+1];
        dp[0] = 0;
        for (int i=1; i<= length; i++) {
            int max = -1;
            for (int j=0; j<i; j++) {
                max = Math.max(max, prices[j] + dp[i-j-1]);
            }
            dp[i] = max;
        }
        return dp[length];
    }
}
