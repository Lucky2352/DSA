class Solution {
    public int recursion(int n,int dp[]) {
        if (n == 0) {
            return 0;
        }
        if(dp[n] != 0)return dp[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int current = 1 + recursion(n - i * i,dp);
            ans = Math.min(ans, current);
            
        }
        dp[n] = ans;
        return ans;
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return recursion(n,dp);
    }
}