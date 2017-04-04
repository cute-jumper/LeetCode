public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < 2 * nums.length; i++) {
            if (i >= nums.length) {
                if (dq.isEmpty()) break;
                int index = i - nums.length;
                if (index == dq.peekFirst()) {
                    res[dq.pollFirst()] = -1;
                }
                while (!dq.isEmpty() && nums[index] > nums[dq.peekLast()]) {
                    res[dq.pollLast()] = nums[index];
                }
            } else {
                while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                    res[dq.pollLast()] = nums[i];
                }
                dq.offerLast(i);
            }
        }
        return res;
    }
}
