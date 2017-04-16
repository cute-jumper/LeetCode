public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long val = Long.parseLong(n);
        int maxN = (int)(Math.log(val) / Math.log(2)) + 1;
        for (int i = maxN; i > 1; i--) {
            int q = (int)Math.pow(val, 1.0/i);
            if (q > 1) {
                long s = 0, c = 1;
                for (int j = 0; j <= i; j++) {
                    s += c;
                    c *= q;
                }
                if (s == val) return q + "";
            }
        }
        return val - 1 + "";
    }
}
