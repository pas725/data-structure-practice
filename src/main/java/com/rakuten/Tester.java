package com.rakuten;

import java.util.Arrays;

/*
 * Created by piyush_sagar on 9/4/19.
 */
public class Tester {
    public static void main(String[] args) {
        System.out.println(solution(50,1,1));
    }

    static class Pair implements Comparable<Pair> {
        String val;
        int count;

        Pair(String v, int c) {
            val =v;
            count = c;
        }

        public String get1() {
            count--;
            return val;
        }

        public String get2() {
            count -= 2;
            return val + val;
        }

        public String get2Or1() {
            if (count >= 2)
                return get2();
            else if (count == 1)
                return get1();
            return "";
        }

        @Override
        public int hashCode() {
            return count + val.charAt(0);
        }

        @Override
        public boolean equals(Object obj) {

            Pair p = (Pair) obj;
            return  (count == ((Pair) obj).count);
        }

        @Override
        public int compareTo(Pair o) {
            if (count == o.count)
                return 0;
            else if (count > o.count)
                return -1;
            return 1;
        }
    }

    public static String solution(int A, int B, int C) {
        // write your code in Java SE 8

        Pair arr[] = {new Pair("a", A), new Pair("b", B), new Pair("c", C)};

        Arrays.sort(arr);

        String res = combine(arr[0], arr[1]);

        if ( arr[0].count >= arr[2].count) {
            String tmp = combine(arr[0], arr[2]);
            tmp += arr[0].get2Or1();
            return res + tmp;
        } else {
            String tmp = combine(arr[2], arr[0]);
            res += tmp;
            if (arr[2].count > 0) {
                StringBuilder builder = new StringBuilder(res);
                int i = 1;
                while (arr[2].count > 0) {
                    builder.insert(i, arr[2].get1());
                    i += 2;
                }
                res = builder.toString();
            }
            return res;
        }
    }

    private static String combine(Pair pair, Pair pair1) {
        return combineUtil("", pair, pair1);
    }

    private static String combineUtil(String res, Pair c1, Pair c2) {
        if (c1.count == 0 || c2.count == 0)
            return  res;

        String tmp = "";
        if (c1.count == c2.count) {
            while (c1.count > 0) {
                tmp += c1.get2Or1() + c2.get2Or1();
            }
            return res + tmp;
        }

        return combineUtil(res + c1.get2Or1() + c2.get1(), c1, c2);
    }
}
