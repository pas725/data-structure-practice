package string;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by piyush_sagar on 3/7/19.
 * https://www.techiedelight.com/find-possible-palindromic-substrings-string/
 */
public class AllPossiblePalindrome {
    static int cnt = 0;
    public static void main(String[] args) {
        String input = "banana";
        Set<String> result = getAllPossiblePalindrome(input);
        printRes(result);
        System.out.println("Total calls : " + cnt);
    }

    private static void printRes(Set<String> result) {
        for (String res : result) {
            System.out.println(res);
        }
    }

    private static Set<String> getAllPossiblePalindrome(String input) {
        Set<String> res = new HashSet<>();
        int length = input.length();
        for (int i=0; i<input.length(); i++) {
            // find all odd length palindrome with str[i] as mid point
            insertPalindromes(i, i, length, input,res);

            // find all even length palindrome with str[i] and str[i+1]
            insertPalindromes(i, i+1, length, input, res);
        }
        return res;
    }

    private static void insertPalindromes(int i, int j, int lenght, String input,Set<String> res) {
        while (i>=0 && j<lenght && input.charAt(i) == input.charAt(j)) {
            res.add(input.substring(i,j+1));
            i--;
            j++;
            cnt++;
        }
    }
}
