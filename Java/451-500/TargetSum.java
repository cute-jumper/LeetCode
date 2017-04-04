public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum < S || -sum > S) return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][nums[0] + sum]++;
        dp[0][-nums[0] + sum]++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j + sum - nums[i] >= 0)
                    dp[i][j + sum] += dp[i - 1][j + sum - nums[i]];
                if (j + sum + nums[i] <= 2 * sum)
                    dp[i][j + sum] += dp[i - 1][j + sum + nums[i]];
            }
        }
        return dp[nums.length - 1][S + sum];
    }
}
