public class BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        int num = 0;
        int curr = 0;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                curr += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if ('0' <= c && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                stack.push(curr);
                stack.push(sign);
                curr = num = 0;
                sign = 1;
            } else if (c == ')') {
                curr += sign * num;
                curr *= stack.pop();
                curr += stack.pop();
                num = 0;
            }
        }
        if (num > 0) curr += num * sign;
        return curr;
    }
}
