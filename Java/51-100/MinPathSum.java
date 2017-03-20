public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 ||
            grid[0].length == 0)
            return 0;
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < dp.length; j++) {
                if (i == 0) {
                    dp[j] = dp[j - 1] + grid[0][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
