public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int quotient = 0;
        while (dividend <= divisor) {
            int div = divisor;
            int quo = 1;
            while (dividend - div <= div) {
                div += div;
                quo += quo;
            }
            dividend = dividend - div;
            quotient += quo;
        }
        return negative ? -quotient : quotient;
    }
}
