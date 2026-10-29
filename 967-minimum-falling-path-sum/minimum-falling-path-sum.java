class Solution {
    int recursion(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != 100000) {
            return dp[i][j];
        }
        int left = recursion(i + 1, j - 1, matrix, dp);
        int down = recursion(i + 1, j, matrix, dp);
        int right = recursion(i + 1, j + 1, matrix, dp);
        return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 100000);
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, recursion(0, j, matrix, dp));
        }
        return mini;
    }
}
