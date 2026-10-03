class Solution {
    void dfs(int i,int j,boolean[][] visited,int[][] grid,int n,int m){
        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == 1){
            visited[i - 1][j] = true;
            dfs(i-1,j,visited,grid,n,m);
        }
        if(i < n - 1 && !visited[i+1][j] && grid[i+1][j] == 1){
            visited[i+1][j] = true;
            dfs(i+1,j,visited,grid,n,m);
        }
        if(j < m - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1){
            visited[i][j + 1] = true;
            dfs(i,j+1,visited,grid,n,m);
        }
        if(j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1){
            visited[i][j - 1] = true;
            dfs(i,j - 1,visited,grid,n,m);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i < n;i++){
            if(!visited[i][0] && grid[i][0] == 1){
                visited[i][0] = true;
                dfs(i,0,visited,grid,n,m);
            }
            if(!visited[i][m - 1] && grid[i][m - 1] == 1){
                visited[i][m - 1] = true;
                dfs(i,m-1,visited,grid,n,m);
            }
        }
        for(int j = 0;j < m;j++){
            if(!visited[0][j] && grid[0][j] == 1){
                visited[0][j] = true;
                dfs(0,j,visited,grid,n,m);
            }
            if(!visited[n - 1][j] && grid[n - 1][j] == 1){
                visited[n - 1][j] = true;
                dfs(n - 1,j,visited,grid,n,m);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1)count++;
            }
        }
        return count;
    }
}