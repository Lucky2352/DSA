class Solution {
    int MOD = 1_000_000_007;

    int recursion(int i, int j, int dir, int[][] grid, int n, int m,int[][] dp) {
        while (i < n && j < m && grid[i][j] == 1) {
            if (dir == 0) {
                i++;
                dir = 1;
            } else {
                j++;
                dir = 0;
            }
        }
        if (i >= n || j >= m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int right = recursion(i, j + 1, 0, grid, n, m,dp);
        int down = recursion(i + 1, j, 1, grid, n, m,dp);
        return dp[i][j] = (right + down) % MOD;
    }

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int right = recursion(0, 1, 0, grid, n, m,dp);
        int down = recursion(1, 0, 1, grid, n,m,dp);
        return (right + down) % MOD;
    }
}