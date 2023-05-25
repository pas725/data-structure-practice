package onlinejudge.hackerrank.strings;

import java.util.*;

/**
 * Created by psagar on 3/2/2018.
 * https://www.hackerrank.com/challenges/pangrams/problem
 */
public class Pangram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String result = test(s);
        System.out.println(result);
        in.close();
    }

    private static String test(String s) {
        Set<Character> hash = new HashSet<>();
        for (char c='a'; c<='z'; c++) {
            hash.add(c);
        }

        s = s.toLowerCase();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (hash.size() > 0) {
                hash.remove(c);
            } else {
                return "pangram";
            }
        }
        return hash.size() == 0 ? "pangram" : "not pangram";
    }
}
