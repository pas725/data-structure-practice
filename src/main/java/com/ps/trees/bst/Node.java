package com.ps.trees.bst;

/*
 * Created by piyush_sagar on 9/19/18.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    private Node() {}

    private Node(int data) { this(data, null, null); }

    private Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static Node create(int data) {
        return new Node(data);
    }

    public static void delete(Node node) {
        if (node != null) {
            node.left = null;
            node.right = null;
        }
    }
}
