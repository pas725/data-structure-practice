public class MinPartionSubset {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};
        int sum = 23;
        int res = rec(arr, 0, 0, 23);
        System.out.println(res);

        printAllSubsets(arr, 0, "");
    }

    private static void printAllSubsets(int[] arr, int i, String s) {
        if (i == arr.length) {
            System.out.println(s);
            return;
        }

        printAllSubsets(arr, i+1, s);
        printAllSubsets(arr, i+1, s+arr[i] + ",");
    }

    private static int rec(int[] arr, int i, int cs, int ts) {
        if (i==arr.length)
            return Math.abs((ts-cs) - cs);

        int b = rec(arr, i+1, cs, ts);
        int c = rec(arr, i+1, cs+arr[i], ts);

        return Math.min(b, c);
    }
}
