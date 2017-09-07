public class MagicalString {
    public int magicalString(int n) {
        if (n < 4) return (n + 2) / 3;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(2);
        int total = 3, digit = 1, count = 1;
        while (total < n) {
            int h = queue.poll();
            queue.offer(digit);
            if (h > 1) queue.offer(digit);
            if (digit == 1) count += h;
            total += h;
            digit ^= 3;
        }
        return total > n && digit == 2 ? count - 1 : count;
    }
}
