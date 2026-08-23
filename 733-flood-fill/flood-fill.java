class Solution {
    static class pair {
        int row;
        int col;
        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        int oldColor = grid[sr][sc];
        if (oldColor == color) {
            return grid;
        }
        grid[sr][sc] = color;
        q.offer(new pair(sr, sc));
        while (!q.isEmpty()) {
            pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            if (row - 1 >= 0 && grid[row - 1][col] == oldColor) {
                grid[row - 1][col] = color;
                q.offer(new pair(row - 1, col));
            }
            if (row + 1 < n && grid[row + 1][col] == oldColor) {
                grid[row + 1][col] = color;
                q.offer(new pair(row + 1, col));
            }
            if (col - 1 >= 0 && grid[row][col - 1] == oldColor) {
                grid[row][col - 1] = color;
                q.offer(new pair(row, col - 1));
            }
            if (col + 1 < m && grid[row][col + 1] == oldColor) {
                grid[row][col + 1] = color;
                q.offer(new pair(row, col + 1));
            }
        }
        return grid;
    }
}