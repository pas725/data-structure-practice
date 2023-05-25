package com.tw;

/**
 * Created by psagar on 11/12/2017.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;
    private Price price;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
        setPrice(priceCode);
    }

    public double calculatePrice(int days) {
        return price.getPrice(days);
    }

    private void setPrice(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price  = new RegularPrice();
                break;
            case NEW_RELEASE:
                price  = new NewReleasePrice();
                break;
            case CHILDRENS:
                price  = new ChildrenPrice();
                break;
        }
    }

    public int getPriceCode() {
        return _priceCode;
    }
    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    public String getTitle (){
        return _title;
    }
}
