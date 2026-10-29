class Solution {
    int recursion(int i,int j,int[][] grid,int[][] dp,int n,int m){
        if(i >= n || j >= m || grid[i][j] == 1)return 0;
        if(i == n - 1 && j == m - 1){
            return 1;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int left = recursion(i+1,j,grid,dp,n,m);
        int right = recursion(i,j+1,grid,dp,n,m);
        dp[i][j] = left + right;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursion(0, 0, grid, dp,n,m);
    }
}