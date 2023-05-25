package com.tw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by psagar on 11/12/2017.
 */
public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();
    public Customer (String name){
        _name = name;
    };
    public void addRental(Rental arg) {
        _rentals.add(arg);
    }
    public String getName (){
        return _name;
    }

    double getTotalAmount() {
        return  _rentals.stream().mapToDouble((r) -> r.getCharge()).sum();
    }

    int getFrequentRenterPoints() {
        return _rentals.stream().mapToInt((r) -> r.getFrequentRenterPoints()).sum();
    }

    public String statement() {
        Iterator rentals = _rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.next();
//            determine amounts for each line
            thisAmount += each.getCharge();
//          show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
        }
//        add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) +
                "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints())
                +
                " frequent renter points";
        return result;
    }


}
