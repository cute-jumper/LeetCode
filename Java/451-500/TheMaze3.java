public class TheMaze3 {
    static class Point implements Comparable<Point> {
        int distance;
        String path;
        int r;
        int c;
        Point(int r, int c, int distance, String path) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.path = path;
        }
        @Override
        public int compareTo(Point o) {
            if (this.distance != o.distance) return this.distance - o.distance;
            return this.path.compareTo(o.path);
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        char[] labels = new char[] { 'u', 'd', 'l', 'r' };
        pq.add(new Point(ball[0], ball[1], 0, ""));
        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (visited[p.r][p.c]) continue;
            if (p.r == hole[0] && p.c == hole[1]) return p.path;
            visited[p.r][p.c] = true;
            for (int i = 0; i < dirs.length; i++) {
                int r = p.r + dirs[i][0];
                int c = p.c + dirs[i][1];
                int distance = p.distance;
                while (r >= 0 && r < height && c >= 0 && c < width && maze[r][c] == 0) {
                    distance++;
                    if (r == hole[0] && c == hole[1]) break;
                    r += dirs[i][0];
                    c += dirs[i][1];
                }
                if (r != hole[0] || c != hole[1]) {
                    r -= dirs[i][0];
                    c -= dirs[i][1];
                }
                if (!visited[r][c]) pq.add(new Point(r, c, distance, p.path + labels[i]));
            }
        }
        return "impossible";
    }
}
