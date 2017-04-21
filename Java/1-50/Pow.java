public class Pow {
    public double myPow(double x, int n) {
        double curr = x;
        double res = 1;
        for (int i = n; i != 0; i /= 2, curr *= curr) {
            if ((i & 1) == 1)
                res *= curr;
        }
        return n >= 0 ? res : 1 / res;
    }
}
