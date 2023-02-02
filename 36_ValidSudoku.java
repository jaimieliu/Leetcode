class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Character>> cols = new ArrayList<List<Character>>();
        List<Set<Character>> colsSet = new ArrayList<Set<Character>>();
        for(int i = 0; i < board.length; i++){
            cols.add(new ArrayList<Character>());
            colsSet.add(new HashSet<Character>());
        }
        //Rows
        for(int i = 0; i < board.length; i++){
            char[] row = board[i];
            List<Character> list = new ArrayList<Character>();
            Set<Character> set = new HashSet<Character>();
            int j = 0;
            for(char letter: row){
                if(letter != '.'){
                    list.add(letter);
                    set.add(letter);
                    cols.get(j).add(letter);
                    colsSet.get(j).add(letter);
                }
                j++;
            }
            if(list.size() != set.size())
                return false;
        }
        
        //Columns
        for(int i = 0; i < board.length; i++){
            if(cols.get(i).size() != colsSet.get(i).size())
                return false;
        }
        
        //Blocks
        for(int i = 0; i < board.length; i+=3){            
            for(int j = 0; j < board.length; j+=3){
                List<Character> list = new ArrayList<Character>();
                Set<Character> set = new HashSet<Character>();
                
                for(int x = i; x < i+3; x++){
                    for(int y = j; y < j+3; y++){
                        if(board[x][y] != '.'){
                            list.add(board[x][y]);
                            set.add(board[x][y]);
                        }
                    }
                }
                
                if(list.size() != set.size())
                    return false;
            }
        }
        
        return true;
    }
}