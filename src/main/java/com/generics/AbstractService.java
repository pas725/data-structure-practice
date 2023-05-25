package com.generics;

/**
 * Created by psagar on 3/27/2018.
 */
public class AbstractService<T> {
    private T obj;

    public AbstractService(T obj) {
        System.out.println("In const");
    }

    public void call() {
        System.out.println("Class : " + obj);
    }
}
