public class KthSmallestLexicographical {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(n, current, current + 1);
            if (k >= steps) {
                k -= steps;
                current++;
            } else {
                k--;
                current *= 10;
            }
        }
        return current;
    }
    public int getSteps(long n, long current, long next) {
        long steps = 0;
        while (n >= current) {
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return (int)steps;
    }
}
