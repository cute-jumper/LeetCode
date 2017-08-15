public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                String s = queue.poll();
                if (s.equals(endWord)) return step;
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isOneDiff(s, wordList.get(j))) {
                        queue.offer(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }
            step++;
        }
        return 0;
    }
    boolean isOneDiff(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
