public class TheMaze2 {
    static class Point implements Comparable<Point> {
        int dist;
        int r;
        int c;
        public Point(int dist, int r, int c) {
            this.dist = dist;
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Point other) {
            return dist - other.dist;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(0, start[0], start[1]));
        int height = maze.length, width = maze[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (maze[p.r][p.c] == 2) continue;
            maze[p.r][p.c] = 2;
            if (p.r == destination[0] && p.c == destination[1]) {
                return p.dist;
            }
            for (int[] dir : dirs) {
                int r = p.r + dir[0];
                int c = p.c + dir[1];
                int dist = p.dist;
                while (r >= 0 && r < height && c >= 0 && c < width && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                    dist++;
                }
                r -= dir[0];
                c -= dir[1];
                if (dist > p.dist) {
                    queue.offer(new Point(dist, r, c));
                }
            }
        }
        return -1;
    }
}
