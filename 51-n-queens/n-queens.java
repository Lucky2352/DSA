class Solution {
    public static void recursion(int row, char[][] board, List<List<String>> ans, int n) {
        if (row >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (put(row, i, board)) {
                board[row][i] = 'Q';
                recursion(row + 1, board, ans, n);
                board[row][i] = '.';
            }
        }
    }
    public static boolean put(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        recursion(0, board, ans, n);
        return ans;
    }
}