class Solution {
    public boolean check(int row, int col, char[][] board, char temp) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == temp) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == temp) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == temp) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (!check(row, col, board, board[row][col])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}