public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; n - 2 * i > 0; i++) {
            for (int c = i; c <= n - i - 1; c++) {
                matrix[i][c] = num;
                num++;
            }
            for (int r = i + 1; r < n - 1 - i; r++) {
                matrix[r][n - i - 1] = num;
                num++;
            }
            for (int c = n - 1 - i; c > i; c--) {
                matrix[n - 1 - i][c] = num;
                num++;
            }
            for (int r = n - 1 - i; r > i; r--) {
                matrix[r][i] = num;
                num++;
            }
        }
        return matrix;
    }
}
