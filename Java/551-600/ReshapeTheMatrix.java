public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int height = nums.length;
        int width = nums[0].length;
        if (r * c != height * width) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index =  i * c + j;
                int row = index / width;
                int col = index % width;
                res[i][j] = nums[row][col];
            }
        }
        return res;
    }
}
