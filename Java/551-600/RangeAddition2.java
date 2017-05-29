public class RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m, minC = n;
        for (int[] op : ops) {
            if (op[0] < minR) minR = op[0];
            if (op[1] < minC) minC = op[1];
        }
        return minR * minC;
    }
}
