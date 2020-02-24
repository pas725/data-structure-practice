import java.util.*;
import java.util.stream.Collectors;

/*
 * Created by piyush_sagar on 11/14/19.
 */
public class Tester {
    public static void main(String[] args) {
        int arr[] =  {10, 8, 18, 5, 3, 1, 7, 9};

        int res = maxProfit(arr);
        System.out.println(res);
        // n + n

        // ltrMin[], rtolMax[]
        // Iteratre
        // ltrMin = [10, 8, 8, 5, 5, 5, 3, 3]
        // rtlMax = [18, 18, 18, 16, 16 ,9 ,9, 9]

        List<Object> l = new ArrayList<>();
        l.add(5);
        //l.add();
        l.add("kk");
        Map<Integer, List<Integer>> m = new HashMap<>();

        m.keySet().stream().max((o1, o2) -> o1 > o2 ? 1 : -1);
        m.values().stream().mapToInt(ll -> ll.size()).max().getAsInt();

        String s = "lkl";
        Map<Character, Integer> mm = s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(c -> c, c -> 1, (a, b) -> a + b));

        Collections.emptyMap();
        //Object
    }

    static int maxProfit(int A[]) {
        int max = 0;
        int i=0;
        while (i<A.length) {
            int cur = A[i];
            int j = i+1;
            while (j < A.length && A[j] > cur) {
                max = Math.max(max, A[j] - cur);
                j++;
            }
            i = j;
        }
        return max;
    }
}
