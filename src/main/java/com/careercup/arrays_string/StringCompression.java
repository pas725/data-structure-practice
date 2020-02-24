package com.careercup.arrays_string;

/*
 * Created by piyush_sagar on 3/14/19.
 *  Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    "compressed "string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z)
 */
public class StringCompression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        String compressed = compress(input);
        System.out.println("Compressed String : " + compressed);
    }

    private static String compress(String input) {
        StringBuilder builder = new StringBuilder("");
        int length = input.length();
        for (int i=0; i<length; ) {
            char c = input.charAt(i);
            int count = 0;
            while (i<length && input.charAt(i) == c) {
                i++;
                count++;
            }
            builder.append(c);
            builder.append(count);
        }
        String res = builder.toString();
        return res.length() < length ? res : input;
    }
}
