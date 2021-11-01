class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++){
            if(board[i][0]=='O') recur(board,i,0);
            if(board[i][col-1]=='O') recur(board,i,col-1);
        }
        for(int i = 0; i < col; i++){
            if(board[0][i]=='O') recur(board,0,i);
            if(board[row-1][i]=='O') recur(board,row-1,i);
        }
        //for(int i = 0; i < row; i++){
            //for(int j = 0; j < col; j++){
                //System.out.print(board[i][j]+", ");
            //}
            //System.out.println();
        //}
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='E') board[i][j] = 'O';
            }
        }
    }
    
    private void recur(char[][] board, int i, int j){
        int row = board.length, col = board[0].length;
        board[i][j] = 'E';
        if(i+1<row&&board[i+1][j] == 'O') recur(board,i+1,j);
        if(i-1>=0&&board[i-1][j] == 'O') recur(board,i-1,j);
        if(j+1<col&&board[i][j+1] == 'O') recur(board,i,j+1);
        if(j-1>=0&&board[i][j-1] == 'O') recur(board,i,j-1);
    }
}
