public class MyStack {

    Deque<Integer> queue = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.addLast(queue.removeFirst());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return queue.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
