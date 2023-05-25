/**
 * Created by psagar on 2/23/2018.
 */
public class OverridingTest {
    Number call(int a) {
        System.out.println("In Super " + a);
        return 0;
    }

    public static void main(String[] args) {
        OverridingTest o = new Child();
        o.call(10);
    }
}

class Child extends OverridingTest {
    Number call(Integer b) {
        System.out.println("In child " + b);
        return 0;
    }
}
