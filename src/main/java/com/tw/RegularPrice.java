package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class RegularPrice extends Price {

    @Override
    double getPrice(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
