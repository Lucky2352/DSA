class Solution {
    void dfs(int i,int j,boolean visited[][],char[][] grid,int n,int m){
        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == '1'){
            visited[i - 1][j] = true;
            dfs(i-1,j,visited,grid,n,m);
        }
        if(i < n - 1 && !visited[i+1][j] && grid[i+1][j] == '1'){
            visited[i+1][j] = true;
            dfs(i+1,j,visited,grid,n,m);
        }
        if(j < m - 1 && !visited[i][j + 1] && grid[i][j + 1] == '1'){
            visited[i][j + 1] = true;
            dfs(i,j+1,visited,grid,n,m);
        }
        if(j > 0 && !visited[i][j - 1] && grid[i][j - 1] == '1'){
            visited[i][j - 1] = true;
            dfs(i,j - 1,visited,grid,n,m);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(i,j,visited,grid,n,m);
                }
            }
        }
        return count;
    }
}