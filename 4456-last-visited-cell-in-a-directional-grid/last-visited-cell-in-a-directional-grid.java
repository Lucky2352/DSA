
class Solution {
    boolean[][] visited;
    int r = 0;
    int col = 0;
    void recursion(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        r = i;
        col = j;
        int ni = i;
        int nj = j;
        if (grid[i][j] == 'L') {
            nj--;
        } else if (grid[i][j] == 'R') {
            nj++;
        } else if (grid[i][j] == 'U') {
            ni--;
        } else if (grid[i][j] == 'D') {
            ni++;
        }
        if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
            return;
        }
        if (visited[ni][nj]) {
            return;
        }
        recursion(ni, nj, grid);
    }
    public int[] lastVisitedCell(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        recursion(0, 0, grid);
        return new int[]{r, col};
    }
}
