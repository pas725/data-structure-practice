/**
 * Created by psagar on 2/23/2018.
 */
public class ThreadTest {
     static synchronized void test() {
        for (int i=0 ;i<10 ;i++) {
            try {
                Thread.sleep(500);
                System.out.println(" In method 1 : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     synchronized void test2() {
        for (int i=0 ;i<10 ;i++) {
            try {
                Thread.sleep(500);
                System.out.println(" In method 2 : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new NullPointerException();
    }
}

class Test {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(() -> {
            t.test();
        });

        Thread t2 = new Thread(() -> {
            t.test2();
        });

        t1.start();
        t2.start();
    }
}
