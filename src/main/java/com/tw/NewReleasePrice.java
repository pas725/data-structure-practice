package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class NewReleasePrice extends Price {
    @Override
    double getPrice(int daysRented) {
        return daysRented * 3;
    }
}
