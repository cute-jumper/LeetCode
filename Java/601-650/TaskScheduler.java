public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[256];
        int max = 0;
        for (char c : tasks) max = Math.max(max, count[c]++);
        int idle = max * (n + 1);
        for (int i : count) {
            if (i > 0) idle -= Math.min(max, i);
        }
        return tasks.length + (idle > 0 ? idle : 0);
        // int[] count = new int[256];
        // for (char c : tasks) count[c]++;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Deque<Integer> waitQueue = new ArrayDeque<>();
        // for (int i : count) {
        //     if (i != 0) pq.offer(i);
        // }
        // int cycle = tasks.length;
        // for (int i = 0; i < tasks.length;) {
        //     if (pq.isEmpty()) {
        //         waitQueue.offer(-1);
        //         cycle++;
        //     } else {
        //         waitQueue.offer(pq.poll() - 1);
        //         i++;
        //     }
        //     if (waitQueue.size() > n) {
        //         int freq = waitQueue.poll();
        //         if (freq > 0) pq.offer(freq);
        //     }
        // }
        // return cycle;
    }
}
