import java.util.*;

public class Trie {
    static Node root = new Node();

    public static void main(String[] args) {
        List<String> s = Arrays.asList("tech", "lead", "techlead", "cat", "cats", "dog", "catsdog");
        List<String> res = findConcatWords(s);
    }

    private static List<String> findConcatWords(List<String> s) {
        for (String w : s) {
            insert(w,  root);
        }

        List<String> res = new ArrayList<>();
        for (String w : s) {
            int f = isConcat(w, 0, root,  root, 0);
            if (f > 1)
                res.add(w);
        }
        return res;
    }

    private static int isConcat(String w, int i, Node node, Node root, int breaks) {

        if (i < w.length()) {
            char c = w.charAt(i);
            Node run = node.child.get(c);
            if (run == null) return 0;

            if (run.isWord) {
                if (i == w.length()-1)
                    return breaks + 1;
                return Math.max(isConcat(w,i+1, root, root, breaks + 1) ,
                        isConcat(w, i+1,run, root, breaks));
            }
            return isConcat(w, i+1,run, root, breaks);
        }
        return 0;
    }

    private static void insert(String w, Node root) {
        Node run = root;
        for (int i=0; i<w.length(); i++) {
            char c = w.charAt(i);
            if (run.has(c)) {
                run = run.child.get(c);
            } else {
                Node t = new Node();
                run.put(c, t);
                run = t;
            }

            if (i == w.length()-1)
                run.isWord = true;
        }
    }
}

class Node {
    boolean isWord = false;
    Map<Character, Node> child = new HashMap<>();

    public boolean has(char c) {
        return child.containsKey(c);
    }

    public void put(char c, Node t) {
        child.put(c, t);
    }
}