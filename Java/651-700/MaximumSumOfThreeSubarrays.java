class MaximumSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length - k + 1];
        for (int i = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            if (i >= k - 1) {
                sum[i - k + 1] = s;
                s -= nums[i - k + 1];
            }
        }
        int[] left = new int[sum.length];
        for (int i = 0, max = 0; i < left.length; i++) {
            if (sum[i] > sum[max]) max = i;
            left[i] = max;
        }
        int[] right = new int[sum.length];
        for (int i = right.length - 1, max = right.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[max]) max = i;
            right[i] = max;
        }
        int[] res = null;
        for (int i = k, max = 0; i + k < sum.length; i++) {
            int v = sum[left[i - k]] + sum[i] + sum[right[i + k]];
            if (v > max) {
                max = v;
                res = new int[] { left[i - k], i, right[i + k] };
            }
        }
        return res;
    }
}
