class Solution {
    public String[] createGrid(int m, int n) {
        char[][] mat = new char[m][n];
        for (int j = 0; j < n; j++) {
            mat[0][j] = '.';
        }
        for (int i = 1; i < m; i++) {
            mat[i][n - 1] = '.';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != '.') {
                    mat[i][j] = '#';
                }
            }
        }

        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            ans[i] = new String(mat[i]);
        }
        return ans;
    }
}