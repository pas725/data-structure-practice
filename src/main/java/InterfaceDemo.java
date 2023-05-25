/**
 * Created by psagar on 5/16/2018.
 */
import static java.lang.System.out;

interface Sample {

    default void speak() { out.println("Hello from interface.");}
    void exec();
}
public class InterfaceDemo {
    public void speak() {
        out.println("Hello from Class.");
    }

    public void go() {
        Sample s = () -> this.speak();
        s.exec();
    }

    public static void main(String[] args) {
        new InterfaceDemo().go();
    }
}
