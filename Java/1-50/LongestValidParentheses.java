public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - (stack.isEmpty() ? -1 : stack.peek()));
            }
            else stack.push(i);
        }
        return max;
    }
}
