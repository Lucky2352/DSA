class Solution {
    int recursion(int i,int j,int[][] grid,int[][]dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n - 1 && j == m - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1)return dp[i][j];

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i + 1 < n){
            right = recursion(i+1,j,grid,dp);
        }
        
        if(j + 1 < m){
            down =  recursion(i,j+1,grid,dp);
        }
        
        dp[i][j] = grid[i][j] + Math.min(down,right);
        return dp[i][j];

    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(0, 0, grid, dp);
    }
}