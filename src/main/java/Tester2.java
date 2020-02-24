/*
 * Created by piyush_sagar on 11/14/19.
 */
public class Tester2 {
    int x;

    public static void main(String[] args) {
        // (()())(())
        // ()()()

        // ((())) -> (())
        // ()() -> ""
        // ((()) ())
        String in = "((())())"; // (())()
        String res = removeOuterBrackets(in);
        //System.out.println(res);
        Tester2 t = new Tester2();
        t.multiThreadTest();
    }

    static String removeOuterBrackets(String in) {
        if (in == null || in.length() == 0)
            return "";

        int ob = 0;
        int cb = 0;

        int i=0;
        String res = "";
        while (i<in.length()) {
            char c = in.charAt(i);
            ob++;
            int j= i+1;
            while (ob != cb && j < in.length()) {
                char tmp = in.charAt(j);
                if (tmp == '(')
                    ob++;
                else if (tmp == ')')
                    cb++;
                j++;
            }

            if (ob != 1 && cb == ob)
                res += in.substring(i+1, j-1);
            i = j;
        }
        return res;
    }

    void multiThreadTest() {
        f();
        int i=0;
        while (i<5) {
            Thread t1 = new Thread(() -> f());
            t1.start();
            i++;
        }

//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(x);
    }

    void f() {
        for (int i=0; i<5; i++) {
            x++;
        }
    }
}
