public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int height = matrix.length;
        int width = matrix[0].length;
        int[] res = new int[height * width];
        int[][] dirs = new int[][] { {1, -1}, {-1, 1} };
        int current = 0;
        int w = 0, h = 0;
        int index = 0;
        while (index < res.length) {
            while (w < width && w >= 0 && h < height && h >= 0) {
                res[index++] = matrix[h][w];
                w += dirs[current][0];
                h += dirs[current][1];
            }
            w -= dirs[current][0];
            h -= dirs[current][1];
            if (current == 0) {
                if (h == 0 && w < width - 1) {
                    w++;
                } else {
                    h++;
                }
            } else {
                if (w == 0 && h < height - 1) {
                    h++;
                } else {
                    w++;
                }
            }
            current ^= 1;
            System.out.println(index);
        }
        return res;
    }
}
