class Solution {
    int recursion(int i, int j, List<List<Integer>> matrix, int[][] dp) {
        int n = matrix.size();
        int m = matrix.get(i).size();
        if(i >= n || j >= m)return Integer.MAX_VALUE;
        if (i == n - 1) {
            return matrix.get(i).get(j);
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int down = recursion(i + 1, j + 1, matrix, dp);
        int right = recursion(i + 1, j, matrix, dp);
        return dp[i][j] = matrix.get(i).get(j) + Math.min(down, right);
    }
    public int minimumTotal(List<List<Integer>> matrix) {
        int n = matrix.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return recursion(0,0,matrix,dp);
    }
}