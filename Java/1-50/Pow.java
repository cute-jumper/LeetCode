public class Pow {
    public double myPow(double x, int n) {
        double res = 1;
        double multiplier = x;
        boolean negative = n < 0;
        n = negative ? n : -n;
        while (n < 0) {
            if ((n & 1) == 1) {
                res *= multiplier;
            }
            n /= 2;
            multiplier *= multiplier;
        }
        return negative ? 1 / res : res;
    }
}
