class Solution {
    List<List<String>> ans = new ArrayList<>();
    boolean isSafe(int row, int col, int[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
    void recursion(int row, int[][] board) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 1) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                list.add(sb.toString());
            }

            ans.add(list);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 1;

                recursion(row + 1, board);

                board[row][col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        recursion(0, board);
        return ans;
    }
}