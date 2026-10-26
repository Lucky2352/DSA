class Solution {
    int ans = 0;
    int climb(int n,int[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0)return 0;
        if(dp[n] != -1)return dp[n];
        int left = climb(n - 1,dp);
        int right = climb(n - 2,dp);
        dp[n] = left + right;
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp,-1);
        climb(n,dp);
        return dp[n];
    }
}