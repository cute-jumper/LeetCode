public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int v1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int v2 = nums[0] * nums[1] * nums[len - 1];
        return Math.max(v1, v2);
    }
}
