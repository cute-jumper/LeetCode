public class WordSearch2 {
    static class Trie {
        String word;
        Trie[] children = new Trie[26];
        public Trie addChild(char ch) {
            Trie child = new Trie();
            children[ch - 'a'] = child;
            return child;
        }
        public Trie findChild(char ch) {
            return children[ch - 'a'];
        }
    }
    Trie root = new Trie();
    public void addWord(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie child = node.findChild(c);
            if (child == null) {
                node = node.addChild(c);
            } else {
                node = child;
            }
        }
        node.word = word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) return res;
        for (String word : words) addWord(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, root, i, j);
            }
        }
        return res;
    }
    public void dfs(List<String> res, char[][] board, Trie node, int r, int c) {
        char oldChar = board[r][c];
        node = node.findChild(oldChar);
        if (node == null) return;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[r][c] = '*';
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] != '*') {
                dfs(res, board, node, row, col);
            }
        }
        board[r][c] = oldChar;
    }
}
