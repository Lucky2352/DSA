
class pair {
    int row;
    int col;

    public pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int original = image[sr][sc];
        if (original == color) {
            return image;
        }
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(sr, sc));
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            if (row > 0 && image[row - 1][col] == original) {
                image[row - 1][col] = color;
                q.offer(new pair(row - 1, col));
            }
            if (row < n - 1 && image[row + 1][col] == original) {
                image[row + 1][col] = color;
                q.offer(new pair(row + 1, col));
            }
            if (col > 0 && image[row][col - 1] == original) {
                image[row][col - 1] = color;
                q.offer(new pair(row, col - 1));
            }
            if (col < m - 1 && image[row][col + 1] == original) {
                image[row][col + 1] = color;
                q.offer(new pair(row, col + 1));
            }
        }
        return image;
    }
}
