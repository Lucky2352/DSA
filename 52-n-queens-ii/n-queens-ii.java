class Solution {
    public static boolean isSafe(int row, int col, boolean[][] visited) {
        int n = visited.length;
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) {
                return false;
            }
        }
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void recursion(int row, boolean[][] visited, List<List<String>> ans) {
        int n = visited.length;
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                list.add(s.toString());
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (visited[row][col] == false && isSafe(row, col, visited)) {
                visited[row][col] = true;
                recursion(row + 1, visited, ans);
                visited[row][col] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        recursion(0, visited, ans);

        return ans.size();
    }
}