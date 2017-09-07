public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int height = matrix.length;
        int width = matrix[0].length;
        int[] res = new int[height * width];
        int[][] dirs = new int[][] { {-1, 1}, {1, -1} };
        int curr = 0;
        int w = 0, h = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[h][w];
            h += dirs[curr][0];
            w += dirs[curr][1];
            if (h >= height || h < 0 || w >= width || w < 0) curr ^= 1;
            if (h >= height) {
                h = height - 1;
                w += 2;
            }
            if (w >= width) {
                w = width - 1;
                h += 2;
            }
            if (h < 0) h = 0;
            if (w < 0) w = 0;
        }
        return res;
    }
}
