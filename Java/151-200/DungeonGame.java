public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                int loss = -dungeon[i][j];
                if (i == dp.length - 1 && j == dp[i].length - 1) dp[i][j] = Math.max(loss, 0) + 1;
                else if (i == dp.length - 1) dp[i][j] = Math.max(dp[i][j+1] + loss, 1);
                else if (j == dp[i].length - 1) dp[i][j] = Math.max(dp[i+1][j] + loss, 1);
                else dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) + loss, 1);
            }
        }
        return dp[0][0];
    }
}
