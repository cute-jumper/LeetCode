public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> current = new ArrayList<>();
        int[] dist = new int[wordList.size()];
        int depth = 2;
        current.add(beginWord);
        while (current.size() > 0) {
            List<String> next = new ArrayList<>();
            for (String word : current) {
                for (int i = 0; i < dist.length; i++) {
                    if (dist[i] == 0) {
                        String w = wordList.get(i);
                        if (strDistance(word, w) == 1) {
                            if (w.equals(endWord)) return depth;
                            dist[i] = depth;
                            next.add(wordList.get(i));
                        }
                    }
                }
            }
            current = next;
            depth++;
        }
        return 0;
    }

    public int strDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}
