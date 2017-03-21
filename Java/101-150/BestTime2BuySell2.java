public class BestTime2BuySell2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0];
        int prev = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prev) {
                if (prev > minValue) {
                    profit += prev - minValue;
                }
                minValue = prices[i];
            }
            prev = prices[i];
        }
        return profit + prev - minValue;
    }
}
