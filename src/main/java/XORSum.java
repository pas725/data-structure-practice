import java.util.Scanner;

/**
 * Created by psagar on 9/27/2017.
 */
public class XORSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        long arr[] = new long[Q];
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            arr[a0] = getXORSum(L, R);
        }
        /*int arr[] = new int[50];
        arr[0] = 0;
        for (int i=1;i<arr.length;i++) {
            arr[i] = arr[i-1] ^ i;
        }

        */
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static long getXORSum(long from, long to) {
        long index = from;
        while (index % 4 != 0) {
            index--;
        }

        long sum = 0;
        for (long i=index+1; i<from ;i++) {
            sum = sum ^ i;
        }

        long res[] = new long[(int) (to-from+1)];
        long arrIndex = 0;
        for(long j=from; j<=to; j++) {
            if (j==from) {
                res[(int)arrIndex++] = sum ^ j;
            } else {
                res[(int)arrIndex++] = res[(int)arrIndex-1] ^ j;
            }
        }

        long resSum = res[0];
        for(long i=1 ; i<res.length ;i++) {
            resSum = resSum ^ res[(int)i];
        }

        return sum;
    }
}
