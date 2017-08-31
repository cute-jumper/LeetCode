public class MaximumSubarrayII42 {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int[] prefix = new int[nums.size()], suffix = new int[nums.size()];
        maxSubArray(nums, prefix, true);
        maxSubArray(nums, suffix, false);
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(max, prefix[i] + suffix[i + 1]);
        }
        return max;
    }
    void maxSubArray(List<Integer> nums, int[] maxs, boolean dir) {
        int max = Integer.MIN_VALUE;
        for (int i = dir ? 0 : maxs.length - 1; dir ? (i < maxs.length) : (i >= 0); i += dir ? 1 : -1) {
            if (max < 0) max = nums.get(i);
            else max += nums.get(i);
            if (i == (dir ? 0 : nums.size() - 1)) maxs[i] = max;
            else maxs[i] = Math.max(maxs[i + (dir ? -1 : 1)], max);
        }
    }
}
