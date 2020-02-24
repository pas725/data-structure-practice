package refactoring.martinfowler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Created by piyush_sagar on 11/6/19.
 */
public class Customer {
    private String _name;
    private List _rentals = new ArrayList();
    public Customer (String name){
        _name = name;
    };
    public void addRental(Rental arg) {
        _rentals.add(arg);
    }
    public String getName (){
        return _name;
    };

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rentals = _rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {

            Rental each = (Rental) rentals.next();
            double thisAmount = each.amountFor();
            frequentRenterPoints += each.frequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
//add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +
                "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                +
                " frequent renter points";
        return result;
    }


}
