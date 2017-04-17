public class MaxSumOfRectangleNoLarger {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        int height = matrix.length;
        int width = matrix[0].length;
        boolean rowWise = true;
        if (height > width) {
            rowWise = false;
        }
        int minLen = rowWise ? height : width;
        int maxLen = rowWise ? width : height;
        for (int i = 0; i < minLen; i++) {
            for (int j = i; j < minLen; j++) {
                TreeSet<Integer> areaSet = new TreeSet<>();
                areaSet.add(0);
                int s = 0;
                for (int n = 0; n < maxLen; n++) {
                    for (int m = i; m <= j; m++) {
                        s += rowWise ? matrix[m][n] : matrix[n][m];
                    }
                    Integer v = areaSet.ceiling(s - k);
                    if (v != null) {
                        maxArea = Math.max(maxArea, s - v);
                    }
                    areaSet.add(s);
                }
            }
        }
        return maxArea;
    }
}
