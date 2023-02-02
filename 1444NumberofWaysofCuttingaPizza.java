class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] apples = new int[m+1][n+1];
        int[][][] slices = new int[k+1][m][n];
        int apple = 0;
        
        for(int r = m-1; r >= 0; r--){
            for(int c = n-1; c >= 0; c--){
                if(pizza[r].charAt(c) == 'A'){
                    apple = 1;
                }
                else
                    apple = 0;
                apples[r][c] = apples[r+1][c] + apples[r][c+1] - apples[r+1][c+1] + apple;
            }
        }
        
        //Now you have the number of apples for each submatrix
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(apples[r][c] > 0){               //if there are apples in that submatrix or piece
                    slices[1][r][c] = 1;
                }
            }
        }
        
        
        for(int slice = 2; slice <= k; slice++){
            for(int r = m-1; r >= 0; r--){
                for(int c= n-1; c >= 0; c--){
                    //horizontal cuts
                        for(int r2 = r + 1; r2 < m ; r2++){
                            if(apples[r][c] - apples[r2][c] > 0)
                                slices[slice][r][c] = (slices[slice][r][c] + slices[slice-1][r2][c]) % (int)(Math.pow(10,9) + 7);
                        }
                    //vertical cuts
                        for(int c2 = c + 1; c2 < n; c2++){
                            if(apples[r][c] - apples[r][c2] > 0)
                                slices[slice][r][c] = (slices[slice][r][c] + slices[slice-1][r][c2]) % (int)(Math.pow(10,9) + 7);
                        }
                }
            }
        }
        return slices[k][0][0] ;
    }
}