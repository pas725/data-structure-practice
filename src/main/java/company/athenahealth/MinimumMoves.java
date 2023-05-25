package company.athenahealth;

/**
 * Created by psagar on 2/23/2018.
 */
public class MinimumMoves {

    public static void main(String[] args) {
        int a[] = {1234, 4321};
        int m[] = {2345, 3214};
        System.out.println(minMoves(a, m));
    }

    static int minMoves(int a[], int m[]) {
        int len  = a.length;
        int minMoves = 0;
        for (int i=0; i<a.length; i++) {
            minMoves += minMovesForSingle(a[i], m[i]);
        }
        return minMoves;
    }

    static int minMovesForSingle(int a, int m) {
        String numA = Integer.toString(a);
        String numM = Integer.toString(m);
        int[] arrA = new int[numA.length()];
        int[] arrM = new int[numM.length()];
        for (int i = 0; i < numA.length(); i++)
        {
            arrA[i] = numA.charAt(i) - '0';
            arrM[i] = numM.charAt(i) - '0';
        }
        int moves = 0;
        for (int i=0; i<arrA.length; i++) {
            moves += Math.abs(arrM[i] - arrA[i]);
        }
        return moves;
    }
}
