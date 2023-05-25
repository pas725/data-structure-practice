package onlinejudge.hackerrank;

import java.util.*;

/**
 * Created by psagar on 3/2/2018.
 * https://www.hackerrank.com/challenges/missing-numbers/problem
 */
public class MissingNumbers {
    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function
        Map<Integer, Frequency> hash = new HashMap<>();
        for (int el : arr) {
            Frequency frequency = hash.get(el);
            if (frequency == null) {
                frequency = new Frequency();
                hash.put(el, frequency);
            }
            frequency.incrementListA();
        }

        for (int el : brr) {
            Frequency frequency = hash.get(el);
            if (frequency == null) {
                frequency = new Frequency();
                hash.put(el, frequency);
            }
            frequency.incrementListB();
        }

        List<Integer> list = new ArrayList<>();
        hash.forEach((k,v) -> {
            if(!v.isFrequencySame()) {
                list.add(k);
            }
        });

        Collections.sort(list);
        int[] res = new int[list.size()];
        int i=0;
        for (int el : list) {
            res[i++] = el;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

    static class Frequency {
        int listA = 0;
        int listB = 0;

        public Frequency() {listA=0;listB=0;}

        public void incrementListA() {
            listA++;
        }

        public void incrementListB() {
            listB++;
        }

        public int getListA() {
            return listA;
        }

        public int getListB() {
            return listB;
        }

        public boolean isFrequencySame() {
            return listA == listB;
        }
    }
}
