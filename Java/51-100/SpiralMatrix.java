public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int width = m > n ? n : m;
        for (int i = 0; width - 2 * i > 0; i++) {
            for (int j = i; j < n - i; j++) res.add(matrix[i][j]);
            for (int j = i + 1; j < m - i; j++) res.add(matrix[j][n - 1 - i]);
            int row = m - 1 - i;
            if (row > i)
                for (int j = n - 2 - i; j >= i; j--)
                    res.add(matrix[row][j]);
            if (i < n - i - 1)
                for (int j = m - 2 - i; j > i; j--)
                    res.add(matrix[j][i]);
        }
        return res;
    }
}
