package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }

    int getFrequentRenterPoints() {
        return ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) ? 2 :  1;
    }

    double getCharge() {
        return getMovie().calculatePrice(getDaysRented());
    }
}
