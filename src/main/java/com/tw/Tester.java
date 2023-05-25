package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class Tester {
    {
        System.out.println("In block...");
    }

    static {
        //System.out.println("in static block...");
    }
    public static void main(String[] args) {
        /*Customer c = new Customer("Pas");
        Movie m = new Movie("PK", 1);
        Rental r = new Rental(m, 3);
        c.addRental(r);*/
        //System.out.println("Here");
        Person p = new Person(10);

    }
}

class Person {
    int id;
    static int tmp;

    {
        id = 50;
        tmp = 40;
        System.out.println("in block P:" + id);
    }

    static {
        tmp = 60;
        System.out.println("In static b P" + tmp);
    }

    Person(int id) {
        this.id = id;
        System.out.println("in const P" + this.id);
    }
}
