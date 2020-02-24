package dynamicprogramming;

/*
 * Created by piyush_sagar on 1/21/19.
 */
public class LongestPalindromicSubseq {
    public static void main(String[] args) {

        String a = "AGGTAB";
        String b = "GXTXAYB";

        System.out.println(String.format("Longest Palindromic subsequence[%s] : ", a) + longestPalindromicSubseq(a) );
        System.out.println(String.format("Longest Common subsequence[%s, %s] : ", a, b) + longestCommonSubseq(a, b) );
    }

    private static int longestPalindromicSubseq(String s) {
        System.out.println("-- : " + reverse(s).toString());
        int res = longestSubseq(s, reverse(s).toString(), s.length(), s.length());
        return res;
    }

    private static int longestCommonSubseq(String x, String y) {
        return longestSubseq(x, y, x.length(), y.length());
    }

    private static int longestSubseq(String a, String b, int m, int n) {
        char x[] = a.toCharArray();
        char y[] = b.toCharArray();
        int dp[][] = new int[m+1][n+1];

        for (int row=0; row<=m; row++) {
            for (int col=0; col<=n; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 0;
                } else if (x[row-1] == y[col-1]) {
                    dp[row][col] = dp[row-1][col-1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row-1][col] , dp[row][col-1]);
                }
            }
        }
        return dp[m][n];
    }

    private static char[] reverse(String s) {
        char[] x = s.toCharArray();
        int len = x.length;
        int i=0;
        int j= len-1;

        while (i<j) {
            char temp = x[i];
            x[i] = x[j];
            x[j] = temp;
            i++;
            j--;
        }
        return x;
    }
}
