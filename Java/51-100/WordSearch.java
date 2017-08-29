public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, word, 0, new boolean[board.length][board[0].length])) return true;
            }
        }
        return false;
    }
    boolean search(char[][] board, int row, int col, String word, int start, boolean[][] visited) {
        if (board[row][col] != word.charAt(start)) return false;
        if (start == word.length() - 1) return true;
        visited[row][col] = true;
        int[][] dirs = new int[][] {{ 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }};
        for (int[] dir : dirs) {
            int r = row + dir[0], c = col + dir[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[r].length && !visited[r][c]) {
                if (search(board, r, c, word, start + 1, visited)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
