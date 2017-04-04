public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int i = 2; i <= nums.length; i++) {
            for (int j = dp.length - 1; j >= i - 1; j--) {
                dp[j] = Math.max(nums[j] - dp[j - 1],
                                 nums[j - i + 1] - dp[j]);
            }
        }
        return dp[nums.length - 1] >= 0;
    }
}
