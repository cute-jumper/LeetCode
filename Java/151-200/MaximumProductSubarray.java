public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] minprod = new int[nums.length + 1];
        int[] maxprod = new int[nums.length + 1];
        minprod[0] = maxprod[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minprod[i + 1] = Math.min(maxprod[i] * nums[i], nums[i]);
                maxprod[i + 1] = Math.max(minprod[i] * nums[i], nums[i]);
            } else {
                minprod[i + 1] = Math.min(minprod[i] * nums[i], nums[i]);
                maxprod[i + 1] = Math.max(maxprod[i] * nums[i], nums[i]);
            }
            if (maxprod[i + 1] > max) {
                max = maxprod[i + 1];
            }
        }
        return max;
    }
}
