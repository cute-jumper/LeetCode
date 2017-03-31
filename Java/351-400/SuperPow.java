public class SuperPow {
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
