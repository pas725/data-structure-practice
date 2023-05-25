import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = {3, 1};
        int t = 1;
        int min = search(arr, t);
        System.out.println(min);
        Queue queue = new LinkedList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    }

    static public int search(int[] nums, int target) {

        int p = partition(nums);

        int n = nums.length;
        if (p == 0)
            return bin(nums, 0, nums.length-1, target);

        int lres = bin(nums, 0,p-1, target);

        if (lres == -1)
            return bin(nums, p, nums.length-1, target);
        return lres;
    }

    static int bin(int[] nums, int l, int h, int target) {
        while (l<=h ) {
            int m = (l+h)/2;

            if (nums[m] == target)
                return m;

            if (nums[m] < target)
                l = m+1;
            else
                h = m-1;
        }
        return -1;
    }

    static public int partition(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while (l<=r) {
            int mid = (l+r) / 2;

            boolean lb = true;
            boolean rb = true;

            if (mid-1 >= 0 && nums[mid] > nums[mid-1])
                lb = false;

            if (mid+1 < n && nums[mid] > nums[mid+1])
                rb = false;

            if (lb && rb)
                return mid;

            if (nums[mid] < nums[r])
                r = mid - 1;
            else
                l = mid + 1;

        }
        return -1;
    }
}
