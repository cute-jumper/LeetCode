public class TrappingRainWater2 {
    static class Bar implements Comparable<Bar> {
        int r;
        int c;
        int h;
        public Bar(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
        @Override
        public int compareTo(Bar that) {
            return this.h - that.h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<Bar> pq = new PriorityQueue<>();
        int height = heightMap.length;
        int width = heightMap[0].length;
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            pq.add(new Bar(i, 0, heightMap[i][0]));
            pq.add(new Bar(i, width - 1, heightMap[i][width - 1]));
            visited[i][0] = visited[i][width - 1] = true;
        }
        for (int i = 0; i < width; i++) {
            pq.add(new Bar(0, i, heightMap[0][i]));
            pq.add(new Bar(height - 1, i, heightMap[height - 1][i]));
            visited[0][i] = visited[height - 1][i] = true;
        }
        int total = 0;
        int[][] dirs = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
        while (!pq.isEmpty()) {
            Bar bar = pq.poll();
            for (int[] dir : dirs) {
                int r = bar.r + dir[0];
                int c = bar.c + dir[1];
                if (r >= 0 && r < height && c >= 0 && c < width && !visited[r][c]) {
                    visited[r][c] = true;
                    int h = heightMap[r][c];
                    if (h < bar.h) total += bar.h - h;
                    pq.add(new Bar(r, c, Math.max(bar.h, h)));
                }
            }
        }
        return total;
    }
}
