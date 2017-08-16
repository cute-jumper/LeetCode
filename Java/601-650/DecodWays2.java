public class DecodWays2 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        long e = 1, e1 = 0, e2 = 0, mod = 1000000007;
        for (char c : s.toCharArray()) {
            long f = 0, f1 = 0, f2 = 0;
            if (c == '*') {
                f = (9 * e) % mod + (9 * e1) % mod + (6 * e2) % mod;
                f1 = f2 = e;
            } else {
                f = e1;
                if (c > '0') f = (f + e) % mod;
                if (c <= '6') f = (f + e2) % mod;
                if (c == '1') f1 = e;
                else if (c == '2') f2 = e;
            }
            e = f % mod;
            e1 = f1;
            e2 = f2;
        }
        return (int) e;
    }
}
