public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click);
        return board;
    }
    public void dfs(char[][] board, int[] click) {
        int ch = click[0];
        int cw = click[1];
        if (board[ch][cw] == 'M') {
            board[ch][cw] = 'X';
            return;
        }
        board[ch][cw] = 'B';
        int[][] dirs = new int[][] {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            int w = cw + dirs[i][0];
            int h = ch + dirs[i][1];
            if (w >= 0 && w < board[0].length && h >= 0 && h < board.length &&
                board[h][w] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[ch][cw] = (char)('0' + count);
            return;
        }
        for (int i = 0; i < dirs.length; i++) {
            int w = cw + dirs[i][0];
            int h = ch + dirs[i][1];
            if (w >= 0 && w < board[0].length && h >= 0 && h < board.length &&
                board[h][w] == 'E') {
                dfs(board, new int[] {h, w});
            }
        }
    }
}
