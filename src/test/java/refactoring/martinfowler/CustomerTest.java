package refactoring.martinfowler;

import org.junit.Test;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class CustomerTest {

    @Test
    public void testStatement() {
        Movie movie = new Movie("Don", 0);
        Movie movie2 = new Movie("Pie", 2);

        Rental r1 = new Rental(movie, 2);
        Rental r2 = new Rental(movie2, 1);

        Customer c = new Customer("John");
        c.addRental(r1);
        c.addRental(r2);
        String res = c.statement();
        System.out.println(res);
    }
}
