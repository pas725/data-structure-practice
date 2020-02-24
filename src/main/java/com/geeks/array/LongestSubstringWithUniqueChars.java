package com.geeks.array;

/*
 * Created by piyush_sagar on 8/7/19.
 */
public class LongestSubstringWithUniqueChars {
    public static void main(String[] args) {
        String input = "GEEKSFORGEEKS";
        int res = getLongestSubstringWithUniqueChars(input);

        System.out.println("  " + res);
    }

    private static int getLongestSubstringWithUniqueChars(String input) {
        String in = input.toLowerCase();
        int visited[] = new int[26];



        for (int i=0; i<26; i++) {
            visited[i] = -1;
        }

        visited[getIndex(in.charAt(0))] = 0;
        int maxLen = 0;
        int currLen = 1;

        for (int i=1; i<in.length(); i++) {
            char c = in.charAt(i);
            int prevIndex = visited[getIndex(c)];

            if ( prevIndex == -1 || i-currLen > prevIndex) {
                currLen++;
            } else {
                if (maxLen < currLen) {
                    maxLen = currLen;

                }
                currLen = i - prevIndex;
            }
            visited[getIndex(c)] = i;
        }
        if (maxLen < currLen)
            maxLen = currLen;
        return maxLen;
    }

    private static int getIndex(char c) {
        return c - 'a';
    }
}
