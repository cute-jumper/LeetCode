public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];
        dp1[0] = dp1[1] = 0;
        dp2[0] = 0;
        dp2[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);
            dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], dp2[i - 1]);
        }
        dp1[nums.length] = nums[nums.length - 1] + dp1[nums.length - 2];
        return Math.max(dp2[nums.length - 1], dp1[nums.length]);
    }
}
