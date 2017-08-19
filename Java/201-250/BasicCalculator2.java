public class BasicCaculator2 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() - 1 || c != ' ' && (c < '0' || c > '9')) {
                switch (op) {
                case '+': {
                    stack.push(num);
                    break;
                }
                case '-': {
                    stack.push(-num);
                    break;
                }
                case '*': {
                    stack.push(stack.pop() * num);
                    break;
                }
                case '/': {
                    stack.push(stack.pop() / num);
                    break;
                }
                }
                op = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
