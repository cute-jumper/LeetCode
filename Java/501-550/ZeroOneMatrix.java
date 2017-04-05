public class ZeroOneMatrix {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<int[]> current = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.size()][matrix.get(0).size()];
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 0) {
                    current.add(new int[] { j, i });
                    visited[i][j] = true;
                }
            }
        }
        int dist = 1;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!current.isEmpty()) {
            List<int[]> next = new ArrayList<>();
            for (int[] p : current) {
                for (int[] dir : dirs) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (y >= 0 && y < matrix.size() && x >= 0 && x < matrix.get(y).size() &&
                        !visited[y][x] && matrix.get(y).get(x) == 1) {
                        next.add(new int[] { x, y });
                        visited[y][x] = true;
                        if (dist > 1) matrix.get(y).set(x, dist);
                    }
                }
            }
            current = next;
            dist++;
        }
        return matrix;
    }
}
