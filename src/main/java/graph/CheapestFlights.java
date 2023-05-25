package graph;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlights {
    public static void main(String[] args) {
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4;
        int src = 0;
        int dst = 3;
        int res = new Solution().findCheapestPrice(n, flights, src, dst, 2);
        System.out.println(res);
    }
}

class Solution {
    int min = 99999999;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Node> adj[] =  new ArrayList[n];
        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<Node>();
        }

        for (int f[]: flights) {
            int u = f[0];
            int v = f[1];
            int w = f[2];
            Node no = new Node(v, w);
            ArrayList<Node> list = adj[u];
            if (list == null) {
                list = new ArrayList<Node>();
                adj[u] = list;
            }
            list.add(no);
        }

        int max_dis = 999999999;
        int dis[] = new int[n];
        Arrays.fill(dis, max_dis);
        dis[src] = 0;
        Node sn = new Node(src, 0);
        Queue<Node> q = new LinkedList<>();
        q.add(sn);
        int i=0;
        while (i<=k && !q.isEmpty()) {
            int len = q.size();
            for (int run=0; run<len; run++) {
                Node curN = q.poll();
                int u = curN.v;
                int w = curN.w;

                for (Node adjN : adj[u]) {
                    if (w + adjN.w < dis[adjN.v]) {
                        dis[adjN.v] = w + adjN.w;

                        q.add(new Node(adjN.v, dis[adjN.v]));
                    }
                }
            }
            i++;
        }
        
        return dis[dst];

//        boolean vis[] = new boolean[n];
//        Res res = new Res();
//        dfs(src, dst, adj, k+1, 0, 0, res, vis);
//        return res.res;
    }

    public void dfs(int src, int dst, ArrayList<Node> adj[], int k, int curK, int w, Res res, boolean vis[]) {
        vis[src] = true;
        if (curK > k)
            return;

        if (src == dst) {
            res.res = Math.min(res.res, w);
            return;
        }

        for (Node a : adj[src]) {
            if (!vis[a.v])
                dfs(a.v, dst, adj, k, curK+1, a.w + w, res, vis);
        }
        vis[src] = false;
    }
}

class Node {
    public int v;
    public int w;

    public Node(int vertex,int wieght) {
        this.v = vertex;
        this.w = wieght;
    }
}

class Res {
    public int res = 99999999;
}
