class pair{
    int row;
    int col;

    public pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int bfs(char[][] grid,int n,int m){
        int count = 0;
        Queue<pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    q.offer(new pair(i,j));
                }
                while(!q.isEmpty()){
                    pair temp = q.poll();
                    int row = temp.row;
                    int col = temp.col;
                    if(row > 0 && !visited[row-1][col] && grid[row-1][col] == '1'){
                    visited[row - 1][col] = true;
                    q.offer(new pair(row - 1,col));
                    }
                    if(row < n - 1 && !visited[row+1][col] && grid[row+1][col] == '1'){
                    visited[row + 1][col] = true;
                    q.offer(new pair(row + 1,col));
                    }
                    if(col < m - 1 && !visited[row][col + 1] && grid[row][col + 1] == '1'){
                    visited[row][col + 1] = true;
                    q.offer(new pair(row,col+1));
                    }
                    if(col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1'){
                    visited[row][col - 1] = true;
                    q.offer(new pair(row,col - 1));
                    }
                }
            }
        }
        return count;
    }
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
        // return count;
        return bfs(grid,n,m);
    }
}