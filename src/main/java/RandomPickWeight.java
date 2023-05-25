import java.util.Arrays;
import java.util.Random;

public class RandomPickWeight {
    public static void main(String[] args) {
        int arr[] = {3,14,1,7};
        var s = new SolutionRPW(arr);

        int n = 4;
        for (int i=0; i<n; i++) {
            int ind = s.pickIndex();
            System.out.println(ind);
        }
    }
}

class SolutionRPW {
    private int[] sums;
    private int sum;
    private Random random;

    public SolutionRPW(int[] w) {
        sums = new int[w.length];
        random = new Random();
        sum = 0;

        for(int i = 0; i < w.length; i++) {
            sum += w[i];
            sums[i] = sum;
        }

    }

    public int pickIndex() {
        int value = random.nextInt(sum);

        int index = Arrays.binarySearch(sums, value);

        if(index < 0) {
            index = -(index + 1);
        } else {
            index++;
        }


        return index;
    }
}
