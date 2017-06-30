public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] map = new char[256];
        map['('] = ')';
        map['['] = ']';
        map['{'] = '}';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != 0) {
                stack.push(map[c]);
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
