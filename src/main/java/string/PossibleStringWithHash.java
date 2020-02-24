package string;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by piyush_sagar on 9/5/19.
 * You are given a mapping like a -> 1, b-> 2… z-> 26. You have to print all possible combinations of a given number using the above information
 */
public class PossibleStringWithHash {
    static Map<String, String> map = new HashMap<>(26);
    public static void main(String[] args) {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");
        map.put("18", "r");
        map.put("19", "s");
        map.put("20", "t");
        map.put("21", "u");
        map.put("22", "v");
        map.put("23", "w");
        map.put("24", "x");
        map.put("25", "y");
        map.put("26", "z");

        permute("", "121");

    }

    static void permute(String res, String in) {
        int len = in.length();
        if (len  == 0) {
            System.out.println(res);
            return;
        }

        if (len > 1) {
            String num = in.substring(0,2);
            String ch = map.get(num);
            if (ch != null) {
                permute(res + ch, in.substring(2));
            }
        }

        if (len > 0) {
            String num = in.substring(0,1);
            String ch = map.get(num);
            if (ch != null) {
                permute(res + ch, in.substring(1));
            }
        }

    }
}
