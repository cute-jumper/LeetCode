public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int row = board.length;
        int column = board[0].length;
        boolean[][] flags = new boolean[board.length][board[0].length];
        char c = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == c) {
                    flags[i][j] = true;
                    boolean match = wordSearch(board, word, 1, j, i, flags);
                    if (match) return true;
                    flags[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean wordSearch(char[][] board, String word, int start,
                              int x, int y, boolean[][] flags) {
        if (start == word.length()) {
            return true;
        }
        int[] xDirs = new int[] {-1, 0, 1, 0};
        int[] yDirs = new int[] {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + xDirs[i];
            int nextY = y + yDirs[i];
            if (nextX >= 0 && nextX < board[0].length &&
                nextY >=0 && nextY < board.length &&
                board[nextY][nextX] == word.charAt(start) &&
                !flags[nextY][nextX]) {
                flags[nextY][nextX] = true;
                boolean match = wordSearch(board, word, start + 1, nextX, nextY, flags);
                if (match) return true;
                flags[nextY][nextX] = false;
            }
        }
        return false;
    }
}
