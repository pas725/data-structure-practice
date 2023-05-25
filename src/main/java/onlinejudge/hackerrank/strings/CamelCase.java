package onlinejudge.hackerrank.strings;

import java.util.Scanner;

/**
 * Created by psagar on 3/2/2018.
 */
public class CamelCase {
    static int camelcase(String s) {
        // Complete this function
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c>= 'A' && c<= 'Z') {
                cnt++;
            }
        }
        return cnt+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
