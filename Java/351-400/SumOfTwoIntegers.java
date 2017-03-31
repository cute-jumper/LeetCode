public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int a1 = a & (1 << i);
            int b1 = b & (1 << i);
            sum |= a1 ^ b1 ^ carry;
            carry = ((a1 & b1) | (a1 & carry) | (b1 & carry)) << 1;
        }
        return sum;
    }
}
