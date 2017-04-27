public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        Deque<int[]> current = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    current.offerLast(new int[] { j, i });
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!current.isEmpty()) {
            int[] p = current.pollFirst();
            int dist = matrix[p[1]][p[0]] + 1;
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (y >= 0 && y < matrix.length && x >= 0 && x < matrix[y].length &&
                    matrix[y][x] > dist) {
                    current.offerLast(new int[] { x, y });
                    matrix[y][x] = dist;
                }
            }
        }
        return matrix;
    }
}
