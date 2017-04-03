public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n < 0) return -1;
        double r2 = Math.sqrt(2);
        int high = (int)Math.floor(r2 * Math.sqrt(n));
        for (int i = high; i >= 0; i--) {
            if (i * (i + 1) <= 2 * n)
                return i;
        }
        return 0;
    }
}
