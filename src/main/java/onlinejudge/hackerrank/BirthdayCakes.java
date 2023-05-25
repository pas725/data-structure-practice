package onlinejudge.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by psagar on 3/3/2018.
 */
public class BirthdayCakes {
    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        Map<Integer, Integer> hash = new HashMap<>();
        for (int el : ar) {
            Integer count = hash.get(el);
            if (count == null) {
                hash.put(el, 1);
            } else {
                hash.put(el, count + 1);
            }
        }
        int max = 0;
        for (int key : hash.keySet()) {
            int count = hash.get(key);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
