package com.careercup.arrays_string;

/*
 * Created by piyush_sagar on 3/14/19.
 *  Assume you have a method isSubstrin g which checks if one word is a substring
    of another. Given two strings, si and s2, write code to check if s2 is a rotation of si using only one
    call to isSubstring (e.g.,"waterbottle"isa rotation of'erbottlewat").
 */
public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean isRotation = isRotation(s1, s2);
        System.out.println("'waterbottle' rotated 'erbottlewat' : " + isRotation);
    }

    private static boolean isRotation(String s1, String s2) {
        String s2s2 = s2 + s2;
        return s2s2.contains(s1);
    }
}
