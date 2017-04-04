public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, visited, i * grid[0].length + j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, boolean[][] visited, int start) {
        int perimeter = 0;
        int height = grid.length;
        int width = grid[0].length;
        int startW = start % width;
        int startH = start / width;
        visited[startH][startW] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int w = startW + dirs[i][0];
            int h = startH + dirs[i][1];
            if (w >= 0 && w < width && h >= 0 && h < height && grid[h][w] == 1) {
                if (!visited[h][w]) {
                    perimeter += dfs(grid, visited, h * width + w);
                }
            } else {
                perimeter++;
            }
        }
        return perimeter;
    }
}
