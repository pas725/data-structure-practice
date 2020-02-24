package com.leetcode;

import java.util.PriorityQueue;

/*
 * Created by piyush_sagar on 11/10/19.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {

        ListNode h12 = new ListNode(3);
        ListNode h13 = new ListNode(5);
        ListNode h1 = new ListNode(1);


    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<>((l1, l2) -> l1.val <= l2.val ? -1 : 1);
        for (ListNode n : lists) {
            q.add(n);
        }

        ListNode head = null;
        ListNode prev = null;

        while (!q.isEmpty()) {
            ListNode t = q.poll();
            if (t.next != null)
                q.add(t.next);
            t.next = null;

            if (head == null)
                head = t;
            else
                prev.next = t;

            prev = t;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
