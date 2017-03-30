public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n == 2) return 91;
        int[] dp = new int[n];
        dp[0] = 10;
        dp[1] = 91;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + (10 - i) * (dp[i - 1] - dp[i - 2]);
        }
        return dp[n - 1];
    }
}
