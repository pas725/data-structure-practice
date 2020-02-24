package com.rakuten;

/*
 * Created by piyush_sagar on 9/1/19.
 * https://github.com/vuamitom/Code-Exercises/blob/master/rakuten/rakuten_test.png
 */
public class Rectlinear {
    public static void main(String[] args) {
        int res = calcArea(-4,1,2,6,0,-1,4,3);

        System.out.println(res);
    }

    static  boolean isWithin(int point, int a, int b) {
        return point >= a && point <= b;
    }

    public static int calcArea(int x1, int y1, int x2, int y2,
                               int a1, int b1, int a2, int b2) {

        int r1L = Math.abs(x2-x1);
        int r1H = Math.abs(y2-y1);

        int r2L = Math.abs(a2-a1);
        int r2H = Math.abs(b2-b1);

        int r3L = 0;
        int r3H = 0;

        if (isWithin(a1, x1, x2) && isWithin(a2, x1, x2)) {
            r3L = x2 - a1 - (x2 - a2);
        } else {
            if (isWithin(a1, x1, x2))
                r3L = x2 - a1;
            else if (isWithin(a2, x1, x2))
                r3L = a2 - x1;
        }

        if (isWithin(b1, y1, y2) && isWithin(b2, y1, y2)) {
            r3H = y2 - b1 - (y2 - b2);
        } else {
            if (isWithin(b1, y1, y2))
                r3H = y2 - b1;
            else if (isWithin(b2, y1, y2))
                r3H = b2 - y1;
        }

        int area = (r1L * r1H) + (r2L * r2H) - (r3L * r3H);


        return area;
    }
}
