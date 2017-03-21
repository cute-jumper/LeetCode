public class BestTime2BuySell {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minValue);
            }
        }
        return profit;
    }
}
