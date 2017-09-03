public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int mid = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) mid = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
