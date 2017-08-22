class WordLadder2 {
    static class Item {
        String s;
        int dist;
        List<Item> parents;
        Item(String s, int dist) {
            this.s = s;
            this.dist = dist;
            this.parents = new ArrayList<>();
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Item[] words = new Item[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) words[i] = new Item(wordList.get(i), 0);
        Deque<Item> queue = new ArrayDeque<>();
        queue.offer(new Item(beginWord, 1));
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                Item item = queue.poll();
                if (item.s.equals(endWord)) {
                    backtrack(res, new ArrayList<>(), item);
                    return res;
                }
                for (Item w : words) {
                    if (isOneDist(w.s, item.s) && (w.dist == 0 || w.dist == item.dist + 1)) {
                        if (w.dist == 0) {
                            w.dist = item.dist + 1;
                            queue.offer(w);
                        }
                        w.parents.add(item);
                    }
                }
            }
        }
        return res;
    }
    void backtrack(List<List<String>> res, List<String> curr, Item item) {
        curr.add(item.s);
        if (item.parents.isEmpty()) {
            List<String> path = new ArrayList<>(curr);
            Collections.reverse(path);
            res.add(path);
        } else {
            for (Item i : item.parents) {
                backtrack(res, curr, i);
            }
        }
        curr.remove(curr.size() - 1);
    }
    boolean isOneDist(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
