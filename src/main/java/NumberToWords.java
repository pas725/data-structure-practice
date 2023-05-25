/**
 * Created by psagar on 3/16/2018.
 */
public class NumberToWords {

    public static final String[] units = { "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };

    public static final String[] tens = {
            "", 		// 0
            "",		// 1
            "Twenty", 	// 2
            "Thirty", 	// 3
            "Forty", 	// 4
            "Fifty", 	// 5
            "Sixty", 	// 6
            "Seventy",	// 7
            "Eighty", 	// 8
            "Ninety" 	// 9
    };

    public static void main(String[] args) {
        System.out.println(convert(89537));
    }

    public static String convert(int n) {
        if (n<20) {
            return units[n];
        }

        if(n<100) {
            return tens[n/10] + " " + units[n%10];
        }

        if(n<1000) {
            return units[n/100] + " hundred " + convert(n%100);
        }

        if(n<20000) {
            return units[n/1000] + " thousand " + convert(n%1000);
        }

        if(n<100000) {
            return convert(n/1000) + " thousand " + convert(n%1000);
        }

        return "";
    }
}
