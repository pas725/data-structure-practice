package graph;

import java.util.*;

public class CriticalConnections {

    public static void main(String[] args) {
        int edges[][] = {{0,1},{1,2},{2,0},{1,3}};
        int n =4;
        List<List<Integer>> connections = new ArrayList<>();
        for (int e[] : edges) {
            connections.add(Arrays.asList(e[0], e[1]));
        }

        var res = new CriticalConnections().criticalConnections(n, connections);
        System.out.println(res);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (var edge: connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            map.get(u).add(v);
            map.get(v).add(u);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        var low = new int[n];
        var tim = new int[n];

        for (int i=0; i<n; i++) {
            if (low[i] ==0)
                dfs(i, map, low, tim, -1, res, 1);
        }

        return res;
    }

    void dfs(int v, Map<Integer, List<Integer>> adj, int low[], int tim[], int par, List<List<Integer>> res, int timer) {
        low[v] = timer;
        tim[v] = timer++;

        for (int ad : adj.get(v)) {
            if (ad == par)
                continue;

            if (low[ad] == 0) {
                dfs(ad, adj, low, tim, v, res, timer);
                low[v] = Math.min(low[v], low[ad]);

                if (tim[v] < low[ad]) {
                    var l = new ArrayList<Integer>();
                    l.add(v); l.add(ad);
                    res.add(l);
                }
            } else  {
                low[v] = Math.min(low[v], tim[ad]);
            }
        }
    }
}
