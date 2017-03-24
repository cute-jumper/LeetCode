public class MyQueue {

    Deque<Integer> stack = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Deque<Integer> backup = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            backup.offerFirst(stack.pollFirst());
        }
        stack.offerFirst(x);
        while (!backup.isEmpty()) {
            stack.offerFirst(backup.pollFirst());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
