package company.lkart;

import java.util.*;

/**
 * Created by psagar on 2/14/2018.
 * https://www.hackerearth.com/challenge/hiring/lenskart-java-developer-hiring-challenge/algorithm/alice-and-string-game-dbd6adc3/
 */
public class StringGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();               // Reading input from STDIN
        List<String> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String input = s.next();
            res.add(game(input.trim()));
        }

        res.forEach(System.out::println);

    }

    static String game(String str) {
        Map<Character, Integer> hash = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            Integer val = hash.get(c);
            if (val == null)
                val = 1;
            else
                val++;
            hash.put(c, val);
        }

        int res = hash.size() % 2;
        if (res == 1) {
            return "Player1";
        } else {
            return "Player2";
        }
    }
}
