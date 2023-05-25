import java.util.TreeMap;

public class CombinationalSum {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8};
        int t = 8;
        rec(arr, 0, 0, t, "");
        new TreeMap<>().tailMap(3);
    }

    private static void rec(int[] arr, int i, int cs, int t, String res) {
        if (cs > t)
            return;

        if (cs == t)
            System.out.println(res);

        for (int r=i; r<arr.length; r++) {
            rec(arr, r, cs + arr[r], t, res + "," + arr[r]);
            rec(arr, r+1, cs, t, res);
        }
    }
}
