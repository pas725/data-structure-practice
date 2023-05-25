import java.lang.invoke.VarHandle;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        var s = new SolutionSALS();
        int in[] = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};

        int res = s.splitArray(in, 8);
        System.out.println(res);
    }
}

class SolutionSALS {
    int min = 99999999;
    public int splitArray(int[] nums, int m) {
        int n= nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        int res = sp(0, m, n, nums, total);
        min = Math.min(min, res);
        return min;
    }

    public int sp(int i, int k, int n, int arr[], int total) {
        if (i==n)
            return 0;

        if (k==1) {
            return total;
        }

        int psum = 0;
        int mx = -999;
        for (int j=i; j<n-k; j++) {
            int lmax = -999;
            psum += arr[j];
            int rsum = sp(j+1, k-1, n, arr, total-psum);
            lmax = Math.max(lmax, psum);
            lmax = Math.max(lmax, rsum);
            min = Math.min(min, lmax);
            mx = Math.max(lmax, mx);
        }
        return mx;
    }
}
