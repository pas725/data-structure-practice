package com.leetcode.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Created by piyush_sagar on 9/19/19.
 */
public class PrintInOrder {
    public static void main(String[] args) {
        Foo f = new Foo();

        Runnable r1 = () -> System.out.println("First");
        Runnable r2 = () -> System.out.println("Second");
        Runnable r3 = () -> System.out.println("Third");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future f1 = executorService.submit(r1);
        Future f2 = executorService.submit(r2);
        Future f3 = executorService.submit(r3);

        while (!f1.isDone() || !f2.isDone() || !f3.isDone()) {}

        System.out.println("Done!!");
        executorService.shutdown();
    }
}

class Foo {

    Semaphore lock1, lock2;

    public Foo() {
        lock1 = new Semaphore(1);
        lock2 = new Semaphore(1);

        try {
            lock1.acquire();
            lock2.acquire();
        } catch (Exception e) {}

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        lock1.acquire();
        lock1.release();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird run() outputs "third". Do not change or remove this line.
        lock2.acquire();
        lock2.release();
        printThird.run();
    }
}
