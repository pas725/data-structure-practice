package com.careercup.linkedlist;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 3/15/19.
 */
public class IntersectionPoint {
    public static void main(String[] args) {
        Node<Integer> common = Node.createList(Arrays.asList(8,9,10));
        Node<Integer> first = Node.createList(Arrays.asList(1,2,3));
        Node<Integer> second = Node.createList(Arrays.asList(3,4,5));

        Node<Integer> runner = first;
        while (runner.next != null)
            runner = runner.next;
        runner.next = common;
        System.out.print("First  : ");
        Node.printList(first);

        runner = second;
        while (runner.next != null)
            runner = runner.next;
        runner.next = common;
        System.out.print("Second : ");
        Node.printList(second);

        Node<Integer> point = getIntersectionpoint(first, second);
        System.out.println("Intersection Point : " + point);

    }

    private static Node<Integer> getIntersectionpoint(Node<Integer> first, Node<Integer> second) {
        int l1 = getLength(first);
        int l2 = getLength(second);
        Node<Integer> f1 = first;
        Node<Integer> f2 = second;

        if (l1 != l2) {
            int diff = Math.abs(l1-l2);
            int cnt = 0;
            if (l1 > l2) {
                while (cnt < diff) {
                    first = first.next;
                    cnt++;
                }
            } else {
                while (cnt < diff) {
                    second = second.next;
                    cnt++;
                }
            }
        }

        while ( first != null) {
            if ( first == second) {
                return first;
            }
            first = first.next;
            second = second.next;
        }

        return null;
    }

    public static int getLength(Node<Integer> head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
