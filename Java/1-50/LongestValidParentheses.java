public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || stack.isEmpty() || s.charAt(stack.peek()) != '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) max = Math.max(max, i + 1);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
