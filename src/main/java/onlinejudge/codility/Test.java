package onlinejudge.codility;

/**
 * Created by psagar on 2/3/2018.
 */
public class Test {
    static String str;
    void Test() {
        str = "abc";
    }

    public static void main(String[] args) {
        Float f = new Float("3.0");
        int x = f.intValue();
        byte b = f.byteValue();
        double d = f.doubleValue();
        System.out.println(x + b + d);
    }

    public static void print(int arr[]) {
        for (int el : arr) {
            System.out.print(" " + el);
        }
    }

    public static int[] fib(int n) {
        if (n == 0) {
            return new int[0];
        }

        if (n==1) {
            int arr[] = {0};
            return arr;
        }

        if (n==2) {
            int arr[] = {0,1};
            return arr;
        }

        int res[] = new int[n];
        res[0] = 0;
        res[1] = 1;
        for(int i=2; i<n; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res;

    }
}
