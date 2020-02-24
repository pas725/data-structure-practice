package refactoring.martinfowler;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private MovieCode price;
    private String _title;
    private MovieCode _priceCode;
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = getCode(priceCode);
    }

    public String getTitle () {
        return _title;
    };

    public double getCharge(int numDays) {
        return _priceCode.getPrice(numDays);
    }

    private MovieCode getCode(int code) {
        switch (code) {
            case REGULAR:
                return new Regular();
            case NEW_RELEASE:
                return new NewRelease();
            case CHILDRENS:
                return new Childrens();
        }
        return null;
    }

    public int frequentRenterPoints(int daysRented) {
        return _priceCode.calculateFrequentRenterPoints(daysRented);
    }
}
