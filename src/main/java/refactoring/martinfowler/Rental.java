package refactoring.martinfowler;

/*
 * Created by piyush_sagar on 11/6/19.
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

    public int frequentRenterPoints() {
        return getMovie().frequentRenterPoints(getDaysRented());
    }

    public double amountFor() {
        return getMovie().getCharge(getDaysRented());
    }
}
