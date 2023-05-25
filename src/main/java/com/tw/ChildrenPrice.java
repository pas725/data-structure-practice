package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class ChildrenPrice extends Price {
    @Override
    double getPrice(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }
}
