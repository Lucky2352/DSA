import java.util.Arrays;

class Solution {
    private int[][] dp;
    int INF = (int) 1e9;
    private int recursion(int i, int[] coins, int target) {
        if (target == 0) {
            return 0;
        }
        if (i >= coins.length) {
            return INF;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        int take = INF;
        if (target - coins[i] >= 0) {
            take = 1 + recursion(i, coins, target - coins[i]);
        }
        int notTake = recursion(i + 1, coins, target);
        return dp[i][target] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = recursion(0, coins, amount);
        return ans >= INF ? -1 : ans;
    }
}