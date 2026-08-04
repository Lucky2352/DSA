class Solution {
    public static boolean recursion(int index,int i,int j,char[][] board,String word){
        if(index >= word.length())return true;
        if(board[i][j] == ' ' || board[i][j] != word.charAt(index))return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        if(i > 0 && recursion(index + 1,i-1,j,board,word)){
            board[i][j] = temp;
            return true;
        }
        if(i < board.length - 1 && recursion(index + 1,i+1,j,board,word)){
            board[i][j] = temp;
            return true;
        }
        if(j > 0 && recursion(index + 1,i,j - 1,board,word)){
            board[i][j] = temp;
            return true;
        }
        if(j <board[0].length - 1 && recursion(index + 1,i,j + 1,board,word)){
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        char st = word.charAt(0);
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == st){
                    if(word.length() == 1)return true;
                    char temp = board[i][j];
                    board[i][j] = ' ';
                    if((i > 0 && recursion(1,i-1,j,board,word)) || 
                    (i < board.length - 1 && recursion(1,i+1,j,board,word)) || 
                    (j > 0 && recursion(1,i,j - 1,board,word)) || 
                    (j <board[0].length - 1 && recursion(1,i,j + 1,board,word))){
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
}