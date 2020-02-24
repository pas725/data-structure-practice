package com.ps.trees.bst;

import java.util.*;

/*
 * Created by piyush_sagar on 9/19/18.
 */
public class BST {

    private Node root;
    private int nodeCount;

    public Node getRoot() {
        return root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    private BST() {
        root = null;
        nodeCount = 0;
    }

    // *********************   BST OPERATIONS **********************

    public static BST create() {
        return new BST();
    }

    public void insert(int data) {
        insert(root, data);
    }

    public void clear() {
        nodeCount = 0;
        root = null;
    }

    public List<Integer> preOrderTraversal() {
        return preOrderTraversal(root);
    }

    public List<Integer> inOrderTraversal() {
        return inOrderTraversal(root);
    }

    public List<Integer> postOrderTraversal() {
        return postOrderTraversal(root);
    }

    public Node findMin() {
        return findMin(root);
    }

    public Node findMax() {
        return findMax(root);
    }

    public int getHeight() {
        return getHeight(root);
    }

    public Node find(int dataToFind) {
        return find(root, dataToFind);
    }

    public Node findSuccessor(int data) {
        return findSuccessor(root, data);
    }

    public Node delete(int data) {
        return delete(root, data);
    }

    public void mirrorTree() {
        mirrorTree(root);
    }

    public List<Integer> BFSTraversal() {
        return BFSTraversal(root);
    }
    // **************************   END  ***************************

    private void insert(Node node, int data) {
        if (node == null) {
            Node n = Node.create(data);
            root = n;
            nodeCount++;
            return;
        }

        if (data < node.data) {
            if (node.left == null) {
                Node n = Node.create(data);
                node.left = n;
                nodeCount++;
                return;
            }
            insert(node.left, data);
        }

        if (data > node.data) {
            if (node.right == null) {
                Node n = Node.create(data);
                node.right = n;
                nodeCount++;
                return;
            }
            insert(node.right, data);
        }
    }



    public List<Integer> preOrderTraversal(Node node) {
        List<Integer> list = new LinkedList<Integer>();
        preOrderTraversal(node, list);
        return list;
    }

    private void preOrderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            preOrderTraversal(node.left, list);
            preOrderTraversal(node.right, list);
        }
    }

    public List<Integer> inOrderTraversal(Node node) {
        List<Integer> list = new LinkedList<Integer>();
        inOrderTraversal(node, list);
        return list;
    }

    private void inOrderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.data);
            inOrderTraversal(node.right, list);
        }
    }


    public List<Integer> postOrderTraversal(Node node) {
        List<Integer> list = new LinkedList<Integer>();
        postOrderTraversal(node, list);
        return list;
    }

    private void postOrderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            postOrderTraversal(node.left, list);
            postOrderTraversal(node.right, list);
            list.add(node.data);
        }
    }



    public Node findMin(Node node) {
        if (node == null)
            return node;

        Node walker = node;
        while (walker.left != null)
            walker = walker.left;
        return walker;
    }


    public Node findMax(Node node) {
        if (node == null)
            return node;

        Node walker = node;
        while (walker.right != null)
            walker = walker.right;
        return walker;
    }

    private int getHeight(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;

        int left = 1+ getHeight(node.left);
        int right = 1 + getHeight(node.right);
        return  (left >= right ? left : right);
    }

    public Node find(Node node, int dataToFind) {
        if (node == null)
            return node;

        if (dataToFind < node.data)
            return find(node.left, dataToFind);
        if (dataToFind > node.data)
            return find(node.right, dataToFind);
        return node;
    }

    public Node findSuccessor(Node node, int dataToFind) {
        Node found = find(node, dataToFind);
        if (found != null && found.right != null) {
            found = findMin(found.right);
            return  found;
        }

        Node root = node;
        Node succ = null;
        while (root != null)
        {
            if (found.data < root.data)
            {
                succ = root;
                root = root.left;
            }
            else if (found.data > root.data)
                root = root.right;
            else
                break;
        }
        return succ;
    }

    public Node delete(Node node, int data) {
        if (node == null)
            return node;

        if (data < node.data) {
            node.left = delete(node.left, data);
            return node;
        }

        if (data > node.data) {
            node.right = delete(node.right, data);
            return node;
        }

        if (node.left == null && node.right == null) {
            nodeCount--;
            return null;
        }

        if (node.left == null) {
            Node newNode = node.right;
            node.right = null;
            nodeCount--;
            return newNode;
        }

        if (node.right == null) {
            Node newNode = node.left;
            node.left = null;
            nodeCount--;
            return newNode;
        }

        Node min = findMin(node.right);
        node.data = min.data;
        Node rightSubtree = node.right;
        node.right = min.right;
        delete(rightSubtree, min.data);
        return node;
    }

    public void mirrorTree(Node node) {
        if (node != null) {
            Node tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            mirrorTree(node.left);
            mirrorTree(node.right);
        }
    }

    public List<Integer> BFSTraversal(Node node) {
        List<Integer> bfsTraversal =  new ArrayList<>();
        if (node != null) {
            Node root = node;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    Node element = ((LinkedList<Node>) queue).removeFirst();
                    bfsTraversal.add(element.data);
                    if (element.left != null)
                        queue.add(element.left);
                    if (element.right != null)
                        queue.add(element.right);
                }
            }
        }
        return bfsTraversal;
    }
}
