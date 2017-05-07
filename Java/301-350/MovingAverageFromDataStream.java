public class MovingAverage {

    Deque<Integer> queue;
    int size;
    int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            sum += val;
        } else {
            sum -= queue.poll();
            sum += val;
            queue.offer(val);
        }
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
