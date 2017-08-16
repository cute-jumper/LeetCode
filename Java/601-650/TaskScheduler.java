public class TaskScheduler {
        static class Task implements Comparable<Task> {
        int freq;
        Task(int freq) {
            this.freq = freq;
        }
        @Override
        public int compareTo(Task o) {
            return o.freq - freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i : tasks) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        PriorityQueue<Task> queue = new PriorityQueue<>();
        for (Character key : map.keySet()) {
            queue.offer(new Task(map.get(key)));
        }
        Deque<Task> waitQueue = new ArrayDeque<>();
        int count = tasks.length;
        int ticks = 0;
        while (count > 0) {
            ticks++;
            if (queue.isEmpty()) waitQueue.offer(new Task(-1));
            else {
                Task t = queue.poll();
                t.freq--;
                count--;
                waitQueue.offer(t);
            }
            if (waitQueue.size() > n) {
                Task t = waitQueue.poll();
                if (t.freq > 0) queue.offer(t);
            }
        }
        return ticks;
    }
}
