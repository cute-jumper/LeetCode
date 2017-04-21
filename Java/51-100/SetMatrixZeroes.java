public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0||
            matrix[0].length == 0)
            return;
        boolean col0 = false;
        for (int i = 0; i < matrix.length; i++) {
            col0 = col0 || matrix[i][0] == 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0) matrix[i][0] = 0;
        }
    }
}
