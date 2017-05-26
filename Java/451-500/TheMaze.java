public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Deque<int[]> queue = new ArrayDeque<>();
        int height = maze.length, width = maze[0].length;
        queue.offer(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == destination[0] && p[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int r = p[0] + dir[0];
                int c = p[1] + dir[1];
                while (r >= 0 && r < height && c >= 0 && c < width && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (maze[r][c] != 2) {
                    maze[r][c] = 2;
                    queue.offer(new int[] {r, c});
                }
            }
        }
        return false;
    }
}
