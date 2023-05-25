package onlinejudge.codility;

/**
 * Created by psagar on 2/9/2018.
 * https://app.codility.com/c/run/trainingV36YPK-SP9
 */
public class PassingCars {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1};
        System.out.println(solution(arr));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length-1;
        long numPassing = 0;
        int numOnes = 0;

        for(int i=length; i>=0; i--) {
            if (A[i] == 1) {
                numOnes++;
            } else if (A[i] == 0) {
                numPassing += numOnes;
            }
        }

        if (numPassing > 1000000000) {
            return -1;
        }
        return (int) numPassing;
    }
}
