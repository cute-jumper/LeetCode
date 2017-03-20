public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 ||
            obstacleGrid[0].length == 0 ||
            obstacleGrid[0][0] == 1)
            return 0;
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (i == 0) {
                dp[0] = 1;
            } else if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < dp.length; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1) dp[j] = 0;
                    else dp[j] = dp[j - 1];
                } else {
                    if (obstacleGrid[i][j] == 1) dp[j] = 0;
                    else dp[j] += dp[j-1];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
