package com.geeks;

import java.util.LinkedList;
import java.util.List;

/*
 * Created by piyush_sagar on 4/7/19.
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 *
 */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String stream = "geeksforgeeksandgeeksquizfor";

        System.out.println(stream);
        System.out.println("");
        findFirstNonRepeatingChar(stream);
    }

    private static void findFirstNonRepeatingChar(String stream) {

        boolean rep[] = new boolean['z'-'a'+1];

        List<Character> ll = new LinkedList<>();

        for (int i=0; i<stream.length(); i++) {
            char x = stream.charAt(i);
            if (!rep[x - 'a']) {
                if (!ll.contains(x)) {
                    ll.add(x);
                } else {
                    rep[x - 'a'] = true;
                    ll.remove(new Character(x));
                }
            }

            if (ll.size() > 0) {
                System.out.print(ll.get(0) + "");
            }
        }
    }
}
