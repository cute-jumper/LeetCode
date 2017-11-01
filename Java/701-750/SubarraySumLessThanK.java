class SubarraySumLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int start = 0, res = 0, prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) prod /= nums[start++];
            res += i - start + 1;
        }
        return res;
    }
}
