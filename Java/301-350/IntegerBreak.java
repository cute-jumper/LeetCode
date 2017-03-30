public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        int[] products = new int[n + 1];
        products[1] = 1;
        products[2] = 1;
        products[3] = 2;
        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0) {
                products[i] = Math.max(i - 3, products[i - 3]) * 3;
            } else if (i % 2 == 0) {
                products[i] = Math.max(i - 2, products[i - 2]) * 2;
            } else {
                int half = i / 2;
                products[i] = Math.max(products[half], half) * Math.max(products[i - half], i - half);
            }
        }
        return products[n];
    }
}
