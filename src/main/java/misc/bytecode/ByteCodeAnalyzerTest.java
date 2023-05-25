package misc.bytecode;

/**
 * Created by psagar on 4/13/2018.
 */
public class ByteCodeAnalyzerTest {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6};

    }

    static void sum(int arr[]) {
        int sum = 0;
        for (int el : arr) {
            sum += el;
        }
    }

    static void sumSimple(int arr[]) {
        int sum = 0;
        for (int i=0; i<= arr.length; i++) {
            sum += arr[i];
        }
    }
}
