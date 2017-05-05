public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[] colCount = new int[grid[0].length];
        int rowCount = 0;
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            rowCount = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || grid[i-1][j] == 'W') {
                    colCount[j] = 0;
                    for (int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCount[j]++;
                    }
                }
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < grid[0].length && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCount++;
                    }
                }
                if (grid[i][j] == '0') maxCount = Math.max(maxCount, rowCount + colCount[j]);
            }
        }
        return maxCount;
    }
}
