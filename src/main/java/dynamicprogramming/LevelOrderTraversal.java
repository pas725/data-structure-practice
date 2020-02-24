package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by piyush_sagar on 2/6/19.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = createTree();
        traverseByLevel(root);
    }

    private static Node createTree() {
        Node l21 = new Node(0);
        //Node l22 = new Node(7);
        Node l23 = new Node(9);
        Node l24 = new Node(1);

        Node l11 = new Node(1);
        Node l12 = new Node(3);

        Node l01 = new Node(2);

        l11.left = l21;
        //l11.right = l22;

        l12.left = l23;
        l12.right = l24;

        l01.left = l11;
        l01.right = l12;

        return l01;
    }

    static void traverseByLevel(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                Node node = queue.poll();
                System.out.print(node.getData() + " ");

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println("");
        }
    }
}

class Node {
    private int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public int getData() {
        return data;
    }
}
