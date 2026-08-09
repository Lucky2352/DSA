class Solution {
    public static int recursion(int i, int val,int[]dp) {
        if (i == val) {
            return 1;
        }
        int count = 0;
        if(dp[i] != 0){
            return dp[i];
        }
        if (i + 1 <= val) {
            count += recursion(i + 1, val,dp);
            dp[i] = count;
        }
        if (i + 2 <= val) {
            count += recursion(i + 2, val,dp);
            dp[i] = count;
        }
        return count;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return recursion(0, n,dp);
    }
}