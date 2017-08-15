public class Trie {

    /** Initialize your data structure here. */
    Trie[] children;
    boolean isWord;
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }

    Trie getOrAddChild(char c) {
        if (!hasChild(c)) children[c - 'a'] = new Trie();
        return children[c - 'a'];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.getOrAddChild(c);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = find(word);
        return node != null && node.isWord;
    }

    Trie find(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.hasChild(c)) node = node.getOrAddChild(c);
            else return null;
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
