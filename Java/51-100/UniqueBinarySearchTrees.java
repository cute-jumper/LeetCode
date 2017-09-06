public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1] += dp[j] * dp[i - j];
            }
        }
        return dp[n];
    }
}
