package com.ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created by piyush_sagar on 2/17/19.
 */
public class RemoteInterview {
    public static void main (String[] args) throws java.lang.Exception
    {
        permute("","abc");
    }

    static void  readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
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
