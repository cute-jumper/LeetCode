public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n <= 1 ? n == 1 : n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
