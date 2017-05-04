public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Deque<int[]> queue = new ArrayDeque<>();
        int height = rooms.length;
        int width = rooms[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int h = p[0] + dir[0];
                int w = p[1] + dir[1];
                if (h >= 0 && h < height && w >= 0 && w < width && rooms[h][w] == Integer.MAX_VALUE) {
                    rooms[h][w] = rooms[p[0]][p[1]] + 1;
                    queue.offer(new int[] { h, w });
                }
            }
        }
    }
}
