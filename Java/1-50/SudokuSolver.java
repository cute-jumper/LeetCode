public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        char c = (char)('1' + k);
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int r, int c, char n) {
        int upLeftRow = r / 3 * 3;
        int upLeftCol = c / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != '.' && board[r][i] == n) return false;
            if (board[i][c] != '.' && board[i][c] == n) return false;
            if (board[upLeftRow + i / 3][upLeftCol + i % 3] != '.' &&
                board[upLeftRow + i / 3][upLeftCol + i % 3] == n)
                return false;
        }
        return true;
    }
}
