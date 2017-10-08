class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                List<Integer> island = new ArrayList<>();
                dfs(grid, i * grid[i].length + j, i, j, island);
                set.add(island);
            }
        }
        return set.size();
    }
    void dfs(int[][] grid, int k, int i, int j, List<Integer> island) {
        int w = grid[0].length;
        island.add(i * w + j - k);
        grid[i][j] = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                dfs(grid, k, r, c, island);
            }
        }
    }
}
