package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Point {
    int time;
    int cnt;
    char c;

    public Point(char c, int t, int cnt) {
        this.time = t;
        this.c = c;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Point{" +
                "time=" + time +
                ", cnt=" + cnt +
                ", c=" + c +
                '}';
    }
}


public class TaskScheduler {

    public static void main(String[] args) {
        char[] chars = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int exp = 16;
        int n = 2;
        int res = leastInterval(chars, n);

        System.out.println(res);
     }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c: tasks) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            int d = a.time - b.time;
            if (d == 0)
                return a.cnt - b.cnt;
            return d;
        });


        m.forEach( (k,v) -> pq.offer(new Point(k, 1, v)));

        int i = 1;
        while (!pq.isEmpty()) {

            if (i >= pq.peek().time) {
                var p = pq.poll();
                System.out.println("Picked up: " + p);
                if (p.cnt > 1) {
                    p.time = i + n + 1;
                    p.cnt -= 1;
                    pq.offer(p);
                }
            }
            i++;
        }
        return i-1;
    }
}
