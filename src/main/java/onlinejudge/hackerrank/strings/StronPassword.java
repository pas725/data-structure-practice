package onlinejudge.hackerrank.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by psagar on 3/2/2018.
 * https://www.hackerrank.com/challenges/strong-password/problem
 */
public class StronPassword {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String dig = "DIG"; // didit
        String ll = "LEL"; // lower english
        String ul = "UEL"; // upper english
        String sp = "SP";  // special char

        Set<String> set = new HashSet<>();
        set.add(dig);
        set.add(ll);
        set.add(ul);
        set.add(sp);

        for (int i=0; i<n; i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                set.remove(ll);
            } else if (c >= 'A' && c <= 'Z') {
                set.remove(ul);
            } else if (c >= '0' && c <= '9') {
                set.remove(dig);
            } else if ( "!@#$%^&*()-+".indexOf(c) >= 0) {
                set.remove(sp);
            }
        }


        if ( n >= 6 ) {
            return set.size();
        } else {
            int req = 6 - n;
            if (req > set.size()) {
                return req;
            } else {
                return set.size();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
