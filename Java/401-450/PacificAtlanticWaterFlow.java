public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int height = matrix.length;
        int width = matrix[0].length;
        Set<Integer> pacific = new HashSet<>();
        for (int w = 0; w < width; w++) {
            if (pacific.add(w))
                dfs(pacific, matrix, w);
        }
        for (int h = 1; h < height; h++) {
            if (pacific.add(h * width))
                dfs(pacific, matrix, h * width);
        }
        Set<Integer> atlantic = new HashSet<>();
        for (int w = 0; w < width; w++) {
            if (atlantic.add((height - 1) * width + w))
                dfs(atlantic, matrix, (height - 1) * width + w);
        }
        for (int h = 0; h < height - 1; h++) {
            if (atlantic.add(h * width + width - 1))
                dfs(atlantic, matrix, h * width + width - 1);
        }
        pacific.retainAll(atlantic);
        for (Integer i : pacific) {
            res.add(new int[] { i / width, i % width });
        }
        return res;
    }
    public void dfs(Set<Integer> reach, int[][] matrix, int start) {
        int[] wDirs = new int[] { -1, 0, 1, 0 };
        int[] hDirs = new int[] { 0, -1, 0, 1 };
        int height = matrix.length;
        int width = matrix[0].length;
        int startW = start % width;
        int startH = start / width;
        for (int i = 0; i < 4; i++) {
            int w = startW + wDirs[i];
            int h = startH + hDirs[i];
            if (w >= 0 && w < width && h >= 0 && h < height &&
                matrix[h][w] >= matrix[startH][startW] &&
                reach.add(h * width + w)) {
                dfs(reach, matrix, h * width + w);
            }
        }
    }
}
