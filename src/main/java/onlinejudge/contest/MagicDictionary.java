package onlinejudge.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 9/16/2017.
 * https://leetcode.com/contest/leetcode-weekly-contest-49/problems/implement-magic-dictionary/
 */
public class MagicDictionary {

    static class Node {
        char data;
        Map<Character,Node> paths = new HashMap<>();

        public Node(Character c) {
            data = c;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public Map<Character, Node> getPaths() {
            return paths;
        }

        public void setPaths(Map<Character, Node> paths) {
            this.paths = paths;
        }
    }

    static Node head = new Node('a');

    public static void main(String[] args) {

    }

    public Node putCharInNode(char c) {
        return null;
    }

    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            char arr[] = word.toCharArray();
            for(int i=0 ;i<arr.length ;i++) {
                if (i==0) {
                    if (!head.getPaths().containsKey(arr[i])) {
                        head.getPaths().put(arr[i], null);
                    } else {

                    }
                }
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return false;
    }
}
