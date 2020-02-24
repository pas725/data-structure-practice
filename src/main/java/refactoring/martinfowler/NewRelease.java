package refactoring.martinfowler;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class NewRelease implements MovieCode {
    @Override
    public double getPrice(int numDays) {
        return numDays * 3;
    }

    @Override
    public int calculateFrequentRenterPoints(int numDays) {
        if (numDays > 1)
            return 2;
        return 1;
    }
}
