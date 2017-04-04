public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[nums.length - 1]);
        int last = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < last) return true;
            if (nums[i] > stack.peek()) {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    last = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
