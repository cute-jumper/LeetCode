public class NextGreaterElement {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            while (!stack.isEmpty() && stack.peek() < i) map.put(stack.pop(), i);
            stack.push(i);
        }
        for (int i = 0; i < res.length; i++) res[i] = map.containsKey(findNums[i]) ? map.get(findNums[i]) : -1;
        return res;
    }
}
