package com.geeks.tree;

/*
 * Created by piyush_sagar on 8/7/19.
 */
public class AVLTree {

    private Node root;

    public void delete(int key) {
        root = deleteUtil(root, key);
    }

    private Node deleteUtil(Node node, int key) {
        if (node == null)
            return null;
        else if(key < node.data) {
            node.left = deleteUtil(node.left, key);
        } else if (key > node.data) {
            node.right = deleteUtil(node.right, key);
        } else {

            if (node.left == null && node.right == null)
                node = null;
            else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            }
            else {
                Node min =  getMin(node.right);
                node.data = min.data;
                node.right = deleteUtil(node.right, min.data);
            }
        }

        if (node==null)
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bal = getBalance(node);

        if (bal > 1 && key < node.left.data) {
            return rightRotate(node);
        } else if (bal > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (bal < -1 && key > node.right.data) {
            return leftRotate(node);
        } else if (bal < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node getMin(Node node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    private Node insertUtil(Node node, int key) {
        if (node == null)
            return new Node(key);
        else if (key < node.data) {
            node.left = insertUtil(node.left, key);
        } else if (key > node.data) {
            node.right = insertUtil(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bal = getBalance(node);

        if (bal > 1 && key < node.left.data) {
            return rightRotate(node);
        } else if (bal > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (bal < -1 && key > node.right.data) {
            return leftRotate(node);
        } else if (bal < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node rightRotate(Node x) {
        Node y = x.left;
        Node Tr = y.right;

        y.right = x;
        x.left = Tr;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return  y;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node Tr = y.left;

        y.left = x;
        x.right = Tr;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return  y;
    }

    public void insert(int key) {
        if (root == null) {
            root = insertUtil(root, key);
            return;
        }
        root = insertUtil(root, key);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public int getBalance(Node node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        avl.insert(10);
        avl.insert(6);
        avl.insert(2);
        avl.insert(3);
        avl.insert(20);

        avl.delete(2);

        System.out.println("--");
    }
}

class Node {
    int data;
    int height;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = right = null;
        height = 1;
    }
}
