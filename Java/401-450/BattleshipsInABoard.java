public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int count = 0;
        int maxY = board.length - 1;
        int maxX = board[0].length - 1;
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                if (board[i][j] == 'X') {
                    if (!(i > 0 && board[i - 1][j] == 'X' ||
                        j > 0 && board[i][j - 1] == 'X'))
                        count++;
                }
            }
        }
        return count;
    }
}
