public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int value = Math.abs(x);
        int maxValue = Integer.MAX_VALUE / 10;
        while (value > 0) {
            if (res > maxValue) {
                return 0;
            }
            int digit = value % 10;
            value /= 10;
            res *= 10;
            res += digit;
            if (res < 0) {
                return 0;
            }
        }
        if (x < 0) {
            return -res;
        }
        return res;
    }
}
