class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } 
                else {
                    ans[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            if (i > 0 && ans[i - 1][j] == -1) {
                ans[i - 1][j] = ans[i][j] + 1;
                q.offer(new int[]{i - 1, j});
            }
            if (i < n - 1 && ans[i + 1][j] == -1) {
                ans[i + 1][j] = ans[i][j] + 1;
                q.offer(new int[]{i + 1, j});
            }
            if (j > 0 && ans[i][j - 1] == -1) {
                ans[i][j - 1] = ans[i][j] + 1;
                q.offer(new int[]{i, j - 1});
            }
            if (j < m - 1 && ans[i][j + 1] == -1) {
                ans[i][j + 1] = ans[i][j] + 1;
                q.offer(new int[]{i, j + 1});
            }
        }
        return ans;
    }
}