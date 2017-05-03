public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] adj = new int[26];
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                indegree[words[i].charAt(j) - 'a'] = 0;
            }
        }
        for (int i = 1; i < words.length; i++) {
            int len = Math.min(words[i-1].length(), words[i].length());
            for (int j = 0; j < len; j++) {
                int c1 = words[i-1].charAt(j) - 'a';
                int c2 = words[i].charAt(j) - 'a';
                if (c1 != c2) {
                    int v = adj[c1] | 1 << c2;
                    if (v != adj[c1]) {
                        adj[c1] = v;
                        indegree[c2]++;
                    }
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
            if (indegree[i] != -1) cnt++;
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            sb.append((char)('a' + i));
            for (int shift = 0, mask = 1; mask <= adj[i]; shift++, mask <<= 1) {
                if ((mask & adj[i]) != 0 && indegree[shift]-- == 1) queue.offer(shift);
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }
}
