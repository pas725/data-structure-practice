package com.arrays;

/**
 * Created by psagar on 9/11/2017.
 */
public class StringPermutation {
    public static void main(String[] args) {
        permute("","abc");
    }

    public static void permute(String res, String str) {
        if (str.length() <= 1) {
            System.out.println(res + str);
            return;
        }

        for(int i=0; i<str.length();i++) {
            String tmpRes = res + str.charAt(i);
            String tmpStr = "";
            if(i>0)
                tmpStr += str.substring(0, i);
            if(i < str.length()-1)
                tmpStr += str.substring(i+1);
            permute(tmpRes, tmpStr);
        }
    }
}
