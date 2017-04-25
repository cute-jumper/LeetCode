public class LongestIncreasingSubseq {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int found = Arrays.binarySearch(dp, 0, index, nums[i]);
            if (found < 0) {
                found = -found - 1;
                dp[found] = nums[i];
                if (found == index) index++;
            }
        }
        return index;
    }
}
