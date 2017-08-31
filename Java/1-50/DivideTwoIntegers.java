public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long d1 = Math.abs((long) dividend), d2 = Math.abs((long) divisor);
        long quot = 0;
        while (d1 >= d2) {
            long div = d2, q = 1;
            while (div + div <= d1) {
                div += div;
                q += q;
            }
            quot += q;
            d1 -= div;
        }
        if ((dividend > 0) != (divisor > 0)) quot = -quot;
        return quot == (int) quot ? (int) quot : Integer.MAX_VALUE;
    }
}
