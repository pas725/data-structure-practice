package com.careercup.linkedlist;

import java.util.Arrays;
import java.util.Stack;

/*
 * Created by piyush_sagar on 3/15/19.
 * Implement a function to check if a linked list is a palindrome
 */
public class Palindrome {
    public static void main(String[] args) {
        Node<Integer> head = Node.createList(Arrays.asList(1,2,3,3,2,1));
        Node.printList(head);

        boolean isPalindrome = isPalindrom(head);
        System.out.println("");
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrom(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        Stack<Integer> st = new Stack<>();
        while (fast != null && fast.next!=null) {
            st.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { //List has Odd number of nodes
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != st.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
}
