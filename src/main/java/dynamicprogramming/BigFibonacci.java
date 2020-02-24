package dynamicprogramming;

import java.math.BigInteger;

/*
 * Created by piyush_sagar on 2/6/19.
 */
public class BigFibonacci {
    public static void main(String[] args) {
        int n = 8181;

        long res = fibL(n);
        //System.out.println(res);

        BigInteger res1 = fib(n);
        System.out.println(res1);
    }

    private static long fibL(int n) {
        long dp[] = new long[n+1];
        dp[1] = 1;

        for (int walker=2; walker<=n; walker++) {
            dp[walker] = dp[walker-1] + dp[walker-2];
        }
        return dp[n];
    }

    /*
     * @param  n
     */
    private static BigInteger fib(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger current = BigInteger.ZERO;
        for (int walker=2; walker<=n; walker++) {
            current = a.add(b);
            a = b;
            b = current;
        }
        return current;
    }
}
