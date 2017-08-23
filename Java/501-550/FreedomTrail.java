public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] memo = new int[ring.length()][key.length()];
        return dfs(memo, ring, 0, key, 0);
    }
    public int dfs(int[][] memo, String ring, int start, String key, int curr) {
        if (curr == key.length()) return 0;
        if (memo[start][curr] != 0) return memo[start][curr];
        char c = key.charAt(curr);
        int f = forward(ring, start, c);
        int b = backward(ring, start, c);
        memo[start][curr] = Math.min(dfs(memo, ring, (start + f) % ring.length(), key, curr + 1) + f + 1,
                                     dfs(memo, ring, (start - b + ring.length()) % ring.length(), key, curr + 1) + b + 1);
        return memo[start][curr];
    }
    public int forward(String ring, int start, char c) {
        for (int i = start, cnt = 0; cnt < ring.length(); cnt++, i++) {
            i = i % ring.length();
            if (ring.charAt(i) == c) return cnt;
        }
        return -1;
    }
    public int backward(String ring, int start, char c) {
        for (int i = start, cnt = 0; cnt < ring.length(); cnt++, i--) {
            if (i == -1) i += ring.length();
            if (ring.charAt(i) == c) return cnt;
        }
        return -1;
    }
}
