package onlinejudge.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 2/17/2018.
 */
public class IncresingSubsequence {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fline = br.readLine();
        String fArray[] = fline.split(" ");
        int n = Integer.parseInt(fArray[0]);
        int k = Integer.parseInt(fArray[1]);
        int arr[] = new int[n];
        String line = br.readLine();
        String vals[] = line.split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(vals[i]);
        }

        Map<String, Integer> hash = new HashMap<>();

        int mainEnergy = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int l = 1;
                int runner = j+1;
                int energy = arr[j] - arr[i];
                int localEnergy = 0;
                if (j+(k-1) < n) {
                    String key = (j+1)+ "-" + (j+(k-1));
                    Integer val = hash.get(key);
                    if (val != null) {
                        localEnergy = val;
                    } else {
                        while (l < k - 1) {
                            localEnergy += arr[runner] - arr[runner - 1];
                            runner++;
                            l++;
                        }
                        hash.put(key, localEnergy);
                    }
                }
                if (energy+localEnergy > mainEnergy) {
                    mainEnergy = energy+localEnergy;
                }
            }
        }
        System.out.println(mainEnergy);
    }
}
