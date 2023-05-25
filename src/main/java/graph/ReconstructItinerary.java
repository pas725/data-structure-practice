package graph;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/description/
public class ReconstructItinerary {

    public static void main(String[] args) {

        var tockets = tes2();
        var res = findItinerary(tockets);
        System.out.println(res);
    }

    static List<List<String>> test1() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK","SFO"));
        tickets.add(List.of("JFK","ATL"));
        tickets.add(List.of("SFO","ATL"));
        tickets.add(List.of("ATL","JFK"));
        tickets.add(List.of("ATL","SFO"));

        return tickets;
    }

    static List<List<String>> tes2() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC","LHR"));
        tickets.add(List.of("JFK","MUC"));
        tickets.add(List.of("SFO","SJC"));
        tickets.add(List.of("LHR","SFO"));
        return tickets;
    }


    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Node>> map = new HashMap<>();
        for (List<String> t : tickets) {
            String u = t.get(0);
            String v = t.get(1);
            var adj = map.get(u);
            if (adj == null) {
                adj = new ArrayList<Node>();
            }
            adj.add(new Node(v, false));
            map.put(u, adj);

            if (map.get(v) == null) {
                map.put(v, new ArrayList<Node>());
            }
        }

        map.forEach((k,  v) -> Collections.sort(v, Comparator.comparing(Node::getV)));

        Node s = new Node("JFK", false);
        var res = new ArrayList<String>();
        dfs(s, tickets.size(), map, res);
        return res;
    }

    static void  dfs(Node u, int n, Map<String, List<Node>> adj, List<String> res) {
        u.vis = true;

        res.add(u.v);
        boolean proc = false;
        for (Node a : adj.get(u.v)) {
            if (!a.vis) {
                proc = true;
                dfs(a, n, adj, res);
            }
        }

        if (res.size()!=n+1) {
            res.remove(res.size()-1);
            u.vis = false;
        }
    }

    static class Node {
        String v;
        boolean vis;

        public Node(String v, boolean vis) {
            this.v = v;
            this.vis = vis;
        }

        public String getV() {
            return v;
        }
    }
}


