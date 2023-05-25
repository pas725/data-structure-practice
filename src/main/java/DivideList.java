import java.util.*;

public class DivideList {
    public static void main(String[] args) {
        var map = new HashMap<Integer, List<Integer>>();
        map.put(0, Arrays.asList(3));
        map.put(1, Arrays.asList(2));
        map.put(2, Arrays.asList(1, 3, 4));
        map.put(3, Arrays.asList(0, 2, 4, 5));
        map.put(4, Arrays.asList(2, 3));
        map.put(5, Arrays.asList(3));

        boolean res = divide(map);
        System.out.println(res);
    }

    private static boolean divide(HashMap<Integer, List<Integer>> map) {
        var v1 = new HashSet<Integer>();    var e1 = new HashSet<Integer>();
        var v2 = new HashSet<Integer>();    var e2 = new HashSet<Integer>();

        for (int k : map.keySet()) {
            var e = map.get(k);
            var tmpSet1 = new HashSet<>(v1);
            var tmpSet2 = new HashSet<>(v2);
            if (!e1.contains(k) && !tmpSet1.removeAll(e)) {
                v1.add(k);
                e1.addAll(e);
            } else if (!e2.contains(k) && !tmpSet2.removeAll(e)) {
                v2.add(k);
                e2.addAll(e);
            } else {
                return false;
            }
        }

        return true;
    }
}
