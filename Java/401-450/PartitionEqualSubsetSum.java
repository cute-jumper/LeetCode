public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        for (int i : nums) {
            dp[0] = true;
            for (int j = sum; j >= 0; j--) {
                dp[j] = dp[j] || dp[j - i];
            }
            if (dp[sum]) return true;
        }
        return false;
    }
}
