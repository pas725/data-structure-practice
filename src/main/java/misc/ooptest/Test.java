package misc.ooptest;

/**
 * Created by psagar on 2/2/2018.
 */
abstract class Work {
    public Work() {
        System.out.println("In abstract work Const");
    }

    public void doWork() {
        System.out.println("In abstract work");
    }
}


class ConWork extends Work {
    ConWork() {
        System.out.println("In ConWork Const");
    }

    public void doWork() {
        System.out.println("In ConWork work");
    }
}

public class Test {
    public static void main(String[] args) {
        //Work c = new ConWork();
        //c.doWork();
        InTest i = new InTest();

    }
}

interface T1 {
    public int sum();
}

interface T2 {
    public double sum();
}

class InTest implements T1 {

    @Override
    public int sum() {
        return 0;
    }
}