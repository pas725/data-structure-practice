import java.util.List;

public class UniqueSumCombination {
    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        usc(arr, "", 0, 0, t);
    }

    private static void usc(int[] arr, String s, int i, int sum, int t) {
        if (i>=arr.length || sum > t)
            return;

        if (sum == t)
            System.out.println(s);

        usc(arr,s + " " + arr[i], i+1, sum+arr[i], t);
        usc(arr, s, i+1, sum, t);
    }
}
