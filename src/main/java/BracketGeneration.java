import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class BracketGeneration {
    static int  c = 0;
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        permute("", "", strings, 4);
        System.out.println(" Called : " + c);
        strings.stream().forEach(System.out::println);

        System.out.println("Total encoded msg : " + encodedMsg(0,"1112"));

    }

    private static void permute(String l, String r, Set<String> set, int n) {
        if (n == 0) {
            set.add(l+r);
            c++;
            return;
        }
        permute("("+l,  r + ")", set, n-1);
        permute("()"+l,  r , set, n-1);
        permute(l,  r + "()", set, n-1);
    }

    static int encodedMsg(int i, String str) {
        if (i > str.length())
            return 0;
        if (i == str.length())
            return 1;

        int f = 0;
        int s = 0;

        int one = Integer.valueOf(str.substring(i, i+1));
        if (one > 0 && one <= 26)
            f =  encodedMsg(i+1, str);

        if ( i+1 < str.length()) {
            int two = Integer.valueOf(str.substring(i, i+2));
            if (two > 0 && two <= 26)
                s =  encodedMsg(i+2, str);
        }
        return f+s;
    }
}
