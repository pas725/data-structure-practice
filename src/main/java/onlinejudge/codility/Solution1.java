package onlinejudge.codility;

import java.util.*;

/**
 * Created by psagar on 1/27/2018.
 */
public class Solution1 {
    public static void main(String[] args) {
        //int arr[] = {1,8,-3,0,1,3,-2,4,5};
        int arr[] = {1,1,-1,1};
        //System.out.println(kArray(6,arr));
        System.out.println(pawnJump(arr));
    }

    public static int kArray(int K, int[] A) {
        // write your code in Java SE 8
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int arrLen = A.length;
        Set<String> set = new HashSet<>();
        for (int i=0; i<arrLen; i++) {
            List<Integer> list = hash.get(A[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            hash.put(A[i], list);
        }

        for (int i=0; i<arrLen; i++) {
            int val = A[i];
            int expected = K - val;
            List<Integer> list = hash.get(expected);
            if (list != null) {

                for (Integer el : list) {
                    set.add(i+""+el.toString());
                }
            }
        }
        return set.size();
    }

    public static int pawnJump(int A[]) {
        int jumps = 1;
        int length = A.length;
        int maxAttempt = length/2;
        Map<Integer, Integer> visited = new HashMap();
        int val = A[0];
        int offset = val + 0;
        visited.put(0, 1);
        while (true) {
            if (offset < length && offset >= 0 && visited.size() < length) {
                val = A[offset];
                Integer offCnt = visited.get(offset);
                visited.put(offset, offCnt == null ? 0 : offCnt + 1);
                if (visited.size() == length || visited.get(offset) > maxAttempt) {
                    return -1;
                }
                offset = offset + val;
                jumps++;

            } else {
                return jumps;
            }
        }
    }
}
