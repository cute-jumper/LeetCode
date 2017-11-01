class BestBuyAndSellWithFee {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int i : prices) {
            int prev = sell;
            sell = Math.max(sell, buy + i);
            buy = Math.max(buy, prev - i - fee);
        }
        return sell;
    }
}
