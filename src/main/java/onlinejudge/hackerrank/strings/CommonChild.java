package onlinejudge.hackerrank.strings;

import java.util.Scanner;

/**
 * Created by psagar on 3/2/2018.
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class CommonChild {
        static int commonChild(String s1, String s2){
            // Complete this function
            //return lcs(s1, s2, 0, 0, s1.length());
            return lcs(s1, s2);
        }

        // Using recursion
        static int lcs(String s1, String s2, int i, int j, int n) {
            if (i >= n || j >= n) {
                return 0;
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                return 1 + lcs(s1, s2, i+1, j+1, n);
            }
            return Math.max(lcs(s1, s2, i, j+1, n), lcs(s1, s2, i+1, j, n));
        }

        // usiing dynamic programming
    static int lcs(String s1, String s2) {
            int n = s1.length();
            int arr[][] = new int[n+1][n+1];

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        arr[i][j] = arr[i-1][j-1] + 1;
                    } else {
                        arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                    }
                }
            }
            return arr[n][n];
    }


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s1 = in.next();
            String s2 = in.next();
            int result = commonChild(s1, s2);
            System.out.println(result);
        }
}
