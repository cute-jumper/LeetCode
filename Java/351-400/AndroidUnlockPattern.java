public class AndroidUnlockPattern {
    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[9];
        return dfs(visited, 0, 0, 1, m, n) * 4 + dfs(visited, 0, 1, 1, m, n) * 4 +
            dfs(visited, 1, 1, 1, m, n);
    }
    public int dfs(boolean[] visited, int row, int col, int k, int m, int n) {
        int res = k >= m ? 1 : 0;
        if (k == n) return res;
        int x = row * 3 + col;
        visited[x] = true;
        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            int r = i / 3;
            int c = i % 3;
            int midR = row + r;
            int midC = col + c;
            int mid = midR / 2 * 3 + midC / 2;
            if (midR % 2 == 1 || midC % 2 == 1 || visited[mid]) {
                res += dfs(visited, r, c, k + 1, m, n);
            }
        }
        visited[x] = false;
        return res;
    }
}
