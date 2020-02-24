package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Created by piyush_sagar on 10/22/19.
 */
public class KaprekarNumbersTest {

    @Test
    public void testKaprekarNumbers() {
        int p = 1;
        int q = 100;
        List<Integer> result = KaprekarNumbers.kaprekarNumbers(p, q);
        List<Integer> expected = Arrays.asList(1, 9, 45, 55, 99);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testKaprekarNumber() {
        int p = 11;
        int q = 11;
        List<Integer> result = KaprekarNumbers.kaprekarNumbers(p, q);
        List<Integer> expected = Arrays.asList();
        Assert.assertEquals(expected, result);
    }
}
