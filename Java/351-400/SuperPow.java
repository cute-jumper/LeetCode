public class SuperPow {
    // final int MOD = 1337;
    // public int superPow(int a, int[] b) {
    //     return superPow(a, b, b.length - 1);
    // }
    // int superPow(int a, int[] b, int end) {
    //     if (end == -1) return 1;
    //     a %= MOD;
    //     int c = b[end];
    //     int res = 1;
    //     for (int i = 0; i < c; i++) {
    //         res *= a;
    //         res %= MOD;
    //     }
    //     int d = res;
    //     for (int i = c; i < 10; i++) {
    //         d *= a;
    //         d %= MOD;
    //     }
    //     return res * (superPow(d, b, end - 1) % MOD) % MOD;
    // }
    public int superPow(int a, int[] b) {
        int[] res = new int[b.length];
        final int mod = 1337;
        Arrays.fill(res, 1);
        res[res.length - 1] = a % mod;
        for (int i = res.length - 2; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                res[i] *= res[i + 1];
                res[i] %= mod;
            }
        }
        int pow = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            int prod = 1;
            for (int j = 0; j < b[i]; j++) {
                prod *= res[i];
                prod %= mod;
            }
            pow *= prod;
            pow %= mod;
        }
        return pow;
    }
}
