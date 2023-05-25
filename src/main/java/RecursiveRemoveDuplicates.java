

public class RecursiveRemoveDuplicates {
    public static void main(String[] args) {
        var s = "abaa";
        var res = permute(s);
        System.out.println(res);
    }

    private static String permute(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        var i = 0;

        if (s.charAt(i) == s.charAt(i+1)) {
            int j = i+1;
            while (j < s.length() && s.charAt(i) == s.charAt(j))
                j++;
            return permute(s.substring(j));
        } else {
            var start = s.charAt(0) + "";
            var end = permute(s.substring(1));
            if (end.length() > 0 && start.equals(end.charAt(0)+""))
                return permute(start + end);
            return start + permute(end);
        }
    }
}
