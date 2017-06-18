public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] add = new int[length];
        for (int[] update : updates) {
            if (update[0] > 0) {
                add[update[0] - 1] -= update[2];
            }
            add[update[1]] += update[2];
        }
        int total = 0;
        for (int i = length - 1; i >= 0; i--) {
            total += add[i];
            add[i] = total;
        }
        return add;
    }
}
