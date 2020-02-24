package refactoring.martinfowler;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class Childrens implements MovieCode {
    @Override
    public double getPrice(int numDays) {
        double thisAmount = 1.5;
        if (numDays > 3)
            thisAmount += (numDays - 3) * 1.5;
        return thisAmount;
    }

    @Override
    public int calculateFrequentRenterPoints(int numDays) {
        return 1;
    }
}
