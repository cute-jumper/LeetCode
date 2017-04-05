public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int total = 0;
        for (int i = (int)Math.floor(Math.sqrt(num)); i > 0; i--) {
            if (num % i == 0) {
                total += i + num / i;
            }
        }
        return total - num == num;
    }
}
