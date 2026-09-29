class Solution {
    public boolean recursion(int i,int j,char[][] grid,int open,Boolean[][][] dp) {
        if(i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if(grid[i][j] == '(') {
            open++;
        }else {
            open--;
        }

        if(open < 0) {
            return false;
        }

        if(dp[i][j][open] != null) {
            return dp[i][j][open];
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return open == 0;
        }

        boolean down = recursion(i + 1, j, grid, open, dp);
        boolean right = recursion(i, j + 1, grid, open, dp);

        dp[i][j][open] = down || right;

        return dp[i][j][open];
    }

    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')') {
            return false;
        }
        if(grid[grid.length - 1][grid[0].length - 1] == '(') {
            return false;
        }
        Boolean[][][] dp = new Boolean[grid.length][grid[0].length][grid.length + grid[0].length];
        return recursion(0, 0, grid, 0, dp);
    }
}