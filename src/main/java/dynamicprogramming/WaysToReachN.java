package dynamicprogramming;

/*
 * Created by piyush_sagar on 2/6/19.
 */
public class WaysToReachN {
    public static void main(String[] args) {

        int faces[] = {1, 2, 3, 4, 5, 6};
        int N = 610;

        long res = countWays(faces, N);

        System.out.println(res);

    }

    /*
     * @param  faces
     *         Array containing each face number of the dice
     *
     * @param  n
     *         Finishing point
     */
    private static long countWays(int[] faces, int n) {
        long dp[] = new long[n+1];
        dp[0] = 1;
        for (int face : faces) {
            for (int i=face; i<=n; i++) {
                dp[i] = dp[i] + dp[i-face];
            }
        }
        return dp[n];
    }

}
