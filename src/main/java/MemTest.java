import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MemTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Started PID=[" + ManagementFactory.getRuntimeMXBean().getPid() + "] ...");
//        testArray();
        testList();
    }

    static void testArray() throws InterruptedException {
        var start = Instant.now();
        int limit = 100_000_000;
        int arr[] = new int[limit];

        for(int i=0; i<limit; i++) {
            arr[i] = (int) (Math.random() * limit - i);
        }

        var end = Instant.now();
        var elapsed = Duration.between(start, end);

        System.out.println("Sleeping for few seconds...");
        Thread.sleep(15 * 1000);
        var index = (int) Math.random() * limit;
        System.out.println("Random item: " + arr[index]);
        System.out.println("Execution time: " + elapsed.toSeconds() + " sec");
    }

    static void testList() throws InterruptedException {
        var start = Instant.now();
        int limit = 100_000_000;
        var list = new ArrayList<Integer>();

        for(int i=0; i<limit; i++) {
            list.add((int) (Math.random() * limit - i));
        }

        var end = Instant.now();
        var elapsed = Duration.between(start, end);

        System.out.println("Sleeping for few seconds...");
        Thread.sleep(15 * 1000);
        var index = (int) Math.random() * limit;
        System.out.println("Random item: " + list.get(index));
        System.out.println("Execution time: " + elapsed.toSeconds() + " sec");
    }
}
