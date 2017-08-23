public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') check(board, 0, i);
            if (height > 1 && board[height - 1][i] == 'O') check(board, height - 1, i);
        }
        for (int i = 1; i < height - 1; i++) {
            if (board[i][0] == 'O') check(board, i, 0);
            if (width > 1 && board[i][width - 1] == 'O') check(board, i, width - 1);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'Z') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void check(char[][] board, int y, int x) {
        int height = board.length;
        int width = board[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        board[y][x] = 'Z';
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(y * width + x);
        while (!queue.isEmpty()) {
            int index = queue.pop();
            int x1 = index % width;
            int y1 = index / width;
            for (int[] dir : dirs) {
                int x2 = x1 + dir[0];
                int y2 = y1 + dir[1];
                if (x2 >= 0 && x2 < width && y2 >= 0 && y2 < height) {
                    if (board[y2][x2] == 'O') {
                        board[y2][x2] = 'Z';
                        queue.add(y2 * width + x2);
                    }
                }
            }
        }
    }
}
