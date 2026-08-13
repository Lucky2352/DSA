class Solution {
    public static boolean check(int[] nums, int n, int val) {
        for (int num : nums) {
            n -= (num + val - 1) / val;
            if (n < 0) {
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] nums) {
        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}