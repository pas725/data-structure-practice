package onlinejudge.codility;

/**
 * Created by psagar on 2/4/2018.
 */
public class MissingElement {
    public static void main(String[] args) {
        int arr[] = {2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length + 1;
        long totalSum = (n * (n+1))/2;
        long arrSum = 0;
        for(int el : A) {
            arrSum += el;
        }

        if (arrSum == totalSum) {
            return 1;
        }
        return 0;
    }
}
