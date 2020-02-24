package com.careercup.linkedlist;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 3/14/19.
 *  implement an algorithm to find the kth to last element of a singly linked list
 */
public class KthToLast {

    public static void main(String[] args) {
        Node<Integer> head = Node.createList(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Node.printList(head);

        System.out.println("");
        Node<Integer> kth = kthToLast(head, 4);
        System.out.println(kth.data);
    }

    private static Node<Integer> kthToLast(Node<Integer> head, int i) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        int run = 0;
        while (fast != null) {
            if (run >= i) {
                slow = slow.next;
            }
            fast = fast.next;
            run++;
        }
        return slow;
    }
}
