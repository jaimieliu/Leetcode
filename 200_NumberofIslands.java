class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    grid = checkRow(r,c, grid);
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    public char[][] checkRow(int r, int c, char[][] grid){
        outer: for(int a = c; a < grid[0].length; a++){
            if(grid[r][a] == '1'){
                grid[r][a] = '2';
                grid = checkCol(r, a, grid);
            }
            else if(grid[r][a] == '0')
                break outer;
        }
        outer2: for(int a = c; a >= 0 && a < grid[0].length; a--){
            if(grid[r][a] == '1'){
                grid[r][a] = '2';
                grid = checkCol(r, a, grid);
            }
            else if(grid[r][a] == '0')
                break outer2;
        }
        return grid;
        
    }
    
    public char[][] checkCol(int r, int c, char[][] grid){
        outer: for(int b = r; b < grid.length; b++){
            if(grid[b][c] == '1'){
                grid[b][c] = '2';
                grid = checkRow(b, c, grid);
            }
            else if(grid[b][c] == '0')
                break outer;
        }
        outer2: for(int b = r; b >= 0 && b < grid.length; b--){
            if(grid[b][c] == '1'){
                grid[b][c] = '2';
                grid = checkRow(b, c, grid);
            }
            else if(grid[b][c] == '0')
                break outer2;
        }
        return grid;
        
    }
}