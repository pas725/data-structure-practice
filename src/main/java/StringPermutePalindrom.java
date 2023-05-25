/*
    Given a string which we can delete at most k, return whether you can make a palindrome.
    For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */
public class StringPermutePalindrom {
    static int cnt = 0;
    public static void main(String[] args) {
        String s = "waterrfetawx";
        int k = 2;
        int n = s.length();
        int i=0, j=n-1;
        boolean dp[][] = new boolean[n][n];
        var res = permute(s, i, j, k, dp);
        System.out.println(res);
        System.out.println("Called : " + cnt);
    }

    static boolean permute(String s, int i, int j, int k, boolean dp[][]) {
        if (i<j) {
            cnt++;
            if (k < 0)
                return false;

            if (dp[i][j])
                return dp[i][j];

            if (s.charAt(i) == s.charAt(j)) {
                int newi = i+1;
                int newj = j-1;
                if (newj-newi <= 1)
                    return true;
                var res = permute(s, i + 1, j - 1, k, dp);
                dp[i][j] = res;
                return res;
            }
            var res = permute(s, i, j - 1, k - 1, dp) || permute(s, i + 1, j, k - 1, dp);
            dp[i][j] = res;
            return res;
        }
        return false;
    }
}
