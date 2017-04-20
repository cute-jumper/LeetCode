public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int y = i / 3 * 3;
            int x = i % 3 * 3;
            for (int k = 0; k < 3; k++) {
                boolean[] seen = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    int index;
                    if (k == 0) index = board[i][j];
                    else if (k == 1) index = board[j][i];
                    else index = board[y + j / 3][x + j % 3];
                    index -= '1';
                    if (index < 0 || index > 8) continue;
                    if (seen[index]) return false;
                    seen[index] = true;
                }
            }
        }
        return true;
    }
}
