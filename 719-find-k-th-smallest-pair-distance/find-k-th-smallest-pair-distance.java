class Solution {
    public int check(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[left] > mid) {
                left++;
            }
            count += i - left;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = check(nums, mid);
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}