package misc.threads;

/**
 * Created by psagar on 5/4/2018.
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Worker implements Runnable {

    Integer intVal = null;
    ThreadLocal<Integer> val = new ThreadLocal<>();
    @Override
    public void run() {

        intVal = (int) (Math.random() * 100D);
        val.set((int) (Math.random() * 100D));
        System.out.println("     Normal val :" + intVal);
        System.out.println("ThreadLocal val :" + val.get());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
