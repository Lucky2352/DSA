class Solution {
    public int recursion(int i,int n,int[] dp){
        if(i == n){
            return 1;
        }
        int total = 0;
        if(dp[i] != 0)return dp[i];
        if(i + 1 <= n){
        total += recursion(i+1,n,dp);
        dp[i] = total;
        }
        if(i + 2 <= n){
            total += recursion(i+2,n,dp);
            dp[i] = total;
        }
        return total;

    }
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        return recursion(0,n,dp);
    }
}