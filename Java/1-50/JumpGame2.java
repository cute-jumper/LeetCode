public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0;
        int start = 0;
        int end = 0;
        while (start < nums.length) {
            int currEnd = end;
            for (int i = start; i <= currEnd; i++) {
                end = Math.max(end, i + nums[i]);
                if (end >= nums.length - 1) return step + 1;
            }
            start = currEnd + 1;
            step++;
        }
        return step;
    }
}
