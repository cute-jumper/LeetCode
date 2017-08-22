public class BestBuySellStocks4 {
    public int maxProfit(int k, int[] prices) {
        if (k * 2 >= prices.length) {
            int total = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) total += prices[i + 1] - prices[i];
            }
            return total;
        }
        int[] buy = new int[k], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i : prices) {
            for (int j = k - 1; j >= 0; j--) {
                sell[j + 1] = Math.max(sell[j + 1], buy[j] + i);
                buy[j] = Math.max(buy[j], sell[j] - i);
            }
        }
        return sell[k];
    }
}
