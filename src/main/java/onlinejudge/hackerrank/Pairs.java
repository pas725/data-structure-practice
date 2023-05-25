package onlinejudge.hackerrank;

import java.util.*;

/**
 * Created by psagar on 3/2/2018.
 */
public class Pairs {

    static int pairs(int k, int[] arr) {
        // Complete this function
        Map<Integer, Boolean> hash = new HashMap<>();
        for (int el : arr) {
            hash.put(el, true);
        }

        Set<String> set = new HashSet<>();
        int res = 0;
        for (int el : arr) {
            int below = el - k;
            int above = el + k;

            if (below >= 0) {
                String key = el < below ? el + ":" + below : below + ":" + el;
                if(hash.get(below) != null && !set.contains(key)) {
                    set.add(key);
                }
            }

            if (above >= 0) {
                String key = el < above ? el + ":" + above : above + ":" + el;
                if(hash.get(above) != null && !set.contains(key)) {
                    set.add(key);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
