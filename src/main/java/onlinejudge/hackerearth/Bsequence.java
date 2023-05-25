package onlinejudge.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by psagar on 2/17/2018.
 */
public class Bsequence {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String line = br.readLine();
        String vals[] = line.split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(vals[i]);
        }

        TreeSet<Integer> incresing = new TreeSet<>();
        TreeSet<Integer> decresing = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        int max = 0;
        for (int i=0; i<arr.length; i++) {
            int v = arr[i];
            if (max < v) {
                max = v;
                incresing.add(v);
            } else {
                decresing.add(v);
            }
        }
        arr = null;

        int q = Integer.parseInt(br.readLine());
        int inc = incresing.size();
        int dec = decresing.size();
        for (int j=0; j<q; j++) {
            int val = Integer.parseInt(br.readLine());
            if (val > max) {
                incresing.add(val);
                inc++;
                max = val;
            } else if (val < max) {
                if (!incresing.contains(val)) {
                    incresing.add(val);
                    inc++;
                } else if (!decresing.contains(val)) {
                    decresing.add(val);
                    dec++;
                }
            }
            System.out.println(inc + dec);
        }
        print2(incresing);
        print2(decresing);
    }



    public static void print2(TreeSet<Integer> set) {
        StringBuilder b = new StringBuilder();
        for(int e : set) {
            b.append(e + " ");
        }
        System.out.print(b);
    }


}
