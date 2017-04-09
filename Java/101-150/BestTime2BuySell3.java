public class BestTime2BuySell3 {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE, oneSell = 0;
        int twoBuy = Integer.MIN_VALUE, twoSell = 0;
        for (int i = 0; i < prices.length; i++) {
            twoSell = Math.max(twoBuy + prices[i], twoSell);
            twoBuy = Math.max(oneSell - prices[i], twoBuy);
            oneSell = Math.max(oneBuy + prices[i], oneSell);
            oneBuy = Math.max(-prices[i], oneBuy);
        }
        return Math.max(oneSell, twoSell);
    }
}
