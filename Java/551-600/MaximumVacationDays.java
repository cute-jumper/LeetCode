public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[] curr = new int[n];
        int[] next = new int[n];
        Arrays.fill(curr, -1);
        curr[0] = 0;
        for (int i = 0; i < k; i++) {
            Arrays.fill(next, -1);
            for (int j = 0; j < n; j++) {
                if (curr[j] == -1) continue;
                for (int c = 0; c < n; c++) {
                    if (c == j || flights[j][c] == 1) {
                        next[c] = Math.max(curr[j] + days[c][i], next[c]);
                    }
                }
            }
            int[] tmp = curr;
            curr = next;
            next = tmp;
        }
        int max = 0;
        for (int i : curr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
