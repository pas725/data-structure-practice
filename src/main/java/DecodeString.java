import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String string = "11[a]3[b2[c]]";
        var res = new Solution().decodeString(string);
        System.out.println(res);
    }
}

class Solution {
    public String decodeString(String s) {

        Stack<String> str = new Stack<String>();
        Stack<Integer> num = new Stack<Integer>();
        int n = s.length();
        int i = 0;
        Stack<String> tmp = new Stack<String>();
        String res = "";
        while (i<n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int ik = i+1;
                while(ik < n && Character.isDigit(s.charAt(ik)))
                    ik++;
                var tnumStr = s.substring(i, ik);
                num.push(Integer.valueOf(tnumStr));
                i = ik;
            } else {
                if (c == ']') {
                    String ts = "";
                    while(!str.peek().equals("["))
                        ts = str.pop() + ts;
                    str.pop();

                    int rep = num.pop();
                    int k = 0;
                    String reps = "";
                    while (k<rep) {
                        reps = reps + ts;
                        k++;
                    }
                    str.push(reps);
                } else {
                    str.push(c + "");
                }
                i++;
            }
        }
        String o = "";
        while (!str.isEmpty())
            o = str.pop() + o;
        return o;
    }
}