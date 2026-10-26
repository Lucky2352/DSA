class Solution {
    long sum = 0;
    void dfs(int i,int j,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)return;
        sum += grid[i][j];
        grid[i][j] = 0;
        dfs(i + 1,j,grid);
        dfs(i - 1,j,grid);
        dfs(i,j + 1,grid);
        dfs(i,j - 1,grid);

    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] != 0){
                    dfs(i ,j ,grid);
                    if(sum % k == 0)count++;
                    sum = 0;
                }
            }
        }
        return count;
    }
}