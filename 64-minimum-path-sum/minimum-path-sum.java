class Solution {
    public static int recursion(int i, int j, int[][] grid, int[][] dp) {
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(j + 1 < grid[0].length){
            right = recursion(i, j + 1, grid, dp);
        }

        if(i + 1 < grid.length){
            down = recursion(i + 1, j, grid, dp);
        }
        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(0, 0, grid, dp);
    }
}