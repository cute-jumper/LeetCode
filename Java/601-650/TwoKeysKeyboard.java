class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + i; j <= n; j += i) {
                dp[j] = dp[i] + j / i;
            }
        }
        return dp[n];
    }
}
