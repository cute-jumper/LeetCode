public class BasicCalculator {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int num = 0;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i;
            while (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
                index++;
                if (index == s.length()) break;
                c = s.charAt(index);
            }
            if (index != i) {
                num = negative ? -num : num;
                stack.push("" + num);
                num = 0;
                negative = false;
            }
            i = index;
            if (c == '-') negative = true;
            else if (c == '(') {
                if (negative) stack.push("[");
                else stack.push("(");
                negative = false;
            }
            else if (c == ')') {
                int sum = 0;
                while (!stack.peek().equals("(") && !stack.peek().equals("[")) {
                    sum += Integer.parseInt(stack.pop());
                }
                if (stack.pop().equals("[")) sum = -sum;
                stack.push("" + sum);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }
}
