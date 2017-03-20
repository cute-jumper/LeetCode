public class UniquePaths {
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        if (m == 0 || n == 0) return 1;
        long denom = 1;
        long nomen = 1;
        int minValue = Math.min(m, n);
        int start = m + n - minValue + 1;
        for (int i = 0; i < minValue; i++) {
            denom *= start;
            nomen *= minValue - i;
            if (denom % nomen == 0) {
                denom /= nomen;
                nomen = 1;
            }
            start++;
        }
        return (int)(denom / nomen);
    }
}
