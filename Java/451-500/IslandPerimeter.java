public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int island = 0, connected = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i > 0 && grid[i - 1][j] == 1) connected++;
                    if (j > 0 && grid[i][j - 1] == 1) connected++;
                }
            }
        }
        return 4 * island - 2 * connected;
    }
}
