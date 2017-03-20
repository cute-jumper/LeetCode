public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0||
            matrix[0].length == 0)
            return;
        boolean[] rowFlags = new boolean[matrix.length];
        boolean[] columnFlags = new boolean[matrix[0].length];
        for (int i = 0; i < rowFlags.length; i++) {
            for (int j = 0; j < columnFlags.length; j++) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = true;
                    columnFlags[j] = true;
                }
            }
        }
        for (int i = 0; i < rowFlags.length; i++) {
            if (rowFlags[i]) {
                for (int j = 0; j < columnFlags.length; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < columnFlags.length; i++) {
            if (columnFlags[i]) {
                for (int j = 0; j < rowFlags.length; j++)
                    matrix[j][i] = 0;
            }
        }
    }
}
