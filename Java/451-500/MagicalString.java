public class MagicalString {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n < 4) return 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(2);
        int current = 1;
        int count = 1;
        int total = 3;
        while (total < n) {
            int head = queue.pollFirst();
            queue.offerLast(current);
            if (head > 1) queue.offerLast(current);
            total += head;
            if (current == 1) count += head;
            current ^= 3;
        }
        if (total > n && current == 2) return count - 1;
        return count;
    }
}
