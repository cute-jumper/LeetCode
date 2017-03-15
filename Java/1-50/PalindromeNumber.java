public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int divisor = getLargestDivisor(x);
        while (divisor > 9) {
            if (x / divisor == x % 10) {
                x %= divisor;
                x /= 10;
                divisor /= 100;
            } else {
                return false;
            }
        }
        return true;
    }

    public int getLargestDivisor(int x) {
        int divisor = 1;
        while (x > 9) {
            x /= 10;
            divisor *= 10;
        }
        return divisor;
    }
}
