public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[] current = new int[k];
        int min1 = 0, min2 = 0;
        for (int i = 0; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int min = current[j] == min1 ? min2 : min1;
                current[j] = min + costs[i][j];
                if (current[j] < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = current[j];
                } else if (current[j] < newMin2) {
                    newMin2 = current[j];
                }
            }
            min1 = newMin1;
            min2 = newMin2;
        }
        return min1;
    }
}
