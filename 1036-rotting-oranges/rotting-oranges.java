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
        int[][] check = new int[n][m];
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pair(i, j, 0));
                    check[i][j] = 1;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int t = curr.time;
            ans = Math.max(ans, t);
            if (row - 1 >= 0 && grid[row - 1][col] == 1 && check[row - 1][col] == 0) {
                check[row - 1][col] = 1;
                q.offer(new pair(row - 1, col, t + 1));
            }
            if (row + 1 < n && grid[row + 1][col] == 1 && check[row + 1][col] == 0) {
                check[row + 1][col] = 1;
                q.offer(new pair(row + 1, col, t + 1));
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1 && check[row][col - 1] == 0) {
                check[row][col - 1] = 1;
                q.offer(new pair(row, col - 1, t + 1));
            }
            if (col + 1 < m && grid[row][col + 1] == 1 && check[row][col + 1] == 0) {
                check[row][col + 1] = 1;
                q.offer(new pair(row, col + 1, t + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && check[i][j] == 0) {
                    return -1;
                }
            }
        }
        return ans;
    }
}