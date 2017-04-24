public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int longest = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, dfs(memo, matrix, i, j));
            }
        }
        return longest;
    }
    public int dfs(int[][] memo, int[][] matrix, int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];
        int[][] dirs = new int[][] {{0,-1},{1,0},{0,1},{-1,0}};
        int maxLen = 1;
        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] > matrix[r][c]) {
                maxLen = Math.max(maxLen, 1 + dfs(memo, matrix, row, col));
            }
        }
        memo[r][c] = maxLen;
        return maxLen;
    }
}
