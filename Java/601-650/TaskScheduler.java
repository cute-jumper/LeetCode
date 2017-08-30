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
    }
}
