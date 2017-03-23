public class Trie {

    static class TrieNode {
        char c;
        List<TrieNode> children = new ArrayList<>();
        boolean endFlag;
        public TrieNode(char c) {
            this.c = c;
        }
        public TrieNode addChild(char c) {
            TrieNode child = new TrieNode(c);
            children.add(child);
            return child;
        }
        public TrieNode findChild(char c) {
            for (TrieNode node : children) {
                if (node.match(c)) return node;
            }
            return null;
        }
        public boolean match(char c) {
            return this.c == c;
        }
        public void setEnd() {
            endFlag = true;
        }
        public boolean isEnd() {
            return endFlag;
        }
    }

    TrieNode root = new TrieNode('\0');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = node.findChild(c);
            if (child == null) {
                node = node.addChild(c);
            } else {
                node = child;
            }
        }
        if (!node.isEnd()) node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    private TrieNode findNode(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = node.findChild(prefix.charAt(i));
            if (child == null) return null;
            node = child;
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
