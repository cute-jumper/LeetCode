public class TaskScheduler {
    class Item implements Comparable<Item> {
        int freq;
        char c;
        Item(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }
        public int compareTo(Item a) {
            return a.freq - this.freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Deque<Item> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Item(entry.getValue(), entry.getKey()));
        }
        int count = tasks.length, res = tasks.length;
        while (count > 0) {
            if (pq.isEmpty()) {
                res++;
                queue.offer(new Item(0, '0'));
            } else {
                Item item = pq.poll();
                item.freq--;
                count--;
                queue.offer(item);
            }
            if (queue.size() > n) {
                Item next = queue.poll();
                if (next.freq != 0) pq.add(next);
            }
        }
        return res;
    }
}
