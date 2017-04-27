public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int n = nums[i % nums.length];
            while (!stack.isEmpty() && n > nums[stack.peek()]) {
                res[stack.pop()] = n;
            }
            if (i < nums.length) stack.push(i);
        }
        return res;
    }
}
