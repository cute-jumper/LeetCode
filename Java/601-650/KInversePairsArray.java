public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        final int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m < i && m <= k - j; m++) {
                    dp[i][m + j] = (int) (((long)dp[i][m + j] + dp[i - 1][j]) % mod);
                }
            }
        }
        return dp[n][k];
    }
}
