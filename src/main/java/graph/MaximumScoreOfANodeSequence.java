package graph;

import java.util.*;

public class MaximumScoreOfANodeSequence {
    public static void main(String[] args) {

        var in = new MaximumScoreOfANodeSequence();
        int[] scores = {14,12,10,8,1,2,3,1};

        int[][] edges = {{0,1},{0,2},{0,3},{0,4},{1,5},{1,6},{1,7},{1,2}};
        var res = in.maximumScore(scores, edges);
        System.out.println(res);
    }

    public int maximumScore(int[] scores, int[][] edges) {

        var map = new HashMap<Integer, List<Integer>>();

        for (int e[]: edges) {
            int u = e[0];
            int v = e[1];

            var uAdj = map.get(u);
            if (uAdj==null) {
                uAdj = new ArrayList<Integer>();
                map.put(u, uAdj);
            }
            uAdj.add(v);

            var vAdj = map.get(v);
            if (vAdj==null) {
                vAdj = new ArrayList<Integer>();
                map.put(v, vAdj);
            }
            vAdj.add(u);
        }

        for(int i =0; i< scores.length;i++)
        {
            Collections.sort(map.get(i), (a, b) -> (scores[b] - scores[a]));
        }

        int max = -1;

        for (int e[]: edges) {
            int u = e[0];
            int v = e[1];
            for (int i=0; i< (Math.min(3, map.get(u).size())); i++) {
                int ad = map.get(u).get(i);
                if (ad != v) {
                    for (int j=0; j< (Math.min(3, map.get(v).size())); j++) {
                        int adv = map.get(v).get(j);
                        if (adv != u && adv != ad) {
                            max = Math.max(max, scores[u] + scores[v] + scores[ad] + scores[adv]);
                        }
                    }

                }
            }
        }

        return max;
    }
}
