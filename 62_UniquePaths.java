class Solution {
    public int uniquePaths(int m, int n) {
        //unique paths to get to finish line
        int[][] dp = new int[m][n];
        if(m == 1 || n ==1 )
            return 1;
        //fill first row and first col with 1
        Arrays.fill(dp[0], 1);
        for(int a = 0; a < m; a++){
            dp[a][0] = 1;
        }
        dp[0][0] = 0;
        
        //sum the number of paths of element above and to left of it (number of paths to get to the current block)
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = dp[r][c-1] + dp[r-1][c];
            }
        }
        
        return dp[m-1][n-1];
    }
}