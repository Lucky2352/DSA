class pair {
    int row;
    int col;
    int dist;

    pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0, 0, 1));
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int cur = temp.dist;

            if (row == n - 1 && col == n - 1) {
                return cur;
            }

            if (row + 1 < n && grid[row + 1][col] == 0) {
                grid[row + 1][col] = 1;
                q.offer(new pair(row + 1, col, cur + 1));
            }

            if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                grid[row - 1][col] = 1;
                q.offer(new pair(row - 1, col, cur + 1));
            }
            
            if (col + 1 < n && grid[row][col + 1] == 0) {
                grid[row][col + 1] = 1;
                q.offer(new pair(row, col + 1, cur + 1));
            }
            
            if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                grid[row][col - 1] = 1;
                q.offer(new pair(row, col - 1, cur + 1));
            }
            
            if (row + 1 < n && col + 1 < n && grid[row + 1][col + 1] == 0) {
                grid[row + 1][col + 1] = 1;
                q.offer(new pair(row + 1, col + 1, cur + 1));
            }
            
            if (row + 1 < n && col - 1 >= 0 && grid[row + 1][col - 1] == 0) {
                grid[row + 1][col - 1] = 1;
                q.offer(new pair(row + 1, col - 1, cur + 1));
            }

            if (row - 1 >= 0 && col + 1 < n && grid[row - 1][col + 1] == 0) {
                grid[row - 1][col + 1] = 1;
                q.offer(new pair(row - 1, col + 1, cur + 1));
            }

            if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0) {
                grid[row - 1][col - 1] = 1;
                q.offer(new pair(row - 1, col - 1, cur + 1));
            }
        }

        return -1;
    }
}