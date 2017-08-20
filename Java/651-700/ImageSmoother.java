class Solution {
    public int[][] imageSmoother(int[][] M) {
           if (M.length == 0 || M[0].length == 0) return M;
        int h = M.length, w = M[0].length;
        int[][] res = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int s = 0, count = 0;
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < h && c >= 0 && c < w) {
                            count++;
                            s += M[r][c];
                        }
                    }
                }
                res[i][j] = s / count;
            }
        }
        return res;
    }
}
