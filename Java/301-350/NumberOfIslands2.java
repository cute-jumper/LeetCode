public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] island = new int[m * n];
        Arrays.fill(island, -1);
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] p : positions) {
            int root = p[0] * n + p[1];
            island[root] = root;
            cnt++;
            for (int[] dir : dirs) {
                int r = p[0] + dir[0];
                int c = p[1] + dir[1];
                int i = r * n + c;
                if (r >= 0 && r < m && c >= 0 && c < n && island[i] != -1) {
                    int rt = find(island, i);
                    if (rt != root) {
                        cnt--;
                        island[rt] = root;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
    public int find(int[] island, int i) {
        while (island[i] != i) {
            island[i] = island[island[i]];
            i = island[i];
        }
        return i;
    }
}
