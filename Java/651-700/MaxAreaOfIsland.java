class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length ==0 ) return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;

    }
    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int area = 1;
        int[][] dirs = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            area += dfs(grid, r, c);
        }
        return area;
    }
}
