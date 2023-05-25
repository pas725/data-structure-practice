import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        var s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        var res = wordBreak(s, wordDict);

        res.stream().forEach(System.out::println);
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        int maxLen = 0;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }
        int n = s.length();
        call("", s, 0, maxLen, n, wordDict, res);
        return res;
    }

    public static void call(String pre, String s, int i, int ml, int n, List<String> wordDict, List<String> res) {
        if (i == n && s.length() == 0) {
            res.add(pre);
            return;
        }

        if (i>=n)
            return;

        for (int k=i; k<i+ml; k++) {
            String str = s.substring(i,k);
            if (wordDict.contains(str)) {
                call(pre + str + " ", s.substring(k), k, ml, n, wordDict, res);
            }
        }
    }
}
