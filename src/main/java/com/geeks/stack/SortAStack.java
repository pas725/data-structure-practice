package com.geeks.stack;

import java.util.Stack;

/*
 * Created by piyush_sagar on 8/1/19.
 */
public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(8);
        st.push(1);
        st.push(7);
        st.push(6);
        st.push(2);
        sortStack(st);

        printSt(st);
        int x = (int) Math.pow(2,2);
    }

    private static void printSt(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.print(" " + st.pop());
        }
    }

    private static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int item = st.pop();
            sortStack(st);

            Stack<Integer> tmpStack = new Stack<>();
            while (!st.isEmpty() && st.peek() < item) {
                tmpStack.push(st.pop());
            }
            st.push(item);
            while (!tmpStack.isEmpty())
                st.push(tmpStack.pop());
        }
    }
}
