public class NQueens2 {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return solve(board, n, 0);
    }
    public int solve(char[][] board, int n, int start) {
        if (start == n) return 1;
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, start)) {
                board[i][start] = 'Q';
                res += solve(board, n, start + 1);
                board[i][start] = 0;
            }
        }
        return res;
    }
    public boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 'Q') return false;
        }
        for (int row = r - 1, col = c - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q') return false;
        }
        for (int row = r + 1, col = c - 1; row < board.length && col >= 0; row++, col--) {
            if (board[row][col] == 'Q') return false;
        }
        return true;
    }
}
