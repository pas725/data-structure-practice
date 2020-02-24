package com.ps.tester;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * Created by piyush_sagar on 9/28/18.
 */
public class Main {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = performOperation(numbers, ((a) -> a + 3));
        System.out.println(result);

        combinations("abc");
    }

    static List<Integer> performOperation(List<Integer> numbers, Operation operation) {
        return numbers.stream().map(e -> operation.perform(e)).collect(Collectors.toList());
    }


    Stack<Integer> s1 =  new Stack<>();
    Stack<Integer> s2 =  new Stack<>();

    public void enQueue(int element)  {
        s1.push(element);
    }

    public Integer deQueue() throws Exception {
        if (s1.isEmpty() && s2.isEmpty())
            throw new Exception("Queue is empty");

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void combinations(String str) {
        String prefix = "";
        for(int i=0; i<str.length(); i++) {
            prefix = str.substring(0, i+1);
            System.out.println(prefix);

            for (int j=i; j<str.length(); j++) {
                String tmp = prefix + str.charAt(j);
                System.out.println(tmp);
            }
        }
    }
}
