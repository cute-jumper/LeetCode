public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) currentSum = nums[i];
            else currentSum += nums[i];
            if (currentSum > maxSum) maxSum = nums[i];
        }
        return maxSum;
    }
}
