public class MedianSortedArrays {
    public static void main(String[] args) {
        int i12[] = {};
        int in2[] = {2,3};

        var res = new SolutionMSA().findMedianSortedArrays(i12, in2);
        System.out.println(res);
    }
}

//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
class SolutionMSA {
    public double findMedianSortedArrays(int[] s, int[] l) {
        int m = s.length;
        int n = l.length;
        int total = m + n;

        if (m > n)
            return findMedianSortedArrays(l, s);

        int lo = 0; int hi= s.length;
        int med = (total+1) / 2;
        int max = 99999999; int min = -99999999;
        while (lo<=hi) {
            int mid = (lo+hi) / 2;
            int hLoc = med - mid;

            int x1 = mid == 0 ? min : s[mid-1];
            int x2 = hLoc == 0 ? min : l[hLoc-1];
            int y1 = mid == m ? max :s[mid];
            int y2 = hLoc == n ? max : l[hLoc];

            if (x1 <= y2 && x2 <= y1) {
                if (total % 2 == 1) {
                    return Math.max(x1, x2);
                }
                return (Math.max(x1, x2) + Math.min(y1, y2))/2.0;
            } else if (x1 > y2) {
                hi = mid-1;

            } else {
                lo = mid + 1;
            }
        }
        return 0;
    }
}