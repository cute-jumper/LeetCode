public class Solution {
    public int newInteger(int n) {
        int res = 0, mult = 1;
        while (n > 0) {
            res += mult * (n % 9);
            n /= 9;
            mult *= 10;
        }
        return res;
    }
}
