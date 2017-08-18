public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ||
            obstacleGrid[0][0] == 1) return 0;
        int[] dp = new int[obstacleGrid[0].length + 1];
        dp[1] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (obstacleGrid[i][j - 1] == 1) dp[j] = 0;
                else dp[j] += dp[j - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
