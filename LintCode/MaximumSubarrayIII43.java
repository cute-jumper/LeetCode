public class MaximumSubarrayIII43 {
    /*
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        int[][] dp = new int[k][nums.length];
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                int endMax = 0, max = Integer.MIN_VALUE;
                for (int p = j; p >= i; p--) {
                    endMax = Math.max(nums[p], endMax + nums[p]);
                    max = Math.max(max, endMax);
                    dp[i][j] = Math.max(dp[i][j], max + (i > 0 ? dp[i - 1][p - 1] : 0));
                }
            }
        }
        return dp[k - 1][nums.length - 1];
    }
}
