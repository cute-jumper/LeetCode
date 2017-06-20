public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (coins.length == 0) return amount == 0 ? 1 : 0;
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j >= coins[i]) dp[i][j] += dp[i][j - coins[i]];
            }
        }
        return dp[coins.length - 1][amount];
    }
}
