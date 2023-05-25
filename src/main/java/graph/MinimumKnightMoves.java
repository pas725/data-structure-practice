package graph;

import java.util.*;

// https://leetcode.ca/all/1197.html
public class MinimumKnightMoves {
    public static void main(String[] args) {
        boolean passed = true;
        passed &= minimumMoves(5, 5) == 4;
        passed &= minimumMoves(2, 1) == 1;
        System.out.println("Test passed: " + passed);
    }

    private static int minimumMoves(int endX, int endY) {
        var endP = Pair.of(endX, endY);
        Set<Pair> vis = new HashSet<>();
        int x = 0;
        int y = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(Pair.of(x,y));
        int dis = 0;

        int xArr[] = {2, 2, 1, -1, 1, -1, -2, -2};
        int yArr[] = {1, -1, -2, -2, 2, 2, 1, -1};

        while (!queue.isEmpty()) {

            int size = queue.size();
            int i = 0;
            while(i < size) {
                var p = queue.poll();
                vis.add(p);
                if (p.equals(endP))
                    return dis;
                for (int j = 0; j<8; j++) {
                    var newPair = Pair.of(p.x + xArr[j], p.y + yArr[j]);
                    if (!vis.contains(newPair))
                        queue.add(newPair);
                }
                i++;
            }
            dis++;
        }
        return -1;
    }

    private static String makeKey(int x, int y) {
        return x + ":" + y;
    }


}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Pair of(int x, int y) {
        return new Pair(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
