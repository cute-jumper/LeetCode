public class FindTheDerangementOfArray {
    public int findDerangement(int n) {
        int a = 0, b = 1;
        if (n == 1) return a;
        if (n == 2) return b;
        final int mod = 1000000007;
        for (int i = 2; i < n; i++) {
            int t = (int)(((long)(a + b) % mod) * i % mod);
            a = b;
            b = t;
        }
        return b;
    }
}
