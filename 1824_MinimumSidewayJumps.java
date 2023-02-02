class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int dp[][] = new int[3][n];
        //[lane][point]

        // 1 if obstacle
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[2][0] = 1;

        for(int i = 1; i < n; i++){
            int obs = obstacles[i] - 1;
            for(int lane = 0; lane < 3; lane++){
                if(lane == obs)
                    dp[lane][i] = Integer.MAX_VALUE;
                else
                    dp[lane][i] = dp[lane][i-1];
            }

            int min = Math.min(dp[0][i], Math.min(dp[1][i], dp[2][i]));
            for(int lane = 0; lane < 3; lane++){
                if(lane != obs)
                    dp[lane][i] = Math.min(dp[lane][i], min + 1);
            }
        }

        return Math.min(dp[0][n-1], Math.min(dp[1][n-1], dp[2][n-1]));
    }
}