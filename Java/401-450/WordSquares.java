public class WordSquares {
    Trie root = new Trie();
    public List<List<String>> wordSquares(String[] words) {
        for (String w : words) root.addWord(w);
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), words[0].length());
        return res;
    }
    public void dfs(List<List<String>> res, List<String> current, int n) {
        if (current.size() == n) {
            res.add(new ArrayList<>(current));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        int col = current.size();
        for (String s : current) {
            prefix.append(s.charAt(col));
        }
        List<String> ws = root.searchPrefix(prefix.toString());
        for (String w : ws) {
            current.add(w);
            dfs(res, current, n);
            current.remove(current.size() - 1);
        }
    }
    private static class Trie {
        Trie[] children = new Trie[26];
        List<String> words = new ArrayList<>();
        public Trie addChild(char c) {
            children[c - 'a'] = new Trie();
            return children[c - 'a'];
        }
        public Trie getChild(char c) {
            return children[c - 'a'];
        }
        public void addWord(String s) {
            Trie node = this;
            node.words.add(s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.getChild(c) == null) node.addChild(c);
                node = node.getChild(c);
                node.words.add(s);
            }
        }
        public List<String> searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length() && node != null; i++) {
                node = node.getChild(prefix.charAt(i));
            }
            if (node == null) return new ArrayList<>();
            return node.words;
        }
    }
}
