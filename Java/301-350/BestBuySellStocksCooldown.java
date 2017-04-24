public class BestBuySellStocksCooldown {
    public int maxProfit(int[] prices) {
        int s = 0, b = Integer.MIN_VALUE, prev2 = 0, prev1 = 0;
        for (int price : prices) {
            prev2 = prev1;
            prev1 = s;
            s = Math.max(s, b + price);
            b = Math.max(prev2 - price, b);
        }
        return s;
    }
}
