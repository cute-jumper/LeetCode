public class NumMatrix {
    int[][] bit;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        bit = new int[matrix.length + 1][matrix[0].length + 1];
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    private int lowBit(int x) {
        return x & (-x);
    }
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i < bit.length; i += lowBit(i)) {
            for (int j = col + 1; j < bit[0].length; j += lowBit(j)) {
                bit[i][j] += diff;
            }
        }
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= lowBit(i)) {
            for (int j = col + 1; j > 0; j -= lowBit(j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
