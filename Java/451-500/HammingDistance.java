public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((xor & 1) == 1) res++;
            xor >>>= 1;
        }
        return res;
    }
}
