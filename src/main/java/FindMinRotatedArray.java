public class FindMinRotatedArray {
    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        int min = findMin(arr);
        System.out.println(min);
    }

    static public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while (l<r) {
            int mid = (l+r) / 2;
            if (mid == 0 || mid == n-1)
                return nums[mid];

            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
                return nums[mid];

            if (nums[mid] < nums[r])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return nums[l];
    }
}
