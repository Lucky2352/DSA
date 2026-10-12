class Solution {
    public int recursion(int i, int j, int n, int m, int[][] dp) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int down = 0;
        int right = 0;
        if (i < n - 1) {
            down = recursion(i + 1, j, n, m, dp);
        }
        if (j < m - 1) {
            right = recursion(i, j + 1, n, m, dp);
        }
        dp[i][j] = down + right;
        return dp[i][j];
    }
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        return recursion(0, 0, n, m, dp);
    }
}