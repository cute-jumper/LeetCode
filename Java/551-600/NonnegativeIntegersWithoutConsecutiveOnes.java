public class NonnegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        int[][] count = new int[32][2];
        count[0][0] = count[0][1] = 1;
        for (int i = 1; i < 32; i++) {
            count[i][0] = count[i - 1][0] + count[i - 1][1];
            count[i][1] = count[i - 1][0];
        }
        int n = num;
        int index = -1;
        for (; n != 0; index++, n >>= 1);
        int sum = 0;
        boolean cons = false;
        for (int i = index; i >= 0 && !cons; i--) {
            int curr = (1 << i) & num;
            int prev = (1 << (i + 1)) & num;
            if (curr != 0) {
                if (prev != 0) cons = true;
                sum += count[i][0];
            }
        }
        if (!cons) sum++;
        return sum;
    }
}
