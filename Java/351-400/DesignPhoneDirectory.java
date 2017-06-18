public class PhoneDirectory {
    Set<Integer> used = new HashSet<>();
    Deque<Integer> queue = new ArrayDeque<>();
    int cap;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
        cap = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) return -1;
        int r = queue.poll();
        used.add(r);
        return r;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return 0 <= number && number < cap && !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) queue.offer(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
