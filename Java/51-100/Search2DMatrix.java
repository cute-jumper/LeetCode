public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high + 1) / 2;
            int value = matrix[mid][0];
            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0 || matrix[high][0] > target) return false;
        int row = high;
        low = 0;
        high = matrix[low].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = matrix[row][mid];
            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
