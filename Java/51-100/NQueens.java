public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, board, n, 0);
        return res;
    }
    public void solve(List<List<String>> res, char[][] board, int n, int start) {
        if (start == n) {
            List<String> boardStr = new ArrayList<>();
            for (char[] row : board) {
                boardStr.add(new String(row));
            }
            res.add(boardStr);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, start)) {
                board[i][start] = 'Q';
                solve(res, board, n, start + 1);
                board[i][start] = '.';
            }
        }
    }
    public boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 'Q') return false;
        }
        for (int row = r - 1, col = c - 1; row >= 0 && col >= 0; row--,col--) {
            if (board[row][col] == 'Q') return false;
        }
        for (int row = r + 1, col = c - 1; row < board.length && col >= 0; row++, col--) {
            if (board[row][col] == 'Q') return false;
        }
        return true;
    }
}
