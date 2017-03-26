public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int height = board.length;
        int width = board[0].length;
        int[] iDirs = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] jDirs = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + iDirs[k];
                    int nj = j + jDirs[k];
                    if (ni >= 0 && nj >= 0 && ni < height && nj < width) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) live++;
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] &= 1;
            }
        }
    }
}
