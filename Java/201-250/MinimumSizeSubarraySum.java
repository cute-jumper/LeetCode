public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int minLen = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
