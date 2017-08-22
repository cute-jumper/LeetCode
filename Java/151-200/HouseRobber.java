public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int first = 0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                first = Math.max(second, first + nums[i]);
            } else {
                second = Math.max(first, second + nums[i]);
            }
        }
        return Math.max(first, second);
    }
}
