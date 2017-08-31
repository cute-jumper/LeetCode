public class BasicCalculator {
    public int calculate(String s) {
        int res = 0, num = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = num = 0;
                sign = 1;
            } else if (c == ')') {
                res = (res + num * sign) * stack.pop();
                res += stack.pop();
                num = 0;
            }
            if (i == s.length() - 1 || c == '+' || c == '-') {
                res += num * sign;
                sign = c == '+' ? 1 : -1;
                num = 0;
            }
        }
        return res;
    }
}
