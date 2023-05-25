package onlinejudge.contest;

/**
 * Created by psagar on 9/16/2017.
 */
public class Factorial {
    static long fact(int n) {
        long fact = 1;
        for(int i=2; i<=n ;i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int n = 49;
        System.out.println(fact(n));
    }
}
