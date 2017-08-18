public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int height = matrix.length, width = matrix[0].length;
        int low = 0, high = height * width - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / width, c = mid % width;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
