public class WordDictionary {

    static class TrieNode {
        char c;
        boolean end = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char c) {
            this.c = c;
        }
        public void setEnd() {
            end = true;
        }
        public boolean isEnd() {
            return end;
        }
        public TrieNode addChild(char c) {
            TrieNode child = new TrieNode(c);
            children[c - 'a'] = child;
            return child;
        }
        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
        public TrieNode[] getChildren() {
            return children;
        }
        public boolean match(char c) {
            return c == '.' || this.c == c;
        }
    }

    private TrieNode root = new TrieNode('\0');

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = node.getChild(c);
            if (child != null) {
                node = child;
            } else {
                node = node.addChild(c);
            }
        }
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        List<TrieNode> current = new ArrayList<>();
        current.add(root);
        int index = 0;
        while (index < word.length()) {
            char c = word.charAt(index);
            List<TrieNode> next = new ArrayList<>();
            for (TrieNode node : current) {
                if (c == '.') {
                    TrieNode[] children = node.getChildren();
                    for (int i = 0; i < children.length; i++) {
                        if (children[i] != null)
                            next.add(children[i]);
                    }
                } else {
                    TrieNode child = node.getChild(c);
                    if (child != null) {
                        next.add(child);
                    }
                }
            }
            current = next;
            index++;
        }
        for (TrieNode node : current) {
            if (node.isEnd()) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
