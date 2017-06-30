public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (div <= x / 10) div *= 10;
        for (int i = x; div > 9; i = (i % div) / 10, div /= 100) {
            if (i % 10 != i / div) return false;
        }
        return true;
    }
}
