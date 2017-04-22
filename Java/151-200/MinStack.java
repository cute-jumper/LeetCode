public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minvalues = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (minvalues.isEmpty() || minvalues.peek() >= x) {
            minvalues.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == minvalues.peek().intValue()) minvalues.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minvalues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
