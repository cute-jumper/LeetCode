public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i <<= 1) {
            for (int j = i; j < (i << 1) && j <= num; j++) {
                res[j] = res[j - i] + 1;
            }
        }
        return res;
    }
}
