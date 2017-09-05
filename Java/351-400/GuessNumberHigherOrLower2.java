public class GuessNumberHigherOrLower2 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 0;
            dp[i][i + 1] = i + 1;
        }
        dp[n - 1][n - 1] = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                dp[j][j + i] = Math.min(dp[j + 1][j + i] + j + 1, dp[j][j + i - 1] + j + i + 1);
                for (int k = 1; k < i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i],
                                            j + k + 1 + Math.max(dp[j][j + k - 1], dp[j + k + 1][j + i]));
                }
            }
        }
        return dp[0][n - 1];
    }
}
