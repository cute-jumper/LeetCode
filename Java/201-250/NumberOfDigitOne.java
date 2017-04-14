public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        long nl = (long) n;
        long res = 0;
        long div = 1;
        while (nl >= div && div > 0) {
            long high = nl / 10 / div;
            long curr = nl / div % 10;
            if (curr > 1) {
                res += (high + 1) * div;
            } else if (curr == 1) {
                res += high * div + n % div + 1;
            } else {
                res += high * div;
            }
            div *= 10;
        }
        return (int)res;
    }
}
