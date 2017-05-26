public class RearrangeStringKDistanceApart {
    static class Char implements Comparable<Char> {
        char c;
        int freq;
        public Char(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
        @Override
        public int compareTo(Char other) {
            return other.freq - freq;
        }
    }
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        Char[] cs = new Char[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cs[c] == null) {
                cs[c] = new Char(c, 1);
            } else {
                cs[c].freq++;
            }
        }
        PriorityQueue<Char> queue = new PriorityQueue<>();
        for (Char c : cs) {
            if (c != null) {
                queue.offer(c);
            }
        }
        Deque<Char> wait = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Char c = queue.poll();
            sb.append(c.c);
            c.freq--;
            wait.offer(c);
            if (wait.size() == k) {
                c = wait.poll();
                if (c.freq > 0) queue.offer(c);
            }
        }
        while (!wait.isEmpty()) {
            if (wait.poll().freq != 0) return "";
        }
        return sb.toString();
    }
}
