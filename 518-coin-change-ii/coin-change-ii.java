class Solution {
    int[][] dp;
    public int recursion(int i,int[] coins,int target,int count){
        if(target == 0){
            return 1;
        }
        if(i >= coins.length){
            return 0;
        }
        if(dp[i][target] != -1)return dp[i][target];
        int take = 0;
        int notTake = 0;
        if(target - coins[i] >= 0){
            take = recursion(i,coins,target - coins[i],count + 1);
        }
        notTake = recursion(i+1,coins,target,count);
        return dp[i][target] = take + notTake;

    }
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = recursion(0,coins,amount,0);
        return ans;
    }
}