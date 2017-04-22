public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int minprod = 1, maxprod = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int oldMin = minprod;
                minprod = Math.min(maxprod * nums[i], nums[i]);
                maxprod = Math.max(oldMin * nums[i], nums[i]);
            } else {
                minprod = Math.min(minprod * nums[i], nums[i]);
                maxprod = Math.max(maxprod * nums[i], nums[i]);
            }
            max = Math.max(max, maxprod);
        }
        return max;
    }
}
