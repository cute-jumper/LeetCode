public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int maxLen = 0;
        int currLen = 0;
        Map<Integer, Integer> lens = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (lens.containsKey(stack.size())) {
                    lens.put(stack.size(), lens.get(stack.size()) + currLen);
                } else {
                    lens.put(stack.size(), currLen);
                }
                currLen = 0;
                maxLen = Math.max(maxLen, lens.get(stack.size()));
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    lens.clear();
                    maxLen = Math.max(maxLen, currLen);
                    currLen = 0;
                } else {
                    stack.pop();
                    currLen += 2;
                    if (lens.containsKey(stack.size())) {
                        currLen += lens.remove(stack.size());
                    }
                }
            }
        }
        return Math.max(maxLen, currLen);
    }
}
