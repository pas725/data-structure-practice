package graph;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-to-connect-all-points/submissions/
public class MinCostConnectAllPoint {

    public static void main(String[] args) {
        int input[][] = {{0,0},{1,1},{1,0},{-1,1}};
        int res = new MinCostConnectAllPoint().minCostConnectPoints(input);
        System.out.println(res);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1)
            return 0;
        int dis[] = new int[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(dis, 9999999);
        dis[0] = 0;

        for (int i=0; i<n; i++) {
            int u = findMin(dis, vis, n);
            int x1 = points[u][0];
            int y1 = points[u][1];
            vis[u] = true;
            for (int j=0; j<n; j++) {
                if (u!=j && !vis[j]) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int val = Math.abs(x1-x2) + Math.abs(y1-y2);
                    dis[j] = Math.min(dis[j], val);
                }
            }
        }

        int sum = 0;
        for (int i : dis)
            sum += i;
        return sum;
    }

    public int findMin(int dis[], boolean vis[], int n) {
        int min = 999999;
        int index = -1;
        for (int i=0; i<n; i++) {
            if (!vis[i] && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        return index;
    }
}
