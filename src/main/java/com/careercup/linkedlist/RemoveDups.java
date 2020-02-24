package com.careercup.linkedlist;

import java.util.Arrays;
import java.util.List;

/*
 * Created by piyush_sagar on 3/14/19.
 *  Write code to remove duplicates from an unsorted linked list
 *
 *  !f we don't have a buffer, we can iterate with two pointers: curren t which iterates through the linked list,
and runne r which checks all subsequent nodes for duplicates.
 */
public class RemoveDups {
    public static void main(String[] args) {
        Node<Integer> head = Node.createList(Arrays.asList(2,4,5,7,2,6));
        Node.printList(head);

        System.out.println("");
        System.out.print("Renoved Dups : ");
        Node<Integer> dupsRemoved = removeDupsInPlace(head);
        Node.printList(dupsRemoved);
    }

    private static Node<Integer> removeDupsInPlace(Node<Integer> head) {
        Node<Integer> walk = head;
        while (walk != null) {
            int currentData = walk.data;
            Node<Integer> runner = walk;
            while (runner.next != null) {
                if (currentData == runner.next.data) {
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }
            walk = walk.next;
        }
        return head;
    }
}
