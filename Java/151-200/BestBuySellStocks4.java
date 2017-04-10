public class BestBuySellStocks4 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        int maxVal = 0;
        if (k > prices.length / 2) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxVal += prices[i] - prices[i-1];
            }
            return maxVal;
        }
        maxVal = 0;
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k - 1; j >= 0; j--) {
                dp[j][1] = Math.max(dp[j][0] + prices[i], dp[j][1]);
                maxVal = Math.max(maxVal, dp[j][1]);
                if (j > 0)
                    dp[j][0] = Math.max(dp[j-1][1] - prices[i], dp[j][0]);
            }
            dp[0][0] = Math.max(-prices[i], dp[0][0]);
        }
        return maxVal;
    }
}
