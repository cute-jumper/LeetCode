public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        int total = 0;
        while (n >= 5) {
            n /= 5;
            total += n;
        }
        return total;
    }
}
