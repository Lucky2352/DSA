class Solution {
    public int recursion(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int skip = recursion(i + 1, nums, dp);
        int take = nums[i] + recursion(i + 2, nums, dp);
        return dp[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recursion(0, nums, dp);
    }
}