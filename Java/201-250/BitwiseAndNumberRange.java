public class BitwiseAndNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m & n;
        int and = m & n;
        int highBit = Integer.MIN_VALUE;
        int mask = Integer.MIN_VALUE;
        while ((m & highBit) == (n & highBit)) {
            mask >>= 1;
            m <<= 1;
            n <<= 1;
        }
        return (mask << 1) & and;
    }
}
