import java.math.BigInteger;
import java.util.*;

/**
 * Created by psagar on 11/9/2017.
 */
public class Tester {
    public static void main(String[] args) {
        HashMap<Employee, String> map = new HashMap<>();
        Employee e = new Employee("a", 10);
        map.put(e, "s1");
        e.setName("b");
        map.put(e, "s2");

        Integer a = 128;
        Integer b = 128;

        System.out.println(a == b);
        //System.out.println(map.size());
        //System.out.println(map.get(e));
        List<? extends Number> ln = new ArrayList<Integer>();
        // ln.add(8);
        // call(() -> {});
        //new Java8test().method2();
        //System.out.println(fibonacciModified(0,1,10).toString());
        System.out.println(exceptionTest(5));
    }

    static int exceptionTest(int a) {
        try {
            a = a + 3;
            return a + 3;
        } finally {
            return a + 2;
        }
    }

    static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Complete this function
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        for (int i=3; i<=n; i++) {
            sum = a.add (b.multiply(b));
            a = b;
            b = sum;
        }
        return sum;
    }

    static void call(Callback callback) {
        callback.call();
    }
}

interface Callback {
    void call();
    default void method2() {
        System.out.println("defaiult called");
    }
}

class Java8test implements Callback {

    @Override
    public void call() {

    }


}

class Employee {
    private String name;
    private int id;

    public Employee() {
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int name = this.name == null ? 0 : this.name.hashCode();
        return 50 + name * this.id;
    }
}