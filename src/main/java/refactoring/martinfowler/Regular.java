package refactoring.martinfowler;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class Regular implements MovieCode {
    @Override
    public double getPrice(int numDays) {
        double thisAmount = 2;
        if (numDays > 2)
            thisAmount += (numDays - 2) * 1.5;
        return thisAmount;
    }

    @Override
    public int calculateFrequentRenterPoints(int numDays) {
        return 1;
    }
}
