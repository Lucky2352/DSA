class Solution {
    int[][] dp;
    int totalSum;
    private int recursion(int i, int cur, int[] nums, int target) {
        if (i == nums.length) {
            if(cur == target){
                return 1;
            }
            return 0;
        }
        int dpIndex = cur + totalSum;
        if (dp[i][dpIndex] != Integer.MIN_VALUE) {
            return dp[i][dpIndex];
        }

        int take = recursion(i + 1, cur + nums[i], nums, target);
        int notTake = recursion(i + 1, cur - nums[i], nums, target);

        return dp[i][dpIndex] = take + notTake;
    }

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (Math.abs(target) > totalSum) {
            return 0;
        }
        dp = new int[nums.length][2 * totalSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return recursion(0, 0, nums, target);
    }
}