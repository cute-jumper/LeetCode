public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] dist = new int[height][width];
        int cnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) bfs(dist, grid, i, j, --cnt);
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == cnt) shortest = Math.min(shortest, dist[i][j]);
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    public void bfs(int[][] dist, int[][] grid, int row, int col, int mark) {
        int height = grid.length;
        int width = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { row, col });
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + p[0];
                    int c = dir[1] + p[1];
                    if (r >= 0 && r < height && c >= 0 && c < width && grid[r][c] == mark + 1) {
                        queue.offer(new int[] { r, c });
                        grid[r][c] = mark;
                        dist[r][c] += step;
                    }
                }
            }
            step++;
        }
    }
}
