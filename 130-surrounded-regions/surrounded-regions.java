class Solution {
    public static void dfs(int i, int j, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        board[i][j] = 'T';
        if(i > 0 && board[i-1][j] == 'O'){
            dfs(i-1, j, board);
        }
        if(i < n-1 && board[i+1][j] == 'O'){
            dfs(i+1, j, board);
        }
        if(j > 0 && board[i][j-1] == 'O'){
            dfs(i, j-1, board);
        }
        if(j < m-1 && board[i][j+1] == 'O'){
            dfs(i, j+1, board);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(board[i][j] == 'O'){
                        dfs(i, j, board);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}