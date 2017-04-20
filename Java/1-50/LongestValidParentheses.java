public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || stack.isEmpty() || s.charAt(stack.peek()) != '(') stack.push(i);
            else stack.pop();
        }
        int prev = s.length(), maxLen = 0;
        while (!stack.isEmpty()) {
            maxLen = Math.max(maxLen, prev - stack.peek() - 1);
            prev = stack.pop();
        }
        return Math.max(maxLen, prev);
    }
}
