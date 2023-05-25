package dp;

// https://leetcode.com/problems/count-anagrams/description/
public class CountAnagrams {
    public static void main(String[] args) {
        SolutionCN solutionCN = new SolutionCN();
        String w = "b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp";
        int res = solutionCN.countAnagrams(w);
        System.out.println(res);
    }
}

class SolutionCN {
    int mod = 1000000007;
    public int countAnagrams(String s) {
        int n = s.length();

        if (n==0)
            return 0;

        long dp[] = new long[n+1];
        dp[0]=1;

        String words[] = s.split(" ");
        long res = 1;
        for (String w: words) {
            res  = (res * perm(w, dp)) % mod;
        }
        return (int) (res % mod);
    }

    long perm(String w, long dp[]) {
        int n = w.length();
        if (n==0)
            return 1;

        int cnt[] = new int[26];
        for (int i=0; i<n; i++) {
            int c = w.charAt(i) - 'a';
            cnt[c] += 1;
        }

        long den = 1;
        long res = fact(n, dp);
        for (int i=0; i<26; i++) {
            int cn = cnt[i];
            if (cn > 1) {
                den = (den * fact(cn, dp)) % mod;
            }
        }

        return (res / den) % mod;
    }

    long fact(int n, long dp[]) {
        if (dp[n]!=0) {
            return dp[n];
        }

        dp[n] = (n * fact(n-1, dp)) % mod;
        return dp[n];
    }
}
