package company.athenahealth;

import java.util.Stack;

/**
 * Created by psagar on 2/23/2018.
 */
public class BracesMatching {
    public static void main(String[] args) {
        String arr[] = {"{}", "", "(){}[()]", "()))"};
        String res[] = braces(arr);

        for(String item : res) {
            System.out.println(item);
        }
    }

    static String[] braces(String[] values) {
        int len = values.length;
        String res[] = new String[len];
        for (int i=0; i<len; i++) {
            res[i] = isMatching(values[i]);
        }
        return res;
    }

    public static String isMatching(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0 ;i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.peek();
                if ( c == '}' && top == '{'
                        || c == ')' && top == '('
                        || c == ']' && top == '[') {
                    stack.pop();
                    continue;
                }
                return "NO";
            }
        }
        if (stack.isEmpty()) {
             return "YES";
        }
        return "NO";
    }
}
