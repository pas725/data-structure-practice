package misc.jvmperformance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by psagar on 4/4/2018.
 */
public class JvmPerformanceTester {
    static int limit =  Integer.MAX_VALUE/10;
    public final static void main(String[] args) throws InterruptedException {
        // String str[] = new String[limit];
        // fillArray(str);
        List<String> list = new ArrayList<>();
        //fillList(list);
        // print(list);
    }

    static void print(String arr[]) {
        for(String val : arr) {
            System.out.println(val);
        }
    }

    static void print(List<String> arr) {
        for(String val : arr) {
            System.out.println(val);
        }
    }

    static void fillArray(String arr[]) throws InterruptedException {
        for(int i=1; i<limit; i++) {
            arr[i] = String.valueOf(i + "performance test...");
            System.out.println(i);
            Thread.sleep(500);
        }
    }

    static void fillList(List<String> arr) throws InterruptedException {
        for(int i=1; i<limit; i++) {
            arr.add(String.valueOf(i + "performance test..."));
            //System.out.println(i);
            if (arr.size() % 100000 == 0) {
                System.out.println("Sleeping for 2 sec ...");
                Thread.sleep(2000);
            }
        }
    }

    public void call(int a) throws NullPointerException {}

    public int call(int a, int b) throws Exception{
        return 0;
    }

}
