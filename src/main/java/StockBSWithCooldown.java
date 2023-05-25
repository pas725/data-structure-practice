public class StockBSWithCooldown {

    public static void main(String[] args) {
        var o = new StockBSWithCooldown();
        int arr[] = {2,1,4};

        int res = o.maxProfit(arr);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int dp[][] = new int[n][2];
        return rec(0, prices, 0, true, dp);
    }

    int rec(int i, int arr[], int p, boolean buy, int dp[][]) {
        if (i >= arr.length) {
            return p;
        }

        int by = buy ? 1 : 0;
        if (dp[i][by]!=0)
            return dp[i][by];

        int mx = 0;
        if (buy) {
            int b = rec(i+1, arr, p-arr[i], !buy, dp);
            int bs = rec(i+1, arr, p, buy, dp);
            mx = Math.max(b, bs);
            dp[i][by] = Math.max(dp[i][by], mx);
        } else {
            int s = rec(i+2, arr, p+arr[i], !buy, dp);
            int ss = rec(i+1, arr, p, buy, dp);
            mx = Math.max(s, ss);
        }


        return mx;
    }
}
