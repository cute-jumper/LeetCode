public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        int[] genes = new int[bank.length];
        for (int i = 0 ; i < genes.length; i++) genes[i] = s2i(bank[i]);
        boolean[] visited = new boolean[bank.length];
        Deque<Integer> queue = new ArrayDeque<>();
        int istart = s2i(start);
        int iend = s2i(end);
        queue.add(istart);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                if (v == iend) return dist;
                for (int j = 0; j < genes.length; j++) {
                    if (!visited[j] && isOneDist(v, genes[j])) {
                        visited[j] = true;
                        queue.offer(genes[j]);
                    }
                }
            }
            dist++;
        }
        return -1;
    }
    private int s2i(String s) {
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            v <<= 4;
            if (c == 'A') v |= 1;
            else if (c == 'C') v |= 2;
            else if (c == 'G') v |= 4;
            else if (c == 'T') v |= 8;
        }
        return v;
    }
    private boolean isOneDist(int a, int b) {
        int c = a & b;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if ((c & 15) > 0) cnt++;
            c >>= 4;
        }
        return cnt == 7;
    }
}
