public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxLen = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int len = 1; i + len <= height && j + len <= width; len++) {
                    if (check(matrix, i, j, len)) {
                        if (len > maxLen) maxLen = len;
                    } else {
                        break;
                    }
                }
            }
        }
        return maxLen * maxLen;
    }
    public boolean check(char[][] matrix, int row, int column, int len) {
        for (int i = row; i < row + len; i++) {
            if (matrix[i][column + len - 1] == '0') return false;
        }
        for (int j = column; j < column + len - 1; j++) {
            if (matrix[row + len - 1][j] == '0') return false;
        }
        return true;
    }
}
