public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double s = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i < k) s += nums[i];
            else {
                max = Math.max(max, s);
                if (i < nums.length) {
                    s -= nums[i - k];
                    s += nums[i];
                }
            }
        }
        return max / k;
    }
}
