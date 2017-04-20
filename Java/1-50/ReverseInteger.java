public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int next = res * 10 + x % 10;
            if (next / 10 != res) return 0;
            x /= 10;
            res = next;
        }
        return res;
    }
}
