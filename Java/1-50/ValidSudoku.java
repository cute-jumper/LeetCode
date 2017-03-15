public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] occur;
        for (int i = 0; i < board.length; i++) {
            occur = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int index = board[i][j] - '1';
                if (occur[index])
                    return false;
                occur[index] = true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            occur = new boolean[9];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.')
                    continue;
                int index = board[j][i] - '1';
                if (occur[index])
                    return false;
                occur[index] = true;
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                occur = new boolean[9];
                for (int row = i; row < i + 3; row++) {
                    for (int column = j; column < j + 3; column++) {
                        if (board[row][column] == '.')
                            continue;
                        int index = board[row][column] - '1';
                        if (occur[index])
                            return false;
                        occur[index] = true;
                    }
                }
            }
        }
        return true;
    }
}
