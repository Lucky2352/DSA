class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        dp[0] = nums[0];
        if(nums.length == 1)return dp[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i = 2;i<nums.length;i++){
             int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick,notPick); 
        }
        return dp[nums.length - 1];
    }
}