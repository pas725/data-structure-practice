package com.geeks.linkedlist;

/*
 * Created by piyush_sagar on 8/23/19.
 */
public class MergesortLL {

    public static void main(String[] args) {
        Node head;
        Node a = new Node(10);
        head = a;
        a.next = new Node(5); a = a.next;
        a.next = new Node(2); a = a.next;
        a.next = new Node(15); a = a.next;
        a.next = new Node(25); a = a.next;
        a.next = new Node(4); a = a.next;
        a.next = new Node(3); a = a.next;

        Node res = mergeSort(head);

        printLL(res);
    }

    private static void printLL(Node res) {
        while (res!=null) {
            System.out.print(" "+ res.data);
            res = res.next;
        }
    }

    private static Node mergeSort(Node head) {
        if (head != null && head.next!= null) {
            Node mid = partition(head);
            Node next = mid.next;
            mid.next = null;
            Node left = mergeSort(head);
            Node right = mergeSort(next);


            Node res = merge(left, right);
            return res;
        }
        return head;
    }

    private static Node merge(Node left, Node right) {
        Node res;

        if (left== null)
            return right;

        if(right==null)
            return left;

        if (left.data < right.data) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    private static Node partition(Node head) {
        if (head != null) {
            Node slow = head;
            Node fast = slow.next;

            while (fast!= null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        return head;
    }
}
