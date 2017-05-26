public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        else if (n == 1) return k;
        int prev = 1, curr = k - 1;
        for (int i = 1; i < n - 1; i++) {
            int tmp = curr;
            curr = (prev + curr) * (k - 1);
            prev = tmp;
        }
        return (curr + prev) * k;
    }
}
