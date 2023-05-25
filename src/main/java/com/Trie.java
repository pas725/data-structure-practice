package com;

/**
 * Created by psagar on 3/17/2018.
 */
public class Trie {
    static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        System.out.println((int)'b');
        insertWord("carioygf");
        System.out.println(searchWord("car"));
    }

    private static boolean searchWord(String word) {
        if(word == null)
            return false;

        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = (int) (c - 'a');
            TrieNode nodes[] = node.getNodes();
            TrieNode n = nodes[index];
            if (n == null) {
                return false;
            }

            if ( (i == (word.length()-1)) && n.isEndOfWord()) {
                return  true;
            }
            node = n;
        }
        return false;
    }


    public static void insertWord(String word) {
        if(word == null)
            return;

        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            node = insertIntoTrie(node, c, i == (word.length()-1));
        }
        System.out.println(node);
    }

    private static TrieNode insertIntoTrie(TrieNode root, char c, boolean b) {
        int index = (int) (c - 'a');
        TrieNode nodes[] = root.getNodes();
        TrieNode node = nodes[index];
        if (node == null) {
            node = new TrieNode();
            nodes[index] = node;
        }

        if (b) {
            node.setEndOfWord(true);
        }
        return node;
    }
}

class TrieNode {
    private TrieNode nodes[];
    private boolean isEndOfWord;

    TrieNode() {
        nodes = new TrieNode[26];
    }

    TrieNode(boolean isEndOfWord) {
        this();
        this.isEndOfWord = isEndOfWord;

    }

    public TrieNode[] getNodes() {
        return nodes;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
