public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num <= 1 ? num == 1 : num % 4 == 0 && isPowerOfFour(num / 4);
    }
}
