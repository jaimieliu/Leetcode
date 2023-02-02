class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 1; j <= i; j++){
                if(nums[i] > nums[i-j] && (dp[i-j] + 1 > dp[i]))
                    dp[i] = dp[i-j] + 1;
            }
        }
        Arrays.sort(dp);
        return dp[dp.length -1];
    }
}