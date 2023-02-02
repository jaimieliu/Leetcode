class TicTacToe {
    public int[][] board;
    
    public TicTacToe(int n) {
        this.board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        
        boolean won = true;
        //Check row
        loop: for(int c = 0; c < board[0].length; c++){
            if(board[row][c] != player){
                won = false;
                break loop;
            }
        }
        
        if(won)
            return player;
        
        won = true;
        //Check col
        loop: for(int[] r: board){
            if(r[col] != player){
                won = false;
                break loop;
            }
        }
        
        if(won)
            return player;
        
        //Check diagonal
        won = true;
        loop: for(int i = 0; i < board.length; i++){
            if(board[i][i] != player){
                won = false;
                break loop;
            }
        }
        if(won)
            return player;
        
        won = true;
        loop: for(int i = board.length-1; i >= 0; i--){
            if(board[board.length-1-i][i] != player){
                won = false;
                break loop;
            }
        }
        if(won)
            return player;
        
        
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */