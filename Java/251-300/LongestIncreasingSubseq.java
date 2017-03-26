public class LongestIncreasingSubseq {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > dp[index]) {
                index++;
                dp[index] = nums[i];
                continue;
            }
            int low = 0;
            int high = index;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = nums[i];
        }
        return index + 1;
    }
}
