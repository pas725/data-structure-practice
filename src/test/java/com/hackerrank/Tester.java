package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Created by piyush_sagar on 11/4/19.
 */
public class Tester {

    @Test
    public void test() {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 < o2 ? 1 : -1);
        q.add(5);
        q.add(3);

        System.out.println(q.peek());

        int coins[] = {1,2,3};
        List<Integer> l = Arrays.asList(1);
        int res = numWay(coins, coins.length-1, 5);
        Assert.assertEquals(2, res);
    }

    int minSteps(int n) {
        if (n < 0)
            return 0;
        return 1 + Math.min(Math.min(minSteps(n-1), minSteps(n-2)), minSteps(n-3));
    }

    int numWay(int[] coins, int length, int n) {
        if (n < 0 || length < 0)
            return 0;
        if (n==0)
            return 1;

        return numWay(coins, length -1, n) + numWay(coins, length, n - coins[length]) ;
    }
}
