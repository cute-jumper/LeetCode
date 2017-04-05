public class ContinouseSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            sum[i] = nums[i] + nums[i + 1];
            if (k == 0 && sum[i] == 0 ||
                k != 0 && sum[i] % k == 0) return true;
        }
        for (int len = 3; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                sum[i] += nums[i + len - 1];
                if (k == 0 && sum[i] == 0 ||
                    k != 0 && sum[i] % k == 0) return true;
            }
        }
        return false;
    }
}
