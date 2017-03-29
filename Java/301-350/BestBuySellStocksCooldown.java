public class BestBuySellStocksCooldown {
    public int maxProfit(int[] prices) {
        int s = 0, b = Integer.MIN_VALUE, prev = 0, oldSell = 0;
        for (int price : prices) {
            prev = oldSell;
            oldSell = s;
            s = Math.max(s, b + price);
            b = Math.max(prev - price, b);
        }
        return s;
    }
}
