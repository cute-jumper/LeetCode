public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                switch (token.charAt(0)) {
                case '+':
                    stack.addLast(a + b);
                    break;
                case '-':
                    stack.addLast(b - a);
                    break;
                case '*':
                    stack.addLast(a * b);
                    break;
                case '/':
                    stack.addLast(b / a);
                    break;
                }
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.removeLast();
    }
}
