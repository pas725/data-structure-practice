package onlinejudge.hackerrank.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by psagar on 3/2/2018.
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
public class WordInString {
    static String hackerrankInString(String s) {
        // Complete this function
        String word = "onlinejudge/hackerrank";
        List<Character> list = new ArrayList<Character>();
        for (int i=0; i<word.length(); i++) {
            list.add(word.charAt(i));
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (list.size() > 0) {
                if(list.get(0).equals(c)) {
                    list.remove(0);
                }
            } else {
                return "YES";
            }
        }
        return list.size() == 0 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
