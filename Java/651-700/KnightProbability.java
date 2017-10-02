class KnightProbability {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = new int[][] {{-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        double[][] dp = new double[N][N];
        for (double[] row : dp) Arrays.fill(row, 1);
        double[][] next = new double[N][N];
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    next[i][j] = 0;
                    for (int[] dir : dirs) {
                        int row = i + dir[0], col = j + dir[1];
                        if (row >= 0 && row < N && col >= 0 && col < N) {
                            next[i][j] += dp[row][col];
                        }
                    }
                }
            }
            double[][] tmp = dp;
            dp = next;
            next = tmp;
        }
        return dp[r][c] / Math.pow(8, K);
    }
}
