public class LongestLineOfOnesMatrix {
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int[][] dp = new int[M[0].length + 2][4];
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            int tmp = 0;
            for (int j = 0; j < M[0].length; j++) {
                int diag = dp[j + 1][2];
                if (M[i][j] == 0) Arrays.fill(dp[j + 1], 0);
                else {
                    dp[j + 1][0] = dp[j][0] + 1;
                    dp[j + 1][1] = dp[j + 1][1] + 1;
                    dp[j + 1][2] = tmp + 1;
                    dp[j + 1][3] = dp[j + 2][3] + 1;
                }
                tmp = diag;
                for (int k = 0; k < dp[j + 1].length; k++) max = Math.max(max, dp[j + 1][k]);
            }
        }
        return max;
    }
}
