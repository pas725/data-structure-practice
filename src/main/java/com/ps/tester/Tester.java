package com.ps.tester;

import java.io.IOException;

/*
 * Created by piyush_sagar on 6/12/19.
 */
public class Tester {
    public static void main(String[] args) {
        try {
            call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void call() throws Exception{
        try {
            System.out.println("In try block...");
            //throw new ArithmeticException("Why ");
        } catch (Exception e) {
            System.out.println("Got exception " + e);
            //throw e;
        } finally {
            System.out.println("In finally block...");
            throw new IOException("Finally Why ");
        }
    }
}
