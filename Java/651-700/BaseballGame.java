class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int s = 0;
        for (String op : ops) {
            if (op.equals("C")) s -= stack.pop();
            else {
                int v = 0;
                if (op.equals("D")) {
                    v = 2 * stack.peek();
                } else if (op.equals("+")) {
                    int top = stack.pop();
                    v = top + stack.peek();
                    stack.push(top);
                } else {
                    v = Integer.parseInt(op);
                }
                stack.push(v);
                s += v;
            }
        }
        return s;
    }
}
