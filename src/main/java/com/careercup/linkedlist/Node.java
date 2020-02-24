package com.careercup.linkedlist;

import java.util.Arrays;
import java.util.List;

/*
 * Created by piyush_sagar on 3/14/19.
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public static void printList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static Node<Integer> createList(List<Integer>ls) {
        Node<Integer> root = null;
        Node<Integer> walker = null;
        for (int e : ls) {
            Node<Integer> element = new Node<>(e);
            if (root == null) {
                root = element;
                walker = root;
            } else {
                walker.next = element;
                walker = walker.next;
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return "Node{" + data + '}';
    }
}
