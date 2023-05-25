/**
 * Created by psagar on 3/15/2018.
 */
public class BlockTester {
    int a;
    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Normal block 1 :" + a);
    }

    BlockTester() {
        a = 10;
        System.out.println("In constructor");
    }

    {
        Integer i = 3;
        final int x;
        x=5;
        System.out.println("Normal block 2 :" + (i instanceof Object));
    }

    public static void main(String[] args) {
        BlockTester blockTester = new BlockTester();
    }
}
