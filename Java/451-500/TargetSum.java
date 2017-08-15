public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (S > sum || (S + sum) % 2 == 1) return 0;
        int[] dp = new int[(S + sum) / 2 + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = dp.length - 1; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        return dp[dp.length - 1];
    }
}
