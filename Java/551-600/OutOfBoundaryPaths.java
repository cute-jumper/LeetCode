public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] curr = new int[m + 2][n + 2];
        int[][] next = new int[m + 2][n + 2];
        curr[i + 1][j + 1] = 1;
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int total = 0;
        final int mod = 1000000007;
        for (int step = 0; step < N; step++) {
            for (i = 0; i <= m + 1; i++) {
                for (j = 0; j <= n + 1; j++) {
                    next[i][j] = 0;
                    for (int[] dir : dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if (r <= 0 || c <= 0 || r > m || c > n)
                            continue;
                        next[i][j] += curr[r][c];
                        next[i][j] %= mod;
                    }
                    if (i == 0 || i == m + 1 || j == 0 || j == n + 1) {
                        total += next[i][j];
                        total %= mod;
                    }
                }
            }
            int[][] tmp = curr;
            curr = next;
            next = tmp;
        }
        return total;
    }
}
