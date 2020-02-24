package com.geeks;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by piyush_sagar on 3/27/19.
 */
public class PossibleIPAddress {
    static int cnt = 0;
    public static void main(String[] args) {
        String ip = "25505011535";

        List<String> list = new ArrayList<>();
        permuteIPAddress("", ip, 0, list);
        System.out.println(list.toString());
        System.out.println("Call count : " + cnt);
    }

    private static void permuteIPAddress(String res, String ip, int level, List<String> list) {
        cnt++;
        if (ip.length() == 0) {
            list.add(res);
            return ;
        }
        if (level < 3) {

            for (int i=0; i<3; i++) {
                String str = ip.substring(0, i+1);

                if (isValidIPChunk(str)) {
                    String tmp = res + str + ".";
                    permuteIPAddress(tmp, ip.substring(i+1), level+1, list);
                }
            }
        } else {
            if (isValidIPChunk(ip)) {
                list.add(res + ip);
                return ;
            }
        }
    }

    private static boolean isValidIPChunk(String str) {
        if (str.length() <= 3 ) {
            int num = Integer.parseInt(str);
            if (num < 0 || num > 255 || (num == 0 && str.length() > 1) || (num < 100 & str.length() > 2)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
