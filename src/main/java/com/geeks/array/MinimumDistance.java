package com.geeks.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by piyush_sagar on 11/2/19.
 */
public class MinimumDistance {
    public static void main(String[] args) {
        int in[] = {7,1,3,4,1,7};
        int res = minimumDistances(in);
        System.out.println(res);
    }

    static int minimumDistances(int[] a) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            List<Integer> list = map.get(a[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(a[i], list);
            }
            list.add(i+1);
        }

        int min = Integer.MAX_VALUE;

        for (List<Integer> l : map.values()) {
            if (l.size() > 1) {
                for (int i=0; i<l.size()-1; i++) {
                    int dis = l.get(i+1) - l.get(i);
                    if (dis < min)
                        min = dis;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
