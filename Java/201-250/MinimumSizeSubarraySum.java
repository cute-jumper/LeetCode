public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1, sum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - start + 1);
                sum -= nums[start++];
            }
        }
        return min % (nums.length + 1);
    }
}
