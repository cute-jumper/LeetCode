public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] vals = new int[nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            vals[i] = nums[i - 1];
        }
        vals[0] = vals[nums.length + 1] = 1;
        int[][] dp = new int[vals.length][vals.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i + len + 1 < vals.length; i++) {
                int j = i + len + 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], vals[k] * vals[i] * vals[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
