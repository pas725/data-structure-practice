package com.leetcode.concurrency;

/*
 * Created by piyush_sagar on 11/22/19.
 */
class Driver {
    public static void main(String[] args) throws InterruptedException {
        PrintOddEven odd = new PrintOddEven(1);
        PrintOddEven even = new PrintOddEven(0);

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t2.start();
        t1.start();

        t1.join();
        t2.join();
    }
}

public class PrintOddEven implements Runnable {
    private static int number = 1;
    static Object lock = new Object();

    private int rem;

    public PrintOddEven(int rem) {
        this.rem = rem;
    }


    @Override
    public void run() {
        while (number < 10) {
            synchronized (lock) {
                while (number % 2 != rem) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread : " + Thread.currentThread().getName() + ", Number :" + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
