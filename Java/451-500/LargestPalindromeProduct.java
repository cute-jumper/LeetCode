public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        long low = (long) Math.pow(10, n - 1), high = 10 * low - 1;
        long half = (high * high) / (high + 1);
        long mod = 1337;
        while (half >= low) {
            long[] ps = getPalindromes(half, n);
            for (long p : ps) {
                for (long i = high; i >= low && i * i >= p; i--) {
                    if (p % i == 0) {
                        return (int) (p % mod);
                    }
                }
            }
            half--;
        }
        return 0;
    }
    long[] getPalindromes(long half, int n) {
        String s = half + "";
        String r = new StringBuilder(s).reverse().toString();
        if (s.length() == n) {
            return new long[] { Long.parseLong(s + r) };
        }
        long[] res = new long[10];
        for (int i = 9; i >= 0; i--) {
            res[9 - i] = Long.parseLong(s + i + r);
        }
        return res;
    }
}
