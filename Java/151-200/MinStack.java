public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minvalues = new ArrayDeque<>();
    int currentMin = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (x <= currentMin) {
            minvalues.addLast(currentMin);
            currentMin = x;
        }
        stack.addLast(x);
    }

    public void pop() {
        int last = stack.removeLast();
        if (last == currentMin) {
            currentMin = minvalues.removeLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return currentMin;
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
