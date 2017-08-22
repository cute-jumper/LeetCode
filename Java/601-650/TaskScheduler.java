public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int freq : map.values()) pq.offer(-freq);
        Deque<Integer> queue = new ArrayDeque<>();
        int cycle = 0;
        for (int i = 0; i < tasks.length; cycle++) {
            if (pq.isEmpty()) {
                queue.offer(1);
            } else {
                queue.offer(pq.poll() + 1);
                i++;
            }
            if (queue.size() > n) {
                int freq = queue.poll();
                if (freq < 0) pq.offer(freq);
            }
        }
        return cycle;
    }
}
