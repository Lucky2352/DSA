class Solution {
    static class pair {
        int row;
        int col;
        int time;
        pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int timeReq = 0;
        while(!q.isEmpty()){
            pair temp = q.poll();
            int i = temp.row;
            int j = temp.col;
            int time = temp.time;
            timeReq = Math.max(timeReq,time);
            if(i > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]){
                visited[i - 1][j] = true;
                q.offer(new pair(i - 1,j,time + 1));
            }
            if(j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]){
                visited[i][j - 1] = true;
                q.offer(new pair(i,j - 1,time + 1));
            }
            if(i < n - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j]){
                visited[i + 1][j] = true;
                q.offer(new pair(i + 1,j,time + 1));
            }
            if(j < m - 1 && grid[i][j+1] == 1 && !visited[i][j + 1]){
                visited[i][j + 1] = true;
                q.offer(new pair(i,j + 1,time + 1));
            }
        }
        for(int  i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1 && !visited[i][j])return -1;
            }
        }
        return timeReq;
    }
}