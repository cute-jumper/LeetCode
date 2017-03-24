public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int test = 1;
        for (int i = 0; i < 31; i++) {
            if (test == n) return true;
            test <<= 1;
        }
        return false;
    }
}
